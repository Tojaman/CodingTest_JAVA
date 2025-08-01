package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 문제 설명
 * 수열 arr가 주어졌을 때 증가하는 수열 중 길이가 가장 긴 수열을 구하시오
 */

/** 풀이 방법
 * 1. 우선 문제에서 구하고자 하는 값을 찾아보자.
 * - 증가하는 수열의 "길이"
 * 길이를 구하는 문제이다. 따라서 dp를 이용할 경우 dp[]에는 길이를 값으로 넣을 것을 알 수 있다.
 * 
 * 2. 증가하는 수열이기 때문에 수열을 순차적으로 탐색하면 된다.
 * 따라서 "반복문을 이용해서 탐색"하는 것을 알 수 있다.
 * 
 * 3. 증가하는지 알기 위해선 "현재 값이 이전 값들보다 큰지" 알아야 한다.
 * if (arr[i] > arr[j] (i > j))
 * 위 검증을 하기 위해서 이중 반복문을 이용하여 현재 값과 현재 값보다 작은 값들을 비교해보자.
 * for (int i = 0; i < n; i++) {
 *  for (int j = 0; j < i; j++) {
 *   if (arr[i] > arr[j])
 *    로직
 *  }
 * }
 * 
 * 4. 만약 현재 값이 이전 값보다 크다면(증가하는 수열이라면) 이전 값에서 구한 길이 + 1을 한다.
 * 그러나 무작정 dp[i] = dp[j] + 1을 해버리면 {10, 20, 5, 30, 50}일 때 다음과 같은 문제가 발생할 수 있다.
 * i=3, j=2일 때 30은 {5, 30}이 아닌 {10, 20, 30} 부분 수열이어야 하는데 dp[j]는 5이므로 {5, 30} 길이인 2를 가져가게 된다.
 * 따라서 {10, 20}을 따라 가는 부분 수열의 길이를 저장하기 위해 Math.max(dp[i], dp[j]+1)로 더 긴 수열의 길이를 저장할 수 있도록 한다.
 */
public class _11053_가장_긴_증가하는_부분_수열 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 1000
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i ++){ 
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // O(n*m) ~= O(n^2)
        for (int i = 0; i < n; i ++){ 
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) { // 고정 위치가 크다면 == 증가하는 수열이면
                    // 10, 20, 5, 30 ... 인 경우 dp[i] = dp[j]+1을 해버리면 10, 20, 30이 더 길지만 5, 30이 되어 버리므로 현재 길이dp[i]와 비교중인 길이dp[j]+1 중 큰 값을 넣어야 함
                    // dp[i] = dp[j]+1;
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    
                }
            }
        }

        System.out.print(Arrays.stream(dp).max().getAsInt());
    }
}
