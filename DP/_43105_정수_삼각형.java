package DP;

/* 복습2 */
class _43105_정수_삼각형 {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int width = triangle[height-1].length;
        int[][] memo = new int[height][width];
        memo[0][0] = triangle[0][0];
        
        int result = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                
                if (j == 0) { // 왼쪽(위에 값 + 자신 값)
                    memo[i][j] = memo[i-1][j] + triangle[i][j];
                }
                if (i == j) { // 오른쪽(위에 값 + 자신 값)
                    memo[i][j] = memo[i-1][j-1] + triangle[i][j];
                }
                
                if (j != 0 && i != j) { // 위에 왼쪽, 오른쪽 값 중 큰 값 + 자신 값
                    memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]) + triangle[i][j];
                }
                
                if (i == height-1) {
                    result = Math.max(result, memo[i][j]);
                }
            }
        }
        return result;
    }
}

/* 첫 도전 
class _43105_정수_삼각형 {
    public int solution(int[][] triangle) {

        int[][] memo = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++)
            memo[i] = new int[triangle[i].length];

        // memo의 마지막 행의 값을 triangle와 동일하게 설정
        for (int i = 0; i < memo[memo.length-1].length; i++)
            memo[memo.length-1][i] = triangle[triangle.length-1][i];

        for (int i = triangle.length-1; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                memo[i][j] = Math.max(triangle[i][j] + memo[i+1][j], triangle[i][j] + memo[i+1][j+1]);
            }
        }
        return memo[0][0];
    }
}
*/