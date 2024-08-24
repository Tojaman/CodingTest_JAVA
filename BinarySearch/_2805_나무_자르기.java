package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2805_나무_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 나무의 수
        int m = Integer.parseInt(st.nextToken()); // 필요한 나무 길이

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            trees[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(trees);

        int low = 0;
        int high = trees[n-1];
//        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            // 1 ≤ M ≤ 2,000,000,000 조건이 주어졌다. 따라서 sum이 int 범위를 넘어설 수 있어서 long으로 설정
            long sum = 0;
            for (int tree : trees) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }
            if (sum >= m) {
//                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

             /*문제의 목표는 나무의 길이가 딱 m인 값을 찾는 게 아닌 m에 가까운 최적의 값을 찾는 것임
             문제에서 sum == m이 반드시 있을 거란 보장이 없음
             예를 들어, 특정 톱 높이에서는 sum > m이고, 그 다음으로 작은 톱 높이에서는 sum < m이 되는 경우가 있을 수 있음
             따라서 최대한 m에 가깝게 나무를 자르는 최적의 높이 찾기 위해 위 코드를 사용함.
            if (sum == m) break;
            else if (sum > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }*/
        }
        // sum == mid일 때 mid = low + 1이 된다.
        // mid가 커지면 sum이 작아지므로 high = mid -1이 됨.
        // 최종적으로 low > high일 때 low = 최적의 값 + 1이고 high = 최적의 값이므로 high를 출력한다.
        System.out.println(high);
    }
}
