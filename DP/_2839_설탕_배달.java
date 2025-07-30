package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 문제 설명
 * 3kg, 5kg 설탕으로 nkg 채우기
 * 단, 최소한의 봉지를 가져가야 하기 때문에 5kg을 최대로 해야 함
 */
/** 풀이 방법 - DP(O((n)
 * 점화식: DP[n] = min(DP[n-3] + 1(3kg), DP[n-5] + 1(5kg)
 * 5kg을 최대로 가져가야 하기 때문에 두 값중 최솟값을 선택하는 것(대부분의 경우 같지만 DP[n-5]가 작은 경우도 있기 때문) 
 */
public class _2839_설탕_배달 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[Math.max(n+1, 6)]; // 아래 반복문에서 n이 5보다 작은 경우 발생하는"ArrayIndexOutOfBounds"를 방지하기 위해 최소 크기 6 설정
        Arrays.fill(dp, 5001);

        dp[3] = 1; dp[5] = 1;
        for (int i = 6; i <= n; i++) {
            dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
        }
        
        if (dp[n] >= 5001) {
            System.out.print(-1);
            return;
        }
        System.out.print(dp[n]);
    }
}

/** 처음 푼 방식인데 이 방식은 조건문이 많아서 코드 가독성이 좋지 않음
public class _2839_설탕_배달 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[Math.max(n+1, 6)]; // 아래 반복문에서 n이 5보다 작은 경우 발생하는"ArrayIndexOutOfBounds"를 방지하기 위해 최소 크기 6 설정
        if (n == 4 || n == 7) {
            System.out.print(-1);
            return;
        }
        dp[3] = 1; dp[5] = 1;
        for (int i = 6; i <= n; i++) {
            if (dp[i-3] == 0 && dp[i-5] == 0) {
                continue;
            }

            if (dp[i-3] == 0) {
                dp[i] = dp[i-5]+1;
                continue;
            }
            if (dp[i-5] == 0) {
                dp[i] = dp[i-3]+1;
                continue;
            }

            dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
        }
        System.out.print(dp[n]);
    }
}
 */