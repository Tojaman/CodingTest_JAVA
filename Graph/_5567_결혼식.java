package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 풀이 방법 - DFS, BFS
무방향 그래프
최대 수를 구하라 -> 끝까지 탐색 -> DFS
💥인 줄 알았으나, 최대 친구의 친구까지만이라는 조건이 있으므로 BFS가 맞긴 함
근데 둘 다 가능하고, 별 차이 없음
난 DFS로 품
*/

// 26.02.08 - DFS
// 구현 시간: 1시간 14분;;
public class _5567_결혼식 {
    static int n, m;
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 2 ≤ n ≤ 500
        m = Integer.parseInt(br.readLine()); // 1 ≤ m ≤ 10000

        graph = new LinkedList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        int cnt = 0;
        visited[1] = true;

        Stack<int[]> st = new Stack<>();
        st.add(new int[] {1, 0});

        while (!st.isEmpty()) {
            int[] next = st.pop();
            int value = next[0];
            int depth = next[1];
            
            if (depth > 1) continue; // 친구의 친구의 친구 이상 탈출
            
            // 현재 노드와 연결된 노드 순환
            for (int i = 0; i < graph[value].size(); i++) {
                // 연결된 노드를 방문하지 않았다면 Stack Push
                if (!visited[graph[value].get(i)]) {
                    st.add(new int[] {graph[value].get(i), depth+1});
                    visited[graph[value].get(i)] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}

// 26.02.08 - BFS
/*
public class _5567_결혼식 {
    static int n, m;
    static LinkedList<Integer>[] graph;
    static int[] depth;
    static boolean[] visited;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 2 ≤ n ≤ 500
        m = Integer.parseInt(br.readLine()); // 1 ≤ m ≤ 10000

        graph = new LinkedList[n+1];
        depth = new int[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        int cnt = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            
            if (depth[now] == 2) continue; // 친구의 친구의 친구 이상 탈출
            
            // 현재 노드와 연결된 노드 순환
            for(int next : graph[now]){
                if(visited[next]) continue;
                visited[next] = true;
                depth[next] = depth[now] + 1;
                q.offer(next);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
*/