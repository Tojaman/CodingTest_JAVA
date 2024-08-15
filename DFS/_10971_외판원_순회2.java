package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10971_외판원_순회2 {
    static int[][] costSet;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        costSet = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                costSet[i][j] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 0, 1, n);
            visited[i] = false;
        }

        System.out.println(minCost);
    }

    public static void dfs(int start, int nowNode, int cost, int cnt, int n) {
        if (cnt == n && costSet[nowNode][start] != 0) {
            minCost = Math.min(minCost, cost + costSet[nowNode][start]);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && costSet[nowNode][i] != 0) {
                visited[i] = true;
                dfs(start, i, cost + costSet[nowNode][i], cnt + 1, n);
                visited[i] = false;
            }
        }
    }
}
