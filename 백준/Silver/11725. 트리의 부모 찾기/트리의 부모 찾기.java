import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new LinkedList[N+1];
        parents = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++)
            graph[i] = new LinkedList<>();
        
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);
        for (int i = 2; i <= N; i++)
            System.out.println(parents[i]);
    }
    public static void dfs(int nowNode) {
        visited[nowNode] = true;

        for (int node : graph[nowNode]) {
            if (!visited[node]) {
                parents[node] = nowNode;
                dfs(node);
            }
        }
    }
}
