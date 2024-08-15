package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _2644_촌수계산 {
    static LinkedList<Integer>[] relatives;
    static boolean visited[];
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        relatives = new LinkedList[n+1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            relatives[i] = new LinkedList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetA = Integer.parseInt(st.nextToken());
        int targetB = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            relatives[parent].add(child);
            relatives[child].add(parent);
        }
        visited[targetA] = true;
        dfs(targetA, targetB, 0);
        System.out.println(result);
    }

    public static void dfs(int nowNode, int finish, int cnt) {
        // 목적지 도달
        if (nowNode == finish) {
            result = cnt;
            return;
        }
        for (int nextNode : relatives[nowNode]) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode, finish, cnt+1);
                visited[nextNode] = false;
            }
        }
    }
}
