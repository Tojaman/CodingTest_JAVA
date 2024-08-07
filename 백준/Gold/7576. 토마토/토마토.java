import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 문제 설명
 * 보관 후 하루 지나면 익은 토마토 주변 안익은 토마토 익음
 */
class Node {
    int x, y, idx;

    Node(int x, int y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로 칸 수
        int M = Integer.parseInt(st.nextToken()); // 가로 칸 수

        int[][] box = new int[M][N];
        ArrayList<int[]> one = new ArrayList<>();
        int oneCnt = 0;
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(input[j]);
                if (Objects.equals(input[j], "1")) {
                    one.add(new int[]{i, j});
                }
                if (Objects.equals(input[j], "0")) {
                    oneCnt += 1;
                }
            }
        }
        if (oneCnt == 0) {
            System.out.println(0);
            return;
        }

        int result = bfs(box, one, N, M);
        System.out.println(result);
    }

    public static int bfs(int[][] box, ArrayList<int[]> one, int N, int M) {
        Queue<Node> q = new LinkedList<>();
        int cnt = 0;
        for (int[] node : one) {
            q.offer(new Node(node[0], node[1], cnt));
        }

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.idx != cnt) // 1초가 지났을 경우
                cnt++;

            for (int i = 0; i < 4; i++) {
                int cx = node.x + dx[i];
                int cy = node.y + dy[i];
                if (cx >= 0 && cx < box.length && cy >= 0 && cy < box[0].length && box[cx][cy] == 0) {
                    box[cx][cy] = 1;
                    q.offer(new Node(cx, cy, cnt + 1));
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
        return cnt;

    }
}

