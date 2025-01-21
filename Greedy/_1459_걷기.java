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

        /** 두 번째 풀이
         * 1. 대각선으로 이동할 수 있는 만큼 이동한다.
         *      이때 대각선과 직전*2를 비교하여 작은 값을 이동한다.
         * 2. 남은 거리는 x축이나 y축으로 일직선 이동해야 하는 거리이다.
         *      1. 2칸 이상 남은 경우 -> 두 칸을 직선*2나 대각선*2로 이동할 수 있으므로 두 값을 비교하여 작은 값으로 이동한다.
         *      2. 나머지 한 칸이 남은 경우 직선 이동하고 남지 않은 경우 이동하지 않는다.
         */
        long result = 0;
        // 1. 대각선 이동 -> x와 y를 비교하여 작은 값만큼 대각선으로 이동한다.
        long move = Math.min(x, y);
        result +=  move * (long) Math.min(w*2, s);

        // 2. 직선 이동
        // 만약 2칸 이상 남았다면 일직선*2과 대각선*2 비교하여 작은 값으로 이동
        long remain = Math.abs(x - y);
        if (remain >= 2) {
            result += Math.min(w*2, s*2) * (remain / 2);
        }
        // 남은 한 칸이 있을 경우 일직선 이동(없을 경우 remain이 0이므로 이동하지X)
        result += w * (remain % 2);

        System.out.println(result);

        /** 첫 번째 풀이
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
        */
    }
}