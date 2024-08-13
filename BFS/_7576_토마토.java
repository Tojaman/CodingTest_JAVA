package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 문제 설명
 * 보관 후 하루 지나면 익은 토마토 주변 안익은 토마토 익음
 *
 */
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

