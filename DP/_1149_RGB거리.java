package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 풀이 방법
1. 테이블 정의하기: dp[i][j]: i번째 집에 j색을 칠할 때 최솟값
2. 점화식 정의하기: i번째 집 색깔 별 비용 = i-1번째 집 색 안겹치는 두 개 중 최솟값 + 현재 집 색깔
3. 초기값 정하기: 첫 번째 집의 색깔 별 비용
*/
public class _1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] house = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // <= 1,000
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][3];
        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][1]) + house[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
        }

        System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));
    }


    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     int n = Integer.parseInt(br.readLine()); // 2 <= n <= 1000
    //     int[][] homes = new int[n][3];
    //     StringTokenizer st;
    //     for (int i = 0; i < n; i++) {
    //         st = new StringTokenizer(br.readLine());
    //         for (int j = 0; j < 3; j++) {
    //             homes[i][j] = Integer.parseInt(st.nextToken());
    //         }
    //     }

    //     // 첫 번째 집 초기화
    //     int[][] dp = new int[n][3];
    //     dp[0][0] = homes[0][0];
    //     dp[0][1] = homes[0][1];
    //     dp[0][2] = homes[0][2];
        
    //     for (int i = 1; i < n; i++) {
    //         dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]) + homes[i][0]; // R
    //         dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]) + homes[i][1]; // G
    //         dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]) + homes[i][2]; // B
    //     }

    //     System.out.print(Arrays.stream(dp[n-1]).min().getAsInt());
    // }
}
