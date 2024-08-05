import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 문제 설명
 * 우리 병사: 흰색 / 적국 병사: 파란색
 * N명 뭉쳐 있으면 N^2 위력. 즉, 많이 모일 수록 강해짐(대각선은 포함X)
 * N: 가로 / M: 세로
 */

/** 풀이 방법
 * 상하좌우 노드가 현재 노드의 color와 일치하고 방문하지 않았다면 방문처리(큐에 삽입)
 * 큐에 삽입할 때마다 count를 세고 count를 반환하여 제곱한 후 해당 color에 더하기
 * 모든 2차원 배열을 순환하며 방문하지 않은 노드에 대해 위 로직을 실행하고 순환이 끝났다면 white, green 출력
 */

public class Main {
    private static char[][] war;
    private static boolean visited[][];
    private static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    private static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가로
        int M = Integer.parseInt(st.nextToken()); // 세로

        war = new char[M][N];
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                war[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[M][N];

        int white = 0;
        int green = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int count = BFS(i, j, war[i][j]);
                    if (war[i][j] == 'W') {
                        white += (int) Math.pow(count, 2);
                    } else {
                        green += (int) Math.pow(count, 2);
                    }
                }
            }
        }
        System.out.println(white+" "+green);
    }

    public static int BFS(int y, int x, char color) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        // 현재 위치 큐에 삽입
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        count += 1;

        //
        while (!queue.isEmpty()) {
            // 현재 노드 큐에서 빼고
            int[] node = queue.poll();
            int cy = node[0];
            int cx = node[1];

            // color와 일치하고 아직 방문하지 않은 상, 하, 좌, 우 노드 큐에 삽입
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (nx >= 0 && nx < war[0].length && ny >= 0 && ny < war.length) {
                    if (war[ny][nx] == color && visited[ny][nx] != true) {
                        queue.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        count += 1;
                    }
                }
            }
        }
        return count;
    }
}