package BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 주어진 BOJ 유저 중 케빈 베이컨의 수가 가장 적은 사람 찾기
 * 케빈 베이컨 수: 주어진 모든 BOJ 유저와의 연결 단계 수의 합
*/

/** 풀이 과정
 * 링크드 리스트로 유저들의 관계를 연결
 */
public class _1389_케빈_베이컨의_6단계_법칙 {
    public static LinkedList<Integer>[] relation;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 유저의 수(노드의 수)
        int m = Integer.parseInt(st.nextToken()); // 친구 관계의 수(간선의 수)

        relation = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) relation[i] = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int user1 = Integer.parseInt(st.nextToken());
            int user2 = Integer.parseInt(st.nextToken());

            relation[user1].add(user2);
            relation[user2].add(user1);
        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = n; i >= 1; i--) {
            int cnt = bfs(i, n);
            min = Math.min(cnt, min);
            if (cnt == min) {
                result = i;
            }
        }
        System.out.println(result);
    }

    /** 고민한 부분: int[] cnts = new int[nodeCnt + 1];
     * 각 노드까지 최단 경로를 어떻게 저장할지 고민했다.
     * 그냥 배열에 저장하면 되는 건데 ... 왜이렇게 오래 고민한지 모르겠네 ..
     */
    public static int bfs(int start, int nodeCnt) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[nodeCnt + 1];

        q.offer(start);
        visited[start] = true;

        // 각 노드 별 거리를 저장하기 위한 배열
        // cnt[target]: start 노드에서 target 노드까지 최단 경로
        int[] cnts = new int[nodeCnt + 1];
        
        while(!q.isEmpty()) {
            start = q.poll();

            for (int i = 0; i < relation[start].size(); i++) {
                int next = relation[start].get(i);
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    // 다음 노드의 최단 경로 = 이전 노드까지 최단 경로 + 1
                    cnts[next] = cnts[start] + 1;
                }
            }
        }

        // 모든 사람과 최단 경로의 합
        int totalCnt = 0;
        for (int cnt : cnts)
            totalCnt += cnt;
        return totalCnt;
    }
}
