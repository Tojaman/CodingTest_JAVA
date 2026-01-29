package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_1_2_3_더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // <= 11
            System.out.println(dp[n]);
        }
        
    }


    // public static void main(String[] arge) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    //     int[] memo = new int[11];
    //     memo[1] = 1;
    //     memo[2] = 2;
    //     memo[3] = 4;
    //     for (int i = 4; i <= 10; i++) {
    //         memo[i] = memo[i-3] + memo[i-2] + memo[i-1];
    //     }

    //     int n = Integer.parseInt(br.readLine());
    //     for (int i = 0; i < n; i++) {
    //         System.out.println(memo[Integer.parseInt(br.readLine())]);
    //     }
    // }
}
