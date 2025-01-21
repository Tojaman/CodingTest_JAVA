import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1459_걷기 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); // 집 위치 x
        int y = Integer.parseInt(st.nextToken()); // 집 위치 y
        int w = Integer.parseInt(st.nextToken()); // 가로, 세로 걸리는 시간
        int s = Integer.parseInt(st.nextToken()); // 대각선 걸리는 시간

        // int[][] map = new int[x+1][y+1];

        int nx = 0;
        int ny = 0;
        long result = 0;
        while (nx != x || ny != y) {
            char now;
            // 목표 지점의 x, y 좌표가 모두 크다면 -> 대각선 or 일직선*2 이동
            if (nx < x && ny < y) {
                nx++;
                ny++;
                // 대각선 vs 일직선*2 비교하여 작은 값으로 이동
                result += Math.min(w*2, s);
            // 목표 지점의 x or y 한 좌표만 크다면
            } else if (nx < x || ny < y) {
                if (nx < x) now = 'x';
                else now = 'y';

                // 만약 이동 거리가 2칸 이상이라면 -> 대각선*2 vs 일직선*2 이동
                if (nx + 2 <= x || ny + 2 <= y) {
                    if (now == 'x') nx += 2;
                    else ny += 2;

                    // 대각선*2 vs 일직선*2 비교하여 작은 값으로 이동
                    result += Math.min(s*2, w*2);
                // 만약 이동 거리가 1칸이라면 일직선 이동
                } else {
                    if (now == 'x') nx++;
                    else ny++;
                    result += w;
                }
            }
        }
        System.out.println(result);
    }
}