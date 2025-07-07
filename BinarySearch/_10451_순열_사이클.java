import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 순열: 1~N까지 중복없는 숫자들의 수열
 * 순열의 각 노드는 반드시 출발지이지 도착지가 되기 때문에 무조껀 사이클임
 * 사이클 검증 로직 - if (now == start) return true; <= 이 검증 로직 필요 없음
 */
public class _10451_순열_사이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] permutation = new int[n+1];
            for (int j = 1; j <= n; j++) {
                permutation[j] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            boolean[] visited = new boolean[n+1];
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    dfs(j, permutation[j], permutation, visited);
                    result++;
                }
            }
            System.out.println(result);
        }
        
    }

    public static void dfs(int start, int now, int[] permutation, boolean[] visited) {
        
        visited[now] = true;

        int next = permutation[now];
        if (!visited[next]) {
            dfs(start, permutation[now], permutation, visited);
        }
    }
}


/** 풀이1
 * 순열은 반드시 사이클이므로 검증 로직 불필요

public class _10451_순열_사이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] permutation = new int[n+1];
            for (int j = 1; j <= n; j++) {
                permutation[j] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            boolean[] visited = new boolean[n+1];
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    if (dfs(j, permutation[j], permutation, visited)) {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
        
    }

    public static boolean dfs(int start, int now, int[] permutation, boolean[] visited) {
        
        visited[now] = true;

        if (now == start) {
            return true;
        }

        int next = permutation[now];
        if (!visited[next]) {
            return dfs(start, permutation[now], permutation, visited);
        }
        

        return false;
    }
}
*/