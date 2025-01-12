import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 이진 탐색
 * 정렬된 배열의 중간 값과 비교하여 크다면 오른쪽을 탐색하고, 작다면 왼쪽을 탐색한다.
 * 목표 값을 찾을 때까지 위 과정을 반복하여 찾으면 1을 저장하고 마지막까지 찾지 못한다면 0을 저장한다.
*/
public class _10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 숫자 카드 개수
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num); // 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine()); // 숫자 카드인지 아닌지 구분해야 할 수 정수의 개수
        st = new StringTokenizer(br.readLine());

        // ------------------------------- Arrays.binarySearch() 방식 -------------------------------
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            // target이 num 배열에 존재O return -> target이 있는 num 배열의 index
            // target이 num 배열에 존재X return -> 음수
            int find = Arrays.binarySearch(num, target);

            if (find >= 0 && target == num[find]) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb.toString().trim());

        // ------------------------------- 재귀로 직접 구현 -------------------------------
        // for (int i = 0; i < m; i++) {
        //     int target = Integer.parseInt(st.nextToken());
        //     if (binarySearchIterative(num, target, 0, n-1)) {
        //         sb.append(1 + " ");
        //     } else {
        //         sb.append(0 + " ");
        //     }
        // }
        // System.out.println(sb.toString().trim());
    }

    // public static boolean binarySearchIterative(int[] arr, int target, int low, int high) {
    //     // 값이 존재하지 않는다면
    //     if (low > high) return false;

    //     int mid = (low + high) / 2;
    //     int midValue = arr[mid];

    //     if (target == midValue) {
    //         return true;
    //     } else if (midValue < target) { // 오른쪽
    //         return binarySearchIterative(arr, target, mid + 1, high);
    //     } else {
    //         return binarySearchIterative(arr, target, low, mid - 1);
    //     }
    // }

}
