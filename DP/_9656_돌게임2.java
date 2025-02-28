package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9656_돌게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        
        /** 풀이 방법 - DP
         * dp[n]: dp 배열에는 패자를 저장한다.
         * 돌은 1개 or 3개를 가져갈 수 있으므로 dp[현재-1]과 dp[현재-3] 사람의 반대 사람이 승자가 된다.
         */
        int n = Integer.parseInt(br.readLine());

        if (n == 1 || n == 3) System.out.println("CY");
        if (n == 2) System.out.println("SK");

        String[] dp = new String[n+1];
        dp[1] = "CY";
        dp[2] = "SK";
        dp[1] = "CY";

        for (int i = 4; i <= n; i++) {
            if (dp[i-1] == "SK" || dp[i-3] == "SK")
                dp[i] = "CY";
            else
                dp[i] = "SK";
        }
        System.out.println(dp[n]);
    }
}
