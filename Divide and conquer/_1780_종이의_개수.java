package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/** 풀이 방법
 * 1. 종이를 순서대로 탐색하면서 분할해야 할 종이인지 검증한다.
 * 2. 만약 분할해야 할 종이라면 9등분으로 분할한다.
 *   - 이때 재귀를 이용하여 분할된 종이를 재탐색한다.
 */

/** 아이디어 - 분할 정복(재귀)
 * 처음엔 "9등분된 각 종이를 어떻게 나누지?"" 고민했는데 분할 정복(재귀)을 이용하면 쉽게 풀 수 있는 문제였다.
 * 유형만 외워서 푸니깐 이런 것도 못풀겠네 ;;
 */
public class _1780_종이의_개수 {
    private static int[][] papers;
    private static HashMap<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        papers = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        hm.put(-1, 0);
        hm.put(0, 0);
        hm.put(1, 0);
        cut(1, n, 1, n);

        System.out.println(hm.get(-1));
        System.out.println(hm.get(0));
        System.out.println(hm.get(1));
    }

    public static void cut(int startX, int endX, int startY, int endY) {

        int num = papers[startX][startY];
        boolean change = false;
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (papers[i][j] != num) {
                    change = true;
                    break;
                }
            }
        }

        if (!change) {
            hm.put(num, hm.get(num) + 1);
            return;
        }

        int size = (endX - startX + 1) / 3;
        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                cut(startX + dx * size, startX + (dx + 1) * size - 1, startY + dy * size, startY + (dy + 1) * size - 1);
            }
        }
    }
}
