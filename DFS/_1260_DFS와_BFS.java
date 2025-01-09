package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** LinkedList를 이용한 DFS, BFS
 * 
 */
public class _1260_DFS와_BFS {
    public static LinkedList<Integer>[] adj; // 노드를 연결할 링크드리스트 배열
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int v = Integer.parseInt(st.nextToken()); // 시작 정점 번호

        adj = new LinkedList[n + 1];
        visited = new boolean[n + 1];

        // 노드를 저장할 각 배열을 LinkedList로 초기화
        // 삽입과 삭제에서 ArrayList보다 빠르기 때문에 LinkedList 사용용
        // ArrayList 삽입/삭제: 끝에서 삽입 삭제 = O(1) | 시작, 중간에서 삽입/삭제 = O(n)
        // LinkedList 삽입/삭제: 시작, 중간, 끝 삽입 삭제 = O(1)
        for (int i = 1; i <= n; i++) adj[i] = new LinkedList<>();

        /*
        adj[1] = [2, 3, 4]
        adj[2] = [1, 4]
        adj[3] = [1, 4]
        adj[4] = [1, 2, 3]
        */
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            adj[node1].add(node2);
            adj[node2].add(node1);
        }

        // 방문 가능한 정점이 여러개일 경우 정점 번호가 작은 것을 먼저 방문하라는 조건이 있으므로 정렬
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