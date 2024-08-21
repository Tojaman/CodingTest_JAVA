package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11726_2xn_타일링 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 점화식: memo[n] = memo[n-1] + memo[n-2]
        int[] memo = new int[n+1];
        if (n == 1)  {
            System.out.println(1%10007);
            return;
        }
        memo[1] = 1;
        memo[2] = 2;
        // 반복문에서 %10007을 해줘야 int 범위를 넘어가지 않음
        for (int i = 3; i <= n; i++) memo[i] = (memo[i - 1] + memo[i - 2])%10007;
        System.out.println(memo[n]);
    }
}
