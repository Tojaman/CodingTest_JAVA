package DP;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12852_1로_만들기_2_4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 1,000,000
        int[] cnt = new int[n+1];
        int[] path = new int[n+1];
        // O(n)
        for (int i = 2; i <= n; i++) cnt[i] = Integer.MAX_VALUE;
        // O(n)
        for (int i = 2; i <= n; i++) {
            cnt[i] = cnt[i-1]+1;
            int prev = i-1;

            if (i%3 == 0 && cnt[i/3]+1 < cnt[i]) {
                cnt[i] = cnt[i/3]+1;
                prev = i/3;
            }

            if (i%2 == 0 && cnt[i/2]+1 < cnt[i]) {
                cnt[i] = cnt[i/2]+1;
                prev = i/2;
            }

            path[i] = prev;
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(cnt[n]);
        // O(n)
        while (n != 0) {
            sb.append(n).append(" ");
            n = path[n];
        }
        System.out.print(sb.toString().trim());
    }
}