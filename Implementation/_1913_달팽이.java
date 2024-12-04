package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1913_달팽이 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][] dalpeng = new int[n][n]; // 행 열

        // 초기 위치 (달팽이 중심)
        int x = n / 2;
        int y = n / 2;
        dalpeng[x][y] = 1;

        // 타겟 위치 초기화
        int tx = target == 1 ? x + 1 : 0; // target이 1일 때는 중심 위치
        int ty = target == 1 ? y + 1 : 0;

        int move = 1; // 현재 숫자
        int cnt = 1; // 현재 이동 거리
        // n*n 2차원 배열의 마지막 숫자까지만 채우고 탈출
        while(move < n*n) {
            // 위쪽, 오른쪽, 아래쪽, 왼쪽 순서대로 이동하기 떄문에 4번 반복
            // move < n * n: 마지막 숫자를 채웠다면 탈출
            for (int j = 0; j < 4 && move < n * n; j++) {
                // 현재 방향으로 cnt만큼 이동
                // 이때 위쪽, 오른쪽보다 아래쪽, 왼쪽이 1칸 더 이동함
                // move < n * n: 마지막 숫자를 채웠다면 탈출
                for (int k = 0; k < cnt && move < n * n; k++) {
                    x = x + dx[j];
                    y = y + dy[j];
                    dalpeng[x][y] = ++move;

                    if (move == target) {
                        tx = x+1;
                        ty = y+1;
                    }
                }
                // 오른쪽 -> 아래쪽으로 바뀔 때(1) && 왼쪽 -> 위쪽으로 바뀔 때(3) 이동 거리가 1 늘어남
                /**
                 * 위 오른 -(+1)-> 아래|아래 왼|왼 -(+1)->
                 * 위|위|위 오른|오른|오른 -(+1)-> 아래|아래|아래|아래 왼|왼|왼|왼 -(+1)->
                 * 위|위|위|위|위 오른|오른|오른|오른|오른 -(+1)-> 아래|아래|아래|아래|아래|아래 왼|왼|왼|왼|왼|왼 -(+1)->
                 */
                if (j == 1 || j == 3) cnt++;
            }
        }

        // 이중 반복문으로 각 항목을 하나하나 출력하는 것보다 StringBuilder로 한번에 출력하는 게 메모리나 속도 면에서 훨씬 효율적
        // 메모리는 3개 줄어들고 속도는 10배 빨라짐
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(dalpeng[i][j]).append(j == n - 1 ? "\n" : " ");
            }
        }
        sb.append(tx).append(" ").append(ty);
        System.out.println(sb);
    }
}
