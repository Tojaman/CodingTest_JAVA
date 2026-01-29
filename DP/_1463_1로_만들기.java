package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _1463_1로_만들기 {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        memo = new int[n+1];

        for (int i = 0; i < n; i++) {
            memo[i] = n;
        }

        
        dp(n, 1);


        System.out.println(memo[1]);
    }
    static public void dp(int k, int cnt) {

        if (k <= 1) {
            return;
        }

        // k/3
        if (k % 3 == 0) {
            memo[k/3] = Math.min(memo[k/3], cnt);
            dp(k/3, cnt+1);
        }

        // k/2
        if (k%2 == 0) {
            memo[k/2] = Math.min(memo[k/2], cnt);
            dp(k/2, cnt+1);
        }

        // k-1
        memo[k-1] = Math.min(memo[k-1], cnt);
        dp(k-1, cnt+1);
    }
}


// public class _1463_1로_만들기 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());

//         // DP 배열 선언 및 초기화
//         int[] memo = new int[n + 1];
//         for (int i = 2; i <= n; i++) {
//             memo[i] = memo[i - 1] + 1; // 기본 연산 (x - 1)
//             if (i % 2 == 0) memo[i] = Math.min(memo[i], memo[i / 2] + 1);
//             if (i % 3 == 0) memo[i] = Math.min(memo[i], memo[i / 3] + 1);
//         }

//         // 결과 출력
//         System.out.println(memo[n]);
//     }
// }

//public class _1463_1로_만들기 {
//    static int minCnt = Integer.MAX_VALUE;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        // 1순위: /3, 2순위: /2, 3순위: -1
//
////        int[][] memo = new int[n+1][3];
//        HashMap<Integer, int[]> memo = new HashMap<>();
//        dp(n, memo, 0);
//        System.out.println(minCnt);
//
//    }
//
//    // 하향식 방법 사용
//    public static void dp(int x, HashMap<Integer, int[]> memo, int cnt) {
//        if (x == 0) {
//            return ;
//        }
//        if (x == 1) {
//            minCnt = Math.min(minCnt, cnt);
//            return ;
//        }
//
//        // 계산 된 부분 문제인 경우
//        if (memo.containsKey(x)) {
//            if (memo.get(x)[0] != 0) dp(memo.get(x)[0], memo, cnt+1);
//            if (memo.get(x)[1] != 0) dp(memo.get(x)[1], memo, cnt+1);
//            if (memo.get(x)[2] != 0) dp(memo.get(x)[2], memo, cnt+1);
//        }
//
//        // 아직 계산을 안한 부분 문제인 경우
//        else {
//            int[] arr = new int[3];
//            if (x % 3 == 0) arr[0] = x / 3;
//            if (x % 2 == 0) arr[1] = x / 2;
//            arr[2] = x - 1;
//
//            memo.put(x, arr);
//            dp(arr[0], memo, cnt+1);
//            dp(arr[1], memo, cnt+1);
//            dp(arr[2], memo, cnt+1);
//        }
//    }
//}
