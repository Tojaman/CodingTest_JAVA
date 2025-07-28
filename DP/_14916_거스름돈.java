package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 문제 설명
 * n원을 최소한의 개수의 5원과 2원으로 나누는 방법
 */

/** 풀이 방법 - DP
 * 1. n이 5의 배수일 경우 5원만으로 거슬러줄 수 있음
 * 2. n이 5의 배수가 아닌 경우 전전 거스름돈(dp[i-2])에서 2원만 추가하면 됨
 * -  만약 2원이 5개 모여서 5원 2개로 대체 가능한 경우는 어떻게 할 것인가? -> 이 경우 n이 5의 배수이고 1 조건에서 걸러짐
 * - n이 4이상인 경우 무조껀 거슬러 줄 수 있음(5이상 짝수인 경우 2로 나눌 수 있고 홀수인 경우 5를 빼면 짝수니깐 2원으로 거슬러 줄 수 있음)
 */
public class _14916_거스름돈 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        if (n == 1 || n == 3) {
            System.out.print(-1);
            return;
        }
        if (n >= 2) dp[2] = 1;
        for (int i = 4; i <= n; i++) {
            if (i%5==0) {
                dp[i] = dp[i-5] + 1;
            } else {
                dp[i] = dp[i-2] + 1;
            }
        }
        System.out.print(dp[n]);
    }
}

/** 풀이 방법 - Greedy
 * 두 가지 경우가 존재함
 * 1. 5원으로 모두 거슬러준 후 남은 금액이 짝수인 경우 -> 나머지 2원으로 거슬러주기
 * 2. 5원으로 모두 거슬러준 후 남은 금액이 홀수인 경우 -> 나머지 거슬러줄 수 없음
 * 따라서 남은 금액이 짝수인 경우 n/5 -> remain/2를 하면 되고
 * 남은 금액이 홀수인 경우 ((n/5) - 1) -> remain/2를 하면 됨
 */
/* 
public class _14916_거스름돈 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        if (n == 1 || n == 3) {
            System.out.print(-1);
        }

        while (n > 0) {
            int tmp = n-5;
            if ((tmp < 5 && tmp%2 != 0) || n < 5) {
                n -= 2;
                result++;
            } else {
                n -= 5;
                result++;
            }
        }
        System.out.print(result);
    }
}
*/