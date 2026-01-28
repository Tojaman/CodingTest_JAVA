package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _9663_N_Queen {
    static int n, cnt;
    static int[][] chess;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        chess = new int[n][n];
        
        back(0);
        System.out.println(cnt);
    }

    static void back(int queen) {

        // 탈출 조건: N개를 놓은 경우
        if (queen == n) {
            cnt++;
            return;
        }

        // 재귀 탐색
        // 같은 열을 놓을 수 없기 때문에 일차원 배열로 처리 가능(각 원소는 열)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (chess[i][j] == 0) { // 방문X
                    boolean isQueen = false;
                    // 상하좌우대각선끝까지 있는지 검증
                    for (int k = 0; k < n; k++) {
                        // 벗어나지 않고
                        if (i+k >= 0 && i+k < n && i-k >= 0 && i-k < n && j+k >= 0 && j+k < n && j-k >= 0 && j-k < n) {
                            // 방문했다면
                            if (chess[i+k][j+k] == 1 || chess[i-k][j-k] == 1 || chess[i+k][j-k] == 1 || chess[i-k][j+k] == 1) {
                                isQueen = true;
                            }
                        }
                    }
                    if (!isQueen) {
                        chess[i][j] = 1;
                        back(queen+1);
                        chess[i][j] = 0;
                    }
                }
                
            }
        }
    }
}