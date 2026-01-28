import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1992_쿼드트리 {
    static char[][] tree;
    static int[] result = new int[2];
    static StringBuilder sb = new StringBuilder();
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 2, 4, 8, 16, 32, 64, 128
        tree = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                tree[i][j] = input.charAt(j);
            }
        }

        recur(0, 0, n);
        System.out.println(sb.toString());
        
    }

    // 재귀 함수: n/2, 4등분
    static void recur(int x, int y, int n) {

        // base Condition
        if (n == 1) {
            sb.append(tree[x][y]);
            return;
        }

        

        if (!isSame(x, y, n)) {
            sb.append("(");
            recur(x, y, n/2);
            recur(x, y+n/2, n/2);
            recur(x+n/2, y, n/2);
            recur(x+n/2, y+n/2, n/2);
            sb.append(")");
        } else {
            sb.append(tree[x][y]);
        }
    }

    static boolean isSame(int x, int y, int n) {
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (tree[x][y] != tree[i][j]) return false; // 다름 -> 재귀
            }
        }
        return true;
    }
}