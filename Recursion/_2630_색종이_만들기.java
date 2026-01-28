import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 구현 시간: 27분
public class _2630_색종이_만들기 {
    static int[][] paper;
    static int[] result = new int[2];
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 2, 4, 8, 16, 32, 64, 128
        paper = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, 0, n);
        System.out.println(result[0] + "\n" + result[1]);
        
    }

    static void recur(int x, int y, int n) {

        int color = paper[x][y];

        // base condition
        if (n == 1) {
            result[color]++;
            return;
        }

        boolean isSame = true;
        // 범위 헷갈리지 마라
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (paper[i][j] != paper[x][y]) {
                    isSame = false;
                    break;
                }
            }
        }

        // 같은 정사각형이라면 개수 더하고 return
        if (isSame) {
            result[color]++;
            return;
        }
        
        // 다르다면 recur
        for (int i = x; i <= x + n/2; i+=n/2) {
            for (int j = y; j <= y + n/2; j+=n/2) {
                recur(i, j, n/2);
            }
        }

    }
}