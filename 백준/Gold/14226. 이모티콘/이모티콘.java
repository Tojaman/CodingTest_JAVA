import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Emoji {
        int value, copy, time;
        Emoji(int value, int copy, int time) {
            this.value = value;
            this.copy = copy;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());
        System.out.println(bfs(S));
    }

    public static int bfs(int S) {
        // {현재 값, 현재 복사 중인 값, 시간}
        Queue<Emoji> q = new LinkedList<>();
        q.add(new Emoji(1, 0, 0));

        boolean[][] visited = new boolean[1001][1001];
        visited[1][0] = true;

        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Emoji e = q.poll();

            // 최초 구한 값이 최솟값이므로 바로 반환
            if (e.value == S) {
                return e.time;
            }

            // 복사
            if (!visited[e.value][e.value]) {
                q.add(new Emoji(e.value, e.value, e.time + 1));
                visited[e.value][e.value] = true;
            }
            // 붙여넣기
            if (e.value+e.copy <= S && !visited[e.value+e.copy][e.copy]) {
                q.add(new Emoji(e.value + e.copy, e.copy, e.time + 1));
                visited[e.value + e.copy][e.copy] = true;
            }
            // 삭제
            if (e.value - 1 >= 0 && !visited[e.value - 1][e.copy]) {
                q.add(new Emoji(e.value - 1, e.copy, e.time + 1));
                visited[e.value - 1][e.copy] = true;
            }
        }
        return -1;
    }
}
