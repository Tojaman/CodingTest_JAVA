package DP;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11659_구간_합_구하기4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 100,000
        int m = Integer.parseInt(st.nextToken()); // 1 ≤ M ≤ 100,000

        int[] num = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] slide = new int[n+1];
        for (int i = 1; i <= n; i++) {
            slide[i] += slide[i-1] + num[i];
        }

        // O(m)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(slide[end] - slide[start-1]);
        }
    }
}