package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 문제 설명
 * 연속된 실수들의 곱 중 가장 큰 값을 구하라
 */

/** 풀이 방법 - 보고 품
 * n개의 실수를 순환하면서 바로 이전 연속된 곱과 현재 값의 곱이 커지면 연결하고 작아지면 연결을 끊고 다시 연속된 곱을 시작한다.
 * 규칙
 * 1. 현재 곱이 0.x인 경우 다음에 나올 실수가 몇이든지 작아지기 때문에 현재 곱이 0.x인 경우 새로운 연속된 곱이 시작된다.
 */
public class _2670_연속부분최대곱 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] dp = new double[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Double.parseDouble(br.readLine());
        }

        double result = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i], dp[i] * dp[i-1]);
            result = Math.max(result, dp[i]);
        }

        System.out.print(String.format("%.3f", result));
    }
}


/** 풀이 방법 - dp, 브루트포스(O(n^2)) -> 메모리 초과
 * 2차원 배열을 만들어서 dp[i][j]에 i~j까지 실수를 곱한 값을 저장한다.
 * 이렇게 되면 dp[][]에 모든 실수의 연속된 곱이 저장되고 그중 가장 큰 값을 출력한다.
 */
/** 
public class _2670_연속부분최대곱 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        float[] num = new float[n];
        for (int i = 0; i < n; i++) {
            num[i] = Float.parseFloat(br.readLine());
        }

        float[][] dp = new float[n][n];
        float result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = num[i];
                    continue;
                }
                dp[i][j] = dp[i][j-1] * num[j];
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.print(Math.round(result*1000) / 1000.0);
    }
}
*/