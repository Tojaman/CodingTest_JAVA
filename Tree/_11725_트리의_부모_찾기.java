package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// DFS 디렉토리에 이전 풀이 있음

/* 풀이 방법 - DFS(visited[] 없이)
모든 값을 순환해야 하므로 dfs
depth 필요 없고 parent만 필요
트리 구조를 만든 뒤 dfs를 돌며 부모 배열에 값 삽입
*/
// 2026.02.08
// 구현 시간: 20분
public class _11725_트리의_부모_찾기 {
    static LinkedList<Integer>[] tree;
    static int[] parent;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        tree = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) tree[i] = new LinkedList<>();

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        dfs(1);
        for (int i = 2; i <= n; i++) sb.append(parent[i]).append("\n");
        System.out.println(sb.toString().trim());
    }

    static void dfs(int now) {

        for (int adj : tree[now]) {
            if (parent[now] == adj) continue;
            
            parent[adj] = now;
            dfs(adj);
        }
    }
}
