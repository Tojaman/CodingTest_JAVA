package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 풀이 방법
 * 모든 지점에서 목표 지점까지 거리
 * n: 세로(2 ≤ n ≤ 1000)
 * m: 가로(2 ≤ m ≤ 1000)
 * 0: 갈 수 없는 땅 / 1: 갈 수 있는 땅 / 2: 목표 지점
 */
public class _14940_쉬운_최단거리 {
    static int[][] land;
    static int n, m;
    static int targetX; static int targetY;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static int[][] distances;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        distances = new int[n][m];

        land = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                if (land[i][j] == 2) {
                    targetX = i; targetY = j;
                    distances[i][j] = 0;
                } else if (land[i][j] == 0) {
                    distances[i][j] = 0;
                } else { // land[i][j] == 1 인 경우
                    distances[i][j] = -1; // 도달할 수 없는 경우를 대비해 -1로 초기화
                }
            }
        }

        bfs(targetX, targetY);
        
        StringBuilder sb = new StringBuilder(); // 단 하나의 객체만 생성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(distances[i][j]);
                if (j < m - 1) { // 조건문으로 공백 제어
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString()); // 마지막에 한 번만 출력
    }

    public static void bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, 0});
        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;

        while (!q.isEmpty()) {

            int[] nowLand = q.poll();
            int curX = nowLand[0];
            int curY = nowLand[1];
            int dist = nowLand[2];

            // 현재 지점의 거리 업데이트 (이미 targetX, targetY는 0으로 초기화됨)
            // land[curX][curY]가 1인 경우에만 거리 값을 갱신 (0이나 2는 이미 처리됨)
            if (land[curX][curY] == 1) {
                distances[curX][curY] = dist;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                int nextDist = dist + 1;

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (land[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        q.offer(new int[] {nextX, nextY, nextDist});
                    }
                }
            }
        }
    }
}
