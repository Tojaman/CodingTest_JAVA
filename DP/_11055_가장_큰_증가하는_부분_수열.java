package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 조건
 * 1. 증가하는 부분 수열
 * 2. 최대 합
 */

/** 풀이 방법
 * 1. 증가하는 부분 수열이어야 하므로 순차적으로 탐색하며 증가하는 부분 수열인지 검증해야 함
 *    if (arr[i] > arr[j])
 * 2. 최대 합을 구해야하기 때문에 dp[]에 합을 저장
 * 3. dp를 이용할거기 때문에 dp[n]은 dp[n-m]을 이용하여 저장해야 함
 * 4. dp[n]에 값을 저장할 때 여러 부분 수열 중 최대 값만을 저장해야 함.
 *    따라서 여러 부분 수열의 합 중 큰 값을 저장하는 로직 필요
 *    dp[i] = Math.max(dp[i], dp[j]+arr[i]);
 */
public class _11055_가장_큰_증가하는_부분_수열 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 1000
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i ++){ 
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 0; i < n; i++) {
            // dp[i] = arr[i]가 없으면 arr = {20, 10}일 경우 dp[0] = 20, dp[1] = 10이어야 하는데 dp[1]이 0이 됨
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+arr[i]);
                }
            }
        }

        System.out.print(Arrays.stream(dp).max().getAsInt());
    }
}
