package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 풀이 방법 - DP
 * mCn = m-1Cn-1 + m-1Cn
 */
public class _1010_다리놓기 {
    static int[][] dp = new int[31][31];
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(combination(m, n));
        }
    }

    // mCn = m-1Cn-1 + m-1Cn
    public static int combination(int m, int n) {

        if(dp[m][n] > 0) {
            return dp[m][n];
        }

        if (m == 0 || n == 0)
        return dp[m][n] = 1;

        // 양쪽 다리의 개수가 같은 경우 -> 1
        if (m == n) {
            return dp[n][n] = 1;
        }

        return dp[m][n] = combination(m-1, n-1) + combination(m-1, n);
    }

    // public static void main(String[] arge) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     long[][] dp = new long[31][31];

    //     for (int i = 0; i <= 30; i++) {
    //         dp[i][0] = 1; // 0개 뽑는 경우
    //         dp[i][i] = 1; // 대각선(n==m -> 1개)
    //     }

    //     for (int i = 2; i <= 30; i++) { // m
    //         for (int j = 1; j < i; j++) { // n (j==i인 경우는 1로 미리 구해놨으므로 포함X)
    //             dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
    //         }
    //     }

    //     int t = Integer.parseInt(br.readLine());
    //     for (int i = 0; i < t; i++) {
    //         StringTokenizer st = new StringTokenizer(br.readLine());
    //         int n = Integer.parseInt(st.nextToken());
    //         int m = Integer.parseInt(st.nextToken());

    //         System.out.println(dp[m][n]);
    //     }
    // }
}

// 풀이 방법 - 조합(시간 초과)
// /** 문제 설명
//  * 서쪽 출발지 N개 -> 동쪽 목적지 M개 (N <= M)
//  * 다리는 서로 겹칠 수 없으면서 최대한 많은 다리 연결
//  */

// /** 풀이 방법 - 조합(nCm)
//  * N <= M이기 때문에 서쪽의 모든 다리는 동쪽은 다리와 연결될 수 있다.
//  * 다리는 서로 겹칠 수 없기 때문에 서쪽 다리 순서대로 동쪽 다리에 연결되어야 한다.
//  * 따라서 동쪽 다리에서 N개의 다리를 고른 뒤 순서대로 연결하면 최대한 많은 다리(N개)를 지으면서 서로 겹치지 않는다.
//  * 결국 연결은 무조껀 순서대로 하기 때문에 생각할 필요 없고 동쪽 다리 M개 중 N개를 선택하기만 하면 된다.
//  * 이는 조합으로 해결할 수 있다.
//  */
// public class _1010_다리놓기 {
//     static boolean[] visted;
//     static int result;
//     public static void main(String[] arge) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         int t = Integer.parseInt(br.readLine());
//         for (int i = 0; i < t; i++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             int n = Integer.parseInt(st.nextToken());
//             int m = Integer.parseInt(st.nextToken());
//             visted = new boolean[m];

//             result = 0;
//             if (n == m) {
//                 System.out.println(1);
//                 continue;
//             }

//             combination(0, 0, n, m);
//             System.out.println(result);
//         }
//     }

//     /**
//      * m개의 수 중 n개를 뽑으면 result++하여 개수 세기
//      * n: 뽑아야 하는 다리의 개수
//      * m: 뽑을 수 있는 다리의 개수
//      * depth: 뽑은 다리의 개수
//      * i: 현재 선택중인 다리의 인덱스(m 다리의 인덱스)
//      * result: 지금까지 선택한 다리의 개수
//      */
//     public static void combination(int start, int depth, int n, int m) {

//         if (depth == n) {
//             result++;
//             return;
//         }

//         /**
//          * i번째 다리를 선택하고 지금까지 선택한 다리의 개수는 depth
//          * ex. i=0, depth=0, n=2, m=4일 때 -> {0, 1}, {0, 2}, {0, 3} | {1, 2}, {1, 3} | {2, 3}
//          */
//         for (int i = start; i < m; i++) {
//             combination(i+1, depth+1, n, m);
//         }
//     }
// }

