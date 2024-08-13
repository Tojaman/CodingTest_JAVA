package DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4963_섬의_개수 {
    static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int w = -1;
        int h = -1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0)
                break;
            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        dfs(map, visited, i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }
    public static void dfs(int[][] map, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length) {
                if (!visited[cx][cy] && map[cx][cy] == 1) {
                    dfs(map, visited, cx, cy);
                }
            }
        }

    }
}
