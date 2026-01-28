package recur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074_Z {
    static StringBuilder sb = new StringBuilder();
    static int result = 0;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(recur(n, r, c));

    }

    // 원판 n개를 a기둥에서 b기둥으로 옮기기
    static int recur(int n, int r, int c) {

        // base condition
        if (n == 0) {
            return 0;
        }

        // 4등분 한 뒤 1, 2, 3, 4번째 사각형 중 어디 속하는지 파악하여 m번째 사각형까지 recur
        int half = 1 << (n-1);
        if (r < half && c < half) return recur(n-1, r, c); // 1
        if (r < half && c >= half) return half*half + recur(n-1, r, c-half); // 2
        if (r >= half && c < half) return 2*half*half + recur(n-1, r-half, c); // 3
        return 3*half*half + recur(n-1, r-half, c-half); // 4

        
    }
}