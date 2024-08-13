package DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _11724_연결_요소의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점(Node)의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선(Edge)의 개수

        LinkedList<Integer>[] list = new LinkedList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new LinkedList<>();
        }
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]){
                dfs(list, visited, i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(LinkedList<Integer>[] list, boolean[] visited, int nowIdx) {
        visited[nowIdx] = true;
        for (int neighbor : list[nowIdx]) {
            if (!visited[neighbor])
                dfs(list, visited, neighbor);
        }
    }
}
