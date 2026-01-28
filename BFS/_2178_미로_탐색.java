package BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178_미로_탐색 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());



    }
}














/*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 미로 만들기
        int[] maze = new int[N * M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i * M + j] = line.charAt(j) - '0';
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N * M];
        int[] move = new int[N * M];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        visit[0] = true;
        move[0] = 1;
        q.add(0);

        // BFS 실행
        while (!q.isEmpty()) {
            int now = q.poll();
            int nowx = now / M;
            int nowy = now % M;

            for (int i = 0; i < 4; i++) {
                int nextx = nowx + dx[i];
                int nexty = nowy + dy[i];
                if (nextx < 0 || nexty < 0 || nextx >= N || nexty >= M)
                    continue;
                
                int next = nextx * M + nexty;
                if (maze[next] == 1 && !visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    move[next] = move[now] + 1;
                }
            }
        }
        System.out.println(move[N * M - 1]);
    }
}
*/