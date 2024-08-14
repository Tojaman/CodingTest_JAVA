package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _2668_숫자고르기 {
    static ArrayList<Integer> cycle = new ArrayList<>();
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        System.out.println(cycle.size());
        Collections.sort(cycle);
        for (int val : cycle) {
            System.out.println(val);
        }
    }
    public static void dfs(int now, int first) {
        if (!visited[arr[now]]) {
            visited[arr[now]] = true;
            dfs(arr[now], first);
            visited[arr[now]] = false;
        }

        // 사이클이라면
        if (arr[now] == first) {
            cycle.add(first);
        }
    }
}
