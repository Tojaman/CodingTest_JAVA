
package BFS;

import java.util.*;
/* 조건
- x, y축 겹침 X
- 분리 X
- 포함 X
- 좌표 1~50
*/

/* 풀이 방법
1. 다각형 둘레 구하기
  - 좌~우, 하~상 한 칸씩 이동하며 다른 직사각형 도형 내부에 있지 않다면 둘레로 판정
2. BFS 탐색하며 목적지까지 최단 거리 구하기

이때 (3,5) -> (4,5) 이동해야 하는데 (3,5) -> (3,6) 이동하는 문제가 발생
해결 방법으로 처음엔 map을 단순 boolean이 아닌 [점, 점]으로 저장해서 이동 가능한 경로인지 판단하려고 했으나, 너무 복잡해서 찾아봄
*/
/* 해결 방법
2차원 배열을 2배로 키워서 해결
2배로 키우면 같은 직사각형은 중간이 이어지는 지점까지 true로 채움
하지만, 서로 다른 직사각형이면서 한 칸 차이 나던 부분은 중간에 1칸이 false로 남음
예를 들어 기존에는 (3,5) -> (3,6)으로 잘못 이동하던 부분이 (6, 10) -/-> (6, 12)이 되면서 이동할 수 없게 변함
*/

// 풀이 시간: 2시간 30분 (2배 스케일링 못떠올림)
class _87694_아이템_줍기 {
    static int[] mx = {0, 0, -1, 1};
    static int[] my = {1, -1, 0, 0};
    static int distance = 0;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // 1) 좌표 2배 스케일링된 사각형 배열 생성 (isIn도 이 배열을 사용)
        int n = rectangle.length;
        int[][] rect2 = new int[n][4];
        for (int i = 0; i < n; i++) {
            rect2[i][0] = rectangle[i][0] * 2;
            rect2[i][1] = rectangle[i][1] * 2;
            rect2[i][2] = rectangle[i][2] * 2;
            rect2[i][3] = rectangle[i][3] * 2;
        }
        
        // 좌표 스케일을 2배로 늘리기
        boolean[][] map = new boolean[101][101];
        // O(4) * O(4*50)
        for (int i = 0; i < rectangle.length; i++) {
            int sx = rectangle[i][0] * 2;
            int sy = rectangle[i][1] * 2;
            int ex = rectangle[i][2] * 2;
            int ey = rectangle[i][3] * 2;

            // O(50)
            for (int j = sx; j <= ex; j++) {
                // O(4)
                if (!isIn(j, sy, rect2)) map[j][sy] = true;
                if (!isIn(j, ey, rect2)) map[j][ey] = true;
            }
            // O(50)
            for (int j = sy; j <= ey; j++) {
                if (!isIn(sx, j, rect2)) map[sx][j] = true;
                if (!isIn(ex, j, rect2)) map[ex][j] = true;
            }
        }
        
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2, map);
        return distance;
    }
    
    // 다른 직사각형 내부에 있는가? - O(4)
    public static boolean isIn(int x, int y, int[][] rectangle) {
        for (int i = 0; i < rectangle.length; i++) {
            if (x > rectangle[i][0] && x < rectangle[i][2] // sx < x < ex
             && y > rectangle[i][1] && y < rectangle[i][3]) { // sy < y < ey
                   return true; // 내부
            }
        }
        return false; // 외부
    }
    
    public static void bfs(int sx, int sy, int itemX, int itemY, boolean[][] map) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        q.offer(new int[] {sx, sy, 0}); // 시작점
        visited[sx][sy] = true;
        
        while (!q.isEmpty()) {
            // 현재 위치
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];
            int dist = now[2];
            // 목적지 도달 시 탈출
            if (cx == itemX && cy == itemY) {
                distance = dist/2;
                return;
            }
        
            // 상하좌우 탐색(방문X, 경로O, 2차원 배열 내부O)하며 이동(큐에 넣기)
            for (int i = 0; i < 4; i++) {
                int nx = cx + mx[i];
                int ny = cy + my[i];
                int nDist = dist+1;
                if (0 <= nx && nx < 101 && 0 <= ny  && ny < 101) { // 좌표 벗어나지 않음
                    if (map[nx][ny] && !visited[nx][ny]) { // 외부 경로, 방문X

                        q.offer(new int[] {nx, ny, nDist});
                        visited[nx][ny] = true;
                        
                    }
                }
            }
        }
    }
}