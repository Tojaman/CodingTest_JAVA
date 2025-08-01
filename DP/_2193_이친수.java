package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 문제 설명
 * 이친수: 0과 1로만 이루어져 있고 1이 연속되면 안되고 0으로 시작하면 안됨
 * 이떄 N자리 이친수 개수는?
 */

/** 풀이 방법 - DP - O(n)
 * 끝자리가 0일 경우 1과 0으로 끝나는 2개 생성 가능
 * 끝자리가 1일 경우 0으로 끝나는 1개 생성 가능
 * [1] -> [0] -> [1, 0] -> [0, 1, 0] -> [1, 0 ,0 ,1 ,0] -> [0, 1, 0, 1, 0, 0, 1, 0] ...
 * 따라서 점화식은 dp[n] = dp[n-1] + dp[n-2]가 됨
 * 주의, n이 90일 경우 int 범위를 넘어서서 long 형식을 사용해야 함
 */
public class _2193_이친수 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // dp[n] = dp[n-1] + dp[n-2];
        long[] dp = new long[Math.max(n+1, 4)];
        dp[1] = 1; dp[2] = 1;
        if (n > 2) {
            for (int i = 3; i <= n; i++)
                dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.print(dp[n]);
    }
}
