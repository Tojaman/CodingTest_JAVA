package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 문제 설명
 * 아기 상어 사이의 거리가 안전 거리가 아니다.
 * 아기 상어가 없는 칸과 가장 가까운 아기 상어 칸 사이의 거리가 안전 거리이다.
 * 따라서 0인 칸과 가장 가까운 아기 상어 칸의 거리를 모두 구한 뒤 최대값을 출력한다.
 */

/** 문제 풀이
 * 각 노드에서 bfs를 실행할 때 가장 가까운 아기상어까지 거리를 distance[][] 배열에 거리를 저장한다.
 * 아기 상어를 만나면 아기 상어 까지의 거리가 저장된 distance[cx][cy]를 반환한다.
 */
public class _17086_아기_상어2 {
    static int dx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int dy[] = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    max = Math.max(max, bfs(map, i, j));
                }
            }
        }
        System.out.println(max);
    }

    public static int bfs(int[][] map, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int[][] cnt = new int[map.length][map[0].length];

        while (!q.isEmpty()) {
            int[] current = q.poll();
            if (map[current[0]][current[1]] == 1) {
                return cnt[current[0]][current[1]];
            }
            for (int i = 0; i < 8; i++) {
                int cx = current[0] + dx[i];
                int cy = current[1] + dy[i];
                if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length) {
                    // 아직 방문하지 않았다면
                    if (cnt[cx][cy] == 0) {
                        cnt[cx][cy] = cnt[current[0]][current[1]] + 1;
                        q.add(new int[]{cx, cy});
                    }
                }
            }
        }
        return -1;
    }
}