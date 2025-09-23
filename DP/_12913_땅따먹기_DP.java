package DP;

/** 조건 및 결과
조건
- 한 행에 하나의 땅만 밝을 수 있음
- 같은 열 연속 밟기 불가능
결과
- 밝은 땅 점수의 합이 최대가 되도록 하기
**/

/** 풀이 방법: DP(Top Down)
dp[][] 배열의 각 칸마다 조건에 맞은 가장 큰 값을 저장
**/
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int rowSize = land.length;

        int[][] dp = new int[rowSize][land[0].length];
        
        for (int i = 0; i < 4; i++) dp[0][i] = land[0][i];
        
        // O(4*4*n) (n <= 100,000)
        // 총 1,600,000번 순환
        for (int i = 1; i < rowSize; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j != k) { //이전 행과 열이 다른 경우
                        dp[i][j] = Math.max(land[i][j] + dp[i-1][k], dp[i][j]);
                    }
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer;
    }
}

/** 풀이 방법: Greedy -> 당장 예시의 두 번째 행의 8을 10으로 바꾸면 최고값이 아님
1. 행을 순서대로 내려옴
2. 각 행에서 가장 큰 땅을 밟음
**/
// public class _12913_땅따먹기_DP {
//     int solution(int[][] land) {
//         int answer = 0;

//         int row = -1;
//         for (int i = 0; i < land.length; i++) {
//             int max = 0;
//             int nowRow = -1;
//             for (int j = 0; j < land[i].length; j++) {
//                 if (j != row && max < land[i][j]) {
//                     max = land[i][j];
//                     nowRow = j;
//                 }
//             }
//             row = nowRow;
//             answer += max;
//         }

//         return answer;
//     }
// }
