package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2468_안전_영역 {
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                max = Math.max(max, val);
            }
        }

        int result = 0;
        for (int k = 0; k < max; k++) {
            int cnt = 0;
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > k){
                        dfs(i, j, k, visited);
                        cnt++;
                    }
                }
            }
            result = Math.max(cnt, result);

        }
        System.out.println(result);
    }

    public static void dfs(int x, int y, int height, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                if (!visited[nx][ny] && map[nx][ny] > height)
                    dfs(nx, ny, height, visited);
            }
        }

    }
}
