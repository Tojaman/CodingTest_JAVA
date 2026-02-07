package DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


/* 풀이 방법
끝까지 탐색해야 하므로 DFS
*/
// 복습: 2026.02.08
// 구현 시간: 20분 (초기화 안함;;)
public class _11724_연결_요소의_개수 {
    static boolean[] visited;
    static LinkedList<Integer>[] graph;
    static int n, m;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new LinkedList[n+1];
        visited = new boolean[n+1];

        // 💥초기화 반드시 해야 함
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph[u].add(v);
            graph[v].add(u);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static public void dfs(int node) {
        visited[node] = true;

        // 노드를 돌면서 방문하지 않은 노드 방문
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}


/** 복습 풀이 - 25.07.14
 * 1. LinkedList로 그래프 그리기
 * 2. DFS 탐색을 통해 연결 요소의 개수 구하기
 */
public class _11724_연결_요소의_개수 {
    private static LinkedList<Integer>[] ll;
    private static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        ll = new LinkedList[n+1];
        for (int i = 1; i <= n; i++)
            ll[i] = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            ll[node1].add(node2);
            ll[node2].add(node1);
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.print(result);
    }

    public static void dfs(int node) {

        visited[node] = true;
        for (int nextNode : ll[node]) {
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }
}

/* 첫번째 풀이
public class Main {
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
**/