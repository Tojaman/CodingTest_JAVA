package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 조건
 * 돌 1개 or 3개 가져갈 수 있음
 * 마지막 돌 가져가는 사람이 win
 * 상근이부터 시작
 */
public class _9655_돌게임 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        /** 풀이 방법 - 수학
         * 두 명이 각각 홀수개(1, 3)의 돌을 가져감
         * 결국 처음 시작한 애는 돌의 개수가 홀수일 때 이기고 다음 시작한 애는 돌의 개수가 짝수일 때 이김
         */
        /**
        String result = "";
        if (n % 2 == 0) result = "CY";
        else result = "SK";

        System.out.println(result);
        */
        
        /** 풀이 방법 - DP
         * dp 배열의 크기는 돌의 크기
         * 돌이 n개 있을 때 누가 이기는지를 저장
         * 돌을 1 or 3개 선택할 수 있으므로 바로 전 or 3번째 전 사람 다음 사람이 승자임
         */
        if (n == 1 || n == 3) System.out.println("SK");
        if (n == 2) System.out.println("CY");
        String[] dp = new String[n+1];
        dp[1] = "SK";
        dp[2] = "CY";
        dp[3] = "SK";

        for (int i = 4; i <= n; i++) {
            if (dp[i-1] == "CY" || dp[i-3] == "CY") {
                dp[i] = "SK";
            }
            else {
                dp[i] = "CY";
            }
        }

        System.out.println(dp[n]);
    }
}