package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 복습 - 인접 행렬
 * 작은 정점 먼저 방문하여 모든 정점을 방문
 * 정점 번호: 1 ~ N
 * 간선 개수: M
 * 탐색 시작 정점 번호: V
 */
public class _1260_DFS와_BFS {
    static boolean[] visited;
    static boolean[][] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        nodes = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[x][y] = true;
            nodes[y][x] = true;
        }

        StringBuilder sb = new StringBuilder();
        dfs(v, sb);
        System.out.println(sb.toString().trim());
        
        bfs(v, n);
    }

    /**
     * 만약 방문한 정점이라면 뒤로 돌아감(return)
     */
    public static void dfs(int nowNode, StringBuilder sb) {

        sb.append(nowNode + " ");
        // 방문한하지 않은 정점이면 방문
        if (!visited[nowNode]) {
            visited[nowNode] = true;
            for (int i = 1; i < nodes[nowNode].length; i++) {
                if (!visited[i] && nodes[nowNode][i]) {
                    dfs(i, sb);
                }
            }
        }
    }

    public static void bfs(int startNode, int n) {
        boolean[] visitedBfs = new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        queue.offer(startNode);
        visitedBfs[startNode] = true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            sb.append(nowNode + " ");

            for (int i = 1; i < nodes[nowNode].length; i++) {
                
                // 방문하지 않았고 연결된 노드라면
                if (!visitedBfs[i] && nodes[nowNode][i]) {
                    queue.offer(i);
                    visitedBfs[i] = true;
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}

/** 처음 풀이 - 인접 리스트
public class Main {
    public static LinkedList<Integer>[] adj;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int v = Integer.parseInt(st.nextToken()); // 시작 정점 번호

        adj = new LinkedList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new LinkedList<>();

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            adj[node1].add(node2);
            adj[node2].add(node1);
        }

        for (int i = 1; i < adj.length; i++) Collections.sort(adj[i]);

        
        StringBuilder sb = new StringBuilder();
        dfs(v, sb);
        System.out.println(sb.toString().trim());

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        System.out.println(bfs(v));
        
    }

    public static String bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node + " ");

            for (int i = 0; i < adj[node].size(); i++) {
                int nextNode = adj[node].get(i);
                
                if (!visited[nextNode]) {
                    q.offer(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
        return sb.toString().trim();
    }

    public static void dfs(int nowNode, StringBuilder sb) {
        visited[nowNode] = true;
        sb.append(nowNode + " ");
        for (int i = 0; i < adj[nowNode].size(); i++) {
            int nextNode = adj[nowNode].get(i);

            if (!visited[nextNode]) {
                dfs(nextNode, sb);
            }
        }
    }
}
 */