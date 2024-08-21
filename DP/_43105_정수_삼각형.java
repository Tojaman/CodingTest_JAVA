package DP;


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

