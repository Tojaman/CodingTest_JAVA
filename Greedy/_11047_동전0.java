package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/* 풀이 방법 - 그리디
가장 큰 동전부터 사용
*/

/* 풀이 방법 - DP
1. 테이블 정의: dp[i]: i는 가치의 합, dp[i] = 최솟값
2. 점화식 찾기
dp[i] = Math.min(dp[i-coin[j]]) + 1;
dp[i]는 dp[i-coin[1...j]들의 최솟값에 동전 개수(1)을 더한 값
3. 초기값 설정
*/
// 2026.01.28
public class _11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        // 1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);

        int cnt = 0;
        int i = n-1;
        while (k != 0) {
            if (coin[i] <= k) {
                k -= coin[i];
                cnt++;
            } else {
                i--;
            }
        }
        

        System.out.println(cnt);
    }
}


// public class _11047_동전0 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;

//         st = new StringTokenizer(br.readLine(), " ");
//         int n = Integer.parseInt(st.nextToken());
//         int k = Integer.parseInt(st.nextToken());

//         int[] arr = new int[n];
//         int m = 0;
//         for (int i = 0; i < n; i++) {
//             arr[i] = Integer.parseInt(br.readLine());
//             if (arr[i] <= k) //
//                 m = i;

//         }

//         int cnt = 0;
//         for (int j = m; j >= 0; j--) {
//             if (k >= arr[j]) {
//                 cnt += k / arr[j];
//                 k = k % arr[j];
//             }
//         }
//         System.out.println(cnt);
//     }
// }