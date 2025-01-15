import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 모든 요청 배정 가능한가?
 *  1. 가능 -> 그대로 배정
 *  2. 불가능 -> 정수 상한성 배정
 * 2. 상한선 배정
 */
public class _2512_예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] province = new int[n];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            province[i] = Integer.parseInt(st.nextToken());
            sum += province[i];
            max = Math.max(province[i], max);
        }

        int m = Integer.parseInt(br.readLine());
        // 모든 요청이 배정될 수 있는 경우
        if (sum <= m) {
            System.out.println(max);
            return;
        }

        /** 모든 요청이 배정될 수 없는 경우 -> 이진 탐색으로 상한선 정하기기
         * 상한선의 최대 값은 각 지방의 요청 예산의 최댓값이므로 right를 max로
         * 상한선의 최솟값은 1이므로 left를 0으로 설정(1로 해도 상관 없음음)
         */
        System.out.println(binarySearchIterative(1, max, province, m));
    }

    // 이번엔 재귀가 아닌 반복문으로 구현해 봄
    public static int binarySearchIterative(int left, int right, int[] province, int m) {
        int mid = (left + right) / 2;

        while(left <= right) {
            mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < province.length; i++) {
                if (province[i] <= mid) {
                    sum += province[i];
                } else {
                    sum += mid;
                }
            }

            if (sum == m) {
                right = mid;
                break;
            } else if (sum > m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
