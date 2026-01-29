import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/* 조건
제한 시간: 1초
M 배열의 값 하나하나 N 배열이랑 비교해서 찾아내야 하기 때문에, O(nm)이 나옴
그러나 500,000이기 때문에 시간 초과 발생
따라서 이분 탐색으로 O(nlogm)으로 풀어야 함
&&
특정 값이 여러 개 있을 수 있으면서, "개수"를 구하는 경우 Lower/Upper Bound를 사용해서 범위를 찾아내야 한다.
값이 들어갈 "위치"를 찾는 경우도 마찬가지이다.
*/

/* 풀이 방법 - 이분 탐색(O(logn))
Lower Bound로 시작지점을 찾고, Uppder Bound로 끝지점을 찾아서 개수를 구하면 O(logn)으로 탐색 가능
✅찾고자 하는 값이 없을 경우 배열 마지막 인덱스+1을 반환해야 하기 때문에 high는 n-1이 아닌 n을 줘야 함
*/

// ❌ 2026.01.29
// 구현 시간: Upper/Lower Bound 개념 보고 해서 안잼
public class _10816_숫자카드2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 500,000
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) cards[i] = Integer.parseInt(st.nextToken()); // -10,000,000 <= cards[i] <= 10,000,000
        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 500,000
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            // ✅high는 n-1이 아닌 n이다.
            // ✅찾고자 하는 값이 없을 때 인덱스 n을 반환해야 하기 때문
            int cnt = upperBound(cards, target, 0, n) - lowerBound(cards, target, 0, n);
            sb.append(cnt).append(" ");
        }


        System.out.println(sb.toString().trim());
    }

    static int lowerBound(int[] cards, int target, int low, int high) {
        

        while (low < high) {
            int midIndex = (low + high) / 2;
            if (cards[midIndex] < target) {
                low = midIndex+1;
            } else {
                high = midIndex;
            }
        }
        return high;
        
    }

    static int upperBound(int[] cards, int target, int low, int high) {
        

        while (low < high) {
            int midIndex = (low + high) / 2;
            if (cards[midIndex] <= target) {
                low = midIndex+1;
            } else {
                high = midIndex;
            }
        }
        return high;
        
    }
}

/* 조건
제한 시간: 1초
M 배열의 값 하나하나 N 배열이랑 비교해서 찾아내야 하기 때문에, O(nm)이 나옴
그러나 500,000이기 때문에 시간 초과 발생
따라서 이분 탐색으로 O(nlogm)으로 풀어야 함
*/

/* ❌ 풀이 방법 - 이분 탐색(O(logn)) ❌
b 배열의 값 하나하나 a 배열에 있는지 탐색
이때 순차 탐색의 경우 O(nm)으로 시간 초과가 발생하므로, 이분 탐색을 진행해야하고 이분 탐색을 위해 a배열을 정렬한 뒤 탐색을 진행한다.

✅이 방식은 cards와 target 값이 모두 같을 경우 O(logn)이 아닌 O(n)까지 떨어질 수 있음. (계속 양옆 탐색하면 이분탐색 의미가 없음)
*/

// 2026.01.29
// 구현 시간: 25분 (❌틀림❌)
/*
public class _10816_숫자카드2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 500,000
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) cards[i] = Integer.parseInt(st.nextToken()); // -10,000,000 <= cards[i] <= 10,000,000
        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 500,000
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            int cnt = binarySearch(cards, target, 0, n-1, 0);
            sb.append(cnt).append(" ");
        }


        System.out.println(sb.toString().trim());
    }

    static int binarySearch(int[] cards, int target, int low, int high, int cnt) {

        if (low > high) return cnt;
            
        int midIndex = (low + high) /2 ;
        int mid = cards[midIndex];

        if (mid == target) {
            // 아래처럼 후위 연산자로 넣으면, 더하기 전 값이 들어가서 값이 제대로 안나옴;;;;;;;;;;
            // cnt = binarySearch(cards, target, low, midIndex-1, cnt);
            // cnt = binarySearch(cards, target, midIndex+1, high, cnt); 

            cnt++;
            cnt = binarySearch(cards, target, low, midIndex-1, cnt);
            cnt = binarySearch(cards, target, midIndex+1, high, cnt);
        }
        else if (target < mid) {
            cnt = binarySearch(cards, target, low, midIndex-1, cnt);
        } else {
            cnt = binarySearch(cards, target, midIndex+1, high, cnt);
        }
        
        return cnt;
    }
}
*/


/*
public class _10816_숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(cnt(cards, n, num) + " ");
        }

        System.out.println(sb.toString().trim());
    }

    public static int cnt(int[] arr, int arrSize, int target) {
        return upperBound(arr, target, 0, arrSize) - lowerBound(arr, target, 0, arrSize);

    }

    public static int upperBound(int[] arr, int target, int left, int right) {
        if (left >= right) return right;

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (midVal > target) {
            return upperBound(arr, target, left, mid);
        } else {
            return upperBound(arr, target, mid + 1, right);
        }
    }

    public static int lowerBound(int[] arr, int target, int left, int right) {
        if (left >= right) return right;

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (midVal >= target) {
            return lowerBound(arr, target, left, mid);
        } else {
            return lowerBound(arr, target, mid + 1, right);
        }
    }
}
*/

