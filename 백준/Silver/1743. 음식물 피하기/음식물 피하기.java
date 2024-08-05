import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] passage;
    private static boolean visited[][];
    private static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    private static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기 개수

        passage = new int[N+1][M+1];
        for (int i = 0; i < K; i++) {
//            String[] string = br.readLine().split(" ");
//            int r = Integer.parseInt(string[0]);
//            int c = Integer.parseInt(string[1]);
//            passage[r][c] = 1;
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            passage[r][c] = 1;
        }
        visited = new boolean[N+1][M+1];

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visited[i][j] && passage[i][j] == 1) {
                    cnt = Math.max(BFS(i, j), cnt);
                }
            }
        }
        System.out.println(cnt);

    }

    public static int BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        cnt += 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cx = now[0] + dx[i];
                int cy = now[1] + dy[i];

                if (cx >= 1 && cx < passage.length && cy >= 1 && cy < passage[0].length) {
                    if (!visited[cx][cy] && passage[cx][cy] == 1) {
                        queue.offer(new int[]{cx, cy});
                        visited[cx][cy] = true;
                        cnt += 1;
                    }
                }
            }

        }
        return cnt;
    }
}
