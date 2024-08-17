package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2748_피보나치_수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long result = fibo(n);

        System.out.println(result);
    }

    public static long fibo(int n) {
        if (n <= 1) return n;

        long[] fibo = new long[n+1];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) fibo[i] = fibo[i-2] + fibo[i-1];

        return fibo[n];
    }
}
