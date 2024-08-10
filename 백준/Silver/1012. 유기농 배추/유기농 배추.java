import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/** 문제 설명
 * 그림과 같이 배추가 심어져 있을 때 필요한 흰지렁이의 최소 수는?
 * 흰지렁이는 상하좌우에 있는 배추의 해충을 잡아먹을 수 있다.
 */

/** 풀이 방법
 * 배추들의 부분 집합의 개수를 출력하면 된다,
 */
public class Main {
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로
            int N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken());

            // 가로 길이가 행의 크기, 세로 길이가 열의 크기 아닌가?
            int[][] map = new int[M][N];
            boolean[][] visited = new boolean[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(map, visited, i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }

    public static void dfs(int[][] map, boolean[][] visited , int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length) {
                if (map[cx][cy] == 1 && !visited[cx][cy])
                    dfs(map, visited, cx, cy);
            }
        }
    }
}
