package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579_계단_오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n+1];
        for (int i = 1; i <= n; i++) score[i] = Integer.parseInt(br.readLine());

        int[] memo = new int[n+1];
        memo[1] = score[1];
        if (n >= 2) {
            memo[2] = score[1] + score[2];
        }
        for (int i = 3; i <= n; i++) {
            memo[i] = Math.max(memo[i-2] + score[i], memo[i-3] + score[i-1] + score[i]);
        }
        System.out.println(memo[n]);
    }
}
