package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 구현 시간: 25분 줄이자
public class _1926_그림 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int maxSize = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    maxSize = Math.max(maxSize, (bfs(i, j, n, m))); // 가장 큰 그림
                    cnt++; // 그림의 개수
                }
            }
        }
        
        System.out.println(cnt);
        System.out.println(maxSize);
    }

    public static int bfs(int x, int y, int n, int m) {
        
        Queue<int[]> q = new LinkedList<>();

        int size = 1;
        q.offer(new int[] {x, y});
        visited[x][y] = true;


        while (!q.isEmpty()) {
            int[] nowNode = q.poll();
            int cx = nowNode[0];
            int cy = nowNode[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx > 0 && nx <= n && ny > 0 && ny <= m) {
                    if (!visited[nx][ny] && board[nx][ny] == 1) {
                        q.offer(new int[] {nx, ny});
                        visited[nx][ny] = true; // 빼먹지마라
                        size++;
                    }
                }
            }
        }
        return size;
    }
}
