package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 2026.01.17
/* 풀이 방법 - BFS
최소 일수 구하기 -> BFS
익은 토마토 여러개일 수도 있음
box에 이동 거리를 저장할거라 visited 불필요
*/
// 구현 시간: 30분 (n, m 거꾸로 씀)
// 실제 구현 시간: 20분
public class _7576_토마토 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 2 ≤ M,N ≤ 1,000
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n+1][m+1];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                // 0(익지X), 1(익음), -1(토마토 없음)
                int tomato = Integer.parseInt(st.nextToken());
                box[i][j] = tomato;

                // 1 이상이면 익은거니깐 이동X, 즉, 0일 때만 이동
                if (tomato == 1) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        
        int result = 0;
        while (!q.isEmpty()) {
            int[] nowNode = q.poll();
            int cx = nowNode[0];
            int cy = nowNode[1];
            result = Math.max(result, box[cx][cy]);

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx > 0 && nx <= n && ny > 0 && ny <= m) {
                    if (box[nx][ny] == 0) { // -1, 1보다 큰 수 제외
                        q.offer(new int[] {nx, ny});
                        box[nx][ny] = box[cx][cy]+1; // 시간 (이동 거리)
                    }
                }
            }
        }

        boolean isAll = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (box[i][j] == 0)
                    isAll = false;
            }
        }
        if (isAll) System.out.print(result-1);
        else System.out.print(-1);
        
    }
}


/** 문제 설명
 * 보관 후 하루 지나면 익은 토마토 주변 안익은 토마토 익음
class Node {
    int x, y, idx;

    Node(int x, int y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}
public class _7576_토마토 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Node> q = new LinkedList<>();
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로 칸 수
        int M = Integer.parseInt(st.nextToken()); // 가로 칸 수

        int[][] box = new int[M][N];
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(input[j]);
                if (Objects.equals(input[j], "1")) {
                    q.offer(new Node(i, j, 0 ));
                }
            }
        }
        System.out.println(bfs(box, N, M));
    }

    public static int bfs(int[][] box, int N, int M) {
        int time = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.idx != time) // 1초가 지났을 경우
                time++;

            for (int i = 0; i < 4; i++) {
                int cx = node.x + dx[i];
                int cy = node.y + dy[i];
                if (cx >= 0 && cx < box.length && cy >= 0 && cy < box[0].length && box[cx][cy] == 0) {
                    box[cx][cy] = 1;
                    q.offer(new Node(cx, cy, time + 1));
                }
            }
        }

        // 토마토가 모두 익지는 못하는 상황 찾기 (-1에 둘러쌓인 경우)
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
            }
        }
        return time;
    }
}
 */