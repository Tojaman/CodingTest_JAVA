package Implementation;

/* 풀이 방법
행렬을 저장할 두 개의 2차원 배열을 선언한다. map1, map2
(map1은 변경 전 값, map2는 변경 후 값)

- 시계 방향으로 총 4변 이동을 수행하고, 이 과정에서 최솟값을 찾아 저장한다.
- 이동이 끝났으면 이동된 값인 map2를 map1에 복사하여 이동을 반영한다.
- 위 2 과정을 queries 수만큼 반복
*/

// 풀이 시간: 1시간
public class _77485_행렬_테두리_회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] result = new int[queries.length];
        
        int[][] map1 = new int[rows+1][columns+1];
        int[][] map2 = new int[rows+1][columns+1];
        
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map1[i][j] = num++;
                map2[i][j] = map1[i][j];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int min = Integer.MAX_VALUE;
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            
            for (int j = y1; j < y2; j++) {
                map2[x1][j+1] = map1[x1][j];
                min = Math.min(map2[x1][j+1], min);
            }
            for (int j = x1; j < x2; j++) {
                map2[j+1][y2] = map1[j][y2];
                min = Math.min(map2[j+1][y2], min);
            }
            for (int j = y2; j > y1; j--) {
                map2[x2][j-1] = map1[x2][j];
                min = Math.min(map2[x2][j-1], min);
            }
            for (int j = x2; j > x1; j--) {
                map2[j-1][y1] = map1[j][y1];
                min = Math.min(map2[j-1][y1], min);
            }
            result[i] = min;
            for (int j = 0; j < map1.length; j++) {
                // 각 행(row)을 하나씩 복사
                map1[j] = map2[j].clone();
            }
        }
        
        return result;
    }
}