/** lowerBound, upperBound 방식으로 탐색 진행(이진 탐색 기반 방법)
 * 가지고 있는 숫자 카드의 개수 = upperBound - lowerBound
*/
// public class _10816_숫자카드2 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         int n = Integer.parseInt(br.readLine());
//         int[] cards = new int[n];
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < n; i++) {
//             cards[i] = Integer.parseInt(st.nextToken());
//         }
//         Arrays.sort(cards);

//         StringBuilder sb = new StringBuilder();
//         int m = Integer.parseInt(br.readLine());
//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < m; i++) {
//             int num = Integer.parseInt(st.nextToken());
//             sb.append(cnt(cards, n, num) + " ");
//         }

//         System.out.println(sb.toString().trim());
//     }

//     public static int cnt(int[] arr, int arrSize, int target) {
//         return upperBound(arr, target, 0, arrSize) - lowerBound(arr, target, 0, arrSize);

//     }

//     public static int upperBound(int[] arr, int target, int left, int right) {
//         if (left >= right) return right;

//         int mid = (left + right) / 2;
//         int midVal = arr[mid];

//         if (midVal > target) {
//             return upperBound(arr, target, left, mid);
//         } else {
//             return upperBound(arr, target, mid + 1, right);
//         }
//     }

//     public static int lowerBound(int[] arr, int target, int left, int right) {
//         if (left >= right) return right;

//         int mid = (left + right) / 2;
//         int midVal = arr[mid];

//         if (midVal >= target) {
//             return lowerBound(arr, target, left, mid);
//         } else {
//             return lowerBound(arr, target, mid + 1, right);
//         }
//     }
// }

/** 재귀 방식으로 이진 탐색을 진행
 * 최악의 경우 배열 전체를 순회해야 할 수도 있음
 * ex. [5 5 5 5 5 5 5] 배열에서 5의 개수를 찾는 경우 배열을 전부 순회해야 함
*/
// public class _10816_숫자카드2 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         int n = Integer.parseInt(br.readLine());
//         int[] cards = new int[n];
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < n; i++) {
//             cards[i] = Integer.parseInt(st.nextToken());
//         }
//         Arrays.sort(cards);

//         StringBuilder sb = new StringBuilder();
//         int m = Integer.parseInt(br.readLine());
//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < m; i++) {
//             int num = Integer.parseInt(st.nextToken());
//             int cnt = 0;
//             cnt = binarySearchIterative(cards, num, 0, n-1, cnt);
//             sb.append(cnt + " ");
//         }

//         System.out.println(sb.toString().trim());
//     }

//     // -10 -10 2 3 3 6 7 10 10 10
//     public static int binarySearchIterative(int[] arr, int target, int low, int high, int cnt) {
//         // 종료 조건
//         if (low > high) return cnt;

//         int mid = (low + high) / 2;
//         int midVal = arr[mid];

//         // target이 숫자 카드에 존재한다면 cnt++를 한 후 양 옆 추가 탐색색
//         if (midVal == target) {
//             cnt++;
//             cnt = binarySearchIterative(arr, target, low, mid-1, cnt);
//             cnt = binarySearchIterative(arr, target, mid+1, high, cnt);
//         } else if (midVal > target) {
//             cnt = binarySearchIterative(arr, target, low, mid-1, cnt);
//         } else {
//             cnt = binarySearchIterative(arr, target, mid+1, high, cnt);
//         }
//         return cnt;
//     }
// }

// JAVA는 메서드에 인자로 값을 넘길 때 call by value 방식으로 동작하기 때문에 cnt에 값이 저장되지 않음
// 하지만 객체와 배열은 참조값을 넘기므로 마치 Call by Reference처럼 동작하게 됨
// 따라서 아래 방식처럼 기본형 데이터(int, char과 같은)를 넘기면 cnt 값이 업데이트 되지 않는 문제가 발생함

// public class _10816_숫자카드2 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         int n = Integer.parseInt(br.readLine());
//         int[] cards = new int[n];
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < n; i++) {
//             cards[i] = Integer.parseInt(st.nextToken());
//         }
//         Arrays.sort(cards);

//         StringBuilder sb = new StringBuilder();
//         int m = Integer.parseInt(br.readLine());
//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < m; i++) {
//             int num = Integer.parseInt(st.nextToken());
//             int cnt = 0;
//             cnt = binarySearchIterative(cards, num, 0, n-1, cnt);
//             sb.append(cnt + " ");
//         }

//         System.out.println(sb.toString().trim());
//     }

//     // -10 -10 2 3 3 6 7 10 10 10
//     public static int binarySearchIterative(int[] arr, int target, int low, int high, int cnt) {
//         // 종료 조건
//         if (low > high) return 0;

//         int mid = (low + high) / 2;
//         int midVal = arr[mid];

//         // target이 숫자 카드에 존재한다면 cnt++를 한 후 양 옆 추가 탐색색
//         if (midVal == target) {
//             cnt++;
//             binarySearchIterative(arr, target, low, mid-1, cnt);
//             binarySearchIterative(arr, target, mid+1, high, cnt);
//         } else if (midVal > target) {
//             binarySearchIterative(arr, target, low, mid-1, cnt);
//         } else {
//             binarySearchIterative(arr, target, mid+1, high, cnt);
//         }
//         return cnt;
//     }
// }