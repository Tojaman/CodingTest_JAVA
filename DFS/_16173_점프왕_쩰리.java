package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16173_점프왕_쩰리 {
    /* ------------------------------------- DFS -------------------------------------
    
    // 오른쪽, 아래쪽만 이동 가능하므로 아래와 같이 설정
    public static int[] dx = {0, 1};
    public static int[] dy = {1, 0};
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n]; // 기본값: false
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // [0, 0]에서 시작
        dfs(0, 0, map, visited, map[0][0]);
        System.out.println("Hing");
    }

    public static void dfs(int x, int y, int[][] map, boolean[][] visited, int step) {
        if (map[x][y] == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }
        // 오른쪽, 아래쪽만 살핌
        for (int i = 0; i < 2; i++) {

            int nx = x + dx[i] * step;
            int ny = y + dy[i] * step;
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, map, visited, map[nx][ny]);
                }
            }
        }
    }
    */

    // ------------------------------------- BFS -------------------------------------
    public static int n;
    public static int[] dx = {0, 1};
    public static int[] dy = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(map);
    }

    public static void bfs(int[][] map) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        // 시작점[0, 0]
        q.offer(new Node(0, 0));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            if (map[node.x][node.y] == -1) {
                System.out.println("HaruHaru");
                System.exit(0);
            }

            for (int i = 0; i < 2; i++) {
                int nx = node.x + dx[i] * map[node.x][node.y];
                int ny = node.y + dy[i] * map[node.x][node.y];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
        System.out.println("Hing");
    }
    static class Node {
        private int x;
        private int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
