package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 풀이 방법
 * - 다음 정사각형의 한 변의 길이 = 전 정사각형의 한 변의 길이 + 전전 정사각형의 한 변의 길이
 * 즉, sides[n] = sides[n-1] + sides[n-2]
 * - 직사각형의 너비 = sides[n] * 2 + (sides[n] + sides[n-1]) * 2
 */
public class _13301_타일_장식물 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.print(4);
            return;
        }
        if (n == 2) {
            System.out.print(6);
            return;
        }
        long[] sides = new long[n+1];
        sides[1] = 1;
        sides[2] = 1;
        for (int i = 3; i <= n; i++) {
            sides[i] = sides[i-1] + sides[i-2];
        }

        long perimeter = sides[n]*2 + (sides[n]+sides[n-1]) *2;
        System.out.print(perimeter);
    }
}
