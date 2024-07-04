import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 최단 경로를 구하는 문제이기 때문에 BFS를 사용한다.
 */
public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 미로 만들기
        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
//            // /10을 하여 정수를 나누는 방식은 예제3에서 int 범위를 초과하는 입력 값을 받을 때 문제가 발생함
//            int number = Integer.parseInt(br.readLine());
//            int j = M-1;
//            // * 정수 나누는 거 못해서 찾아봄 *
//            while (number > 0) {
//                int digit = number % 10;
//                maze[i][j--] = digit;
//                number /= 10;
//            }
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        /** BFS 최단 거리 탐색
         * [0, 0]에서 시작하여 [N, M]까지의 최단 거리를 찾는다.
         * 1. 상하좌우를 탐색하여 값이 1인 칸들을 찾아서 아래 작업을 수행한다.
         *      이동(큐에 삽입)
         *      이동한 칸을 방문 표시(visit[해당 칸] = true)
         *      이동한 칸에 이동 횟수를 삽입(move[현재][현재] == move[이전][이전] + 1
         * 2. 상하좌우 모두 탐색을 완료했다면 큐의 맨 앞의 값을 가져와서(q.pop()) 1번 과정을 반복한다.
         * 3. 만약 현재 칸이 [N, M]이라면 탐색을 종료하고 [N, M]의 최소 이동 횟수(move[N][M])를 출력한다.
         */

        Queue<int[]> q = new LinkedList<>();
        boolean visit[][] = new boolean[N][M];
        int move[][] = new int[N][M];
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};

        visit[0][0] = true;
        move[0][0] = 1;
        q.add(new int[] {0, 0});
        
	    // BFS 실행
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];

            /**
            상하좌우 탐색하여 미로 내부 && 값이 1 && 아직 방문하지 않는 칸이라면
            1. 방문 처리
            2. 큐에 삽입
            3. 해당 칸으로 이동(이동 횟수 업데이트)
		    */
            for (int i = 0; i < 4; i++) {
                int nextx = nowx + dx[i];
                int nexty = nowy + dy[i];
                if (nextx < 0 || nexty < 0 || nextx >= N || nexty >= M)
                    continue;
//                if (visit[nextx][nexty] == true || maze[nextx][nexty] == 0)
//                    continue;
                if (maze[nextx][nexty] == 1 && visit[nextx][nexty] == false) {
                    visit[nextx][nexty] = true;
                    q.add(new int[] {nextx, nexty});
                    move[nextx][nexty] = move[nowx][nowy] + 1;
                }
            }
        }

        System.out.println(move[N-1][M-1]);
    }
}