package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class _10026_적록색약 {
    static String[][] paints;
    static boolean[][] visited;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        paints = new String[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] paint = br.readLine().split("");
            for (int j = 0; j < N; j++)
                paints[i][j] = paint[j];
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
                if (paints[i][j].equals("R"))
                    paints[i][j] = "G";
            }
        }

        int cntRG = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cntRG++;
                }
            }
        }
        System.out.println(cnt + " " + cntRG);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        String now = paints[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < paints.length && ny < paints[0].length) {
                if (paints[nx][ny].equals(now) && !visited[nx][ny])
                    dfs(nx, ny);
            }
        }
    }
}