package DP;

class _42898_등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];

        map[0][0] = 1;
        for (int[] puddle : puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;
        }


        // puddles[x][y] = puddles[x+1][y](아래로) + puddles[x][y-1](오른쪽으로)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0; // 물웅덩이는 경로가 없으므로 0으로 설정
                } else {
                    if (i > 0) map[i][j] += map[i - 1][j];
                    if (j > 0) map[i][j] += map[i][j - 1];
                    map[i][j] %= 1_000_000_007; // 모듈러 연산
                }
            }
        }
        return map[n-1][m-1];
    }
}