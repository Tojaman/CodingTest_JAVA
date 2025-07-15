package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 문제 풀이
 * u(⬆️), d(⬇️) 버튼을 최소 몇 번 눌러야 g층에서 s층으로 갈 수 있는지 구하기
 * 최단거리를 구하는 문제이므로 BFS 이용
 */

/** 조건
 * 1. 방문했던 층은 제외
 * 2. 1층 ~ f층까지만 방문 가능
 * 3. 내려가야 하는데 d가 0이거나 올라가야 하는데 u가 0이면 바로 실패 리턴
 */
public class _5014_스타트링크 {
    private static boolean visited[];
    private static int dist[];
    private static int f, s, g, u ,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken()); // 총 층
        s = Integer.parseInt(st.nextToken()); // 현재 층
        g = Integer.parseInt(st.nextToken()); // 목표 사무실 층
        u = Integer.parseInt(st.nextToken()); // 위로 u층
        d = Integer.parseInt(st.nextToken()); // 아래로 d층

        visited = new boolean[f+1];
        dist = new int[f+1];

        if ((s > g && d == 0) || (s < g && u == 0)) {
            System.out.print("use the stairs");
            return;
        }

        bfs(s);
        if (visited[g]) { // 목표 층에 방문했다면
            System.out.print(dist[g]);
        } else { // 방문하지 못했다면
            System.out.print("use the stairs");
        }
    }

    public static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int nowS = q.poll();
            if (nowS == g) {
                break;
            }

            if (nowS + u <= f && !visited[nowS+u]) {
                q.offer(nowS + u);
                visited[nowS+u] = true;
                dist[nowS+u] = dist[nowS]+1;
            }
            if (nowS - d >= 1 && !visited[nowS-d]) {
                q.offer(nowS - d);
                visited[nowS-d] = true;
                dist[nowS-d] = dist[nowS]+1;
            }
        }
    }
}
