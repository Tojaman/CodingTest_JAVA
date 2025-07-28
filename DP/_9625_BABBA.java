package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 풀이 방법
 * B -> BA
 * A -> B
 * A -> B -> BA -> BAB -> BABBA
 * DP[n] = DP[n-1] + DP[n-2] */
public class _9625_BABBA {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 초기: B -> k번 버튼 누르면 A와 B는 각각 몇개?

        int k = Integer.parseInt(br.readLine()); // 버튼 누른 횟수

        int[][] dp = new int[k+1][2];
        dp[0][0] = 1;
        dp[1][1] = 1;


        for (int i = 2; i <= k; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        System.out.print(dp[k][0] + " " + dp[k][1]);
    }
}
