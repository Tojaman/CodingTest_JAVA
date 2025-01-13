import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** lowerBound, upperBound 방식으로 탐색 진행(이진 탐색 기반 방법)
 * 가지고 있는 숫자 카드의 개수 = upperBound - lowerBound
*/
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