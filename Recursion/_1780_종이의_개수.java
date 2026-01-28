import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

/* 풀이 방법 - 재귀
1. 함수의 정의 void recur(int x, int y, int n): x, y는 시작 지점, n은 전체 크기
2. base condition: n=1일 때 해당 값 넣고 탈출
3. 재귀 식: n = 9이고 (x, y)가 1번, 2번, 3번, ..., 9번 사각형일 때 각각 모두 같은지 확인 후 하나라도 다르면 recur(n/3, 옮긴 x, 옮긴 y)

n=1일 때 참, n=2일 때 참, n=k일 때 참이니깐 recur 함수 정답
 */
// 구현 시간: 30분
public class _1780_종이의_개수 {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[][] paper;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, n);
        System.out.println(map.get(-1));
        System.out.println(map.get(0));
        System.out.println(map.get(1));

    }

    static void recur(int x, int y, int n) {

        if (n == 1) {
            map.put(paper[x][y], map.getOrDefault(paper[x][y], 0) + 1);
            return;
        }

        int start = paper[x][y];
        boolean isSame = true;
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (start != paper[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }
        if (!isSame) {
            int divid = n/3;
            recur(x, y, divid);
            recur(x, y + divid, divid);
            recur(x, y + 2 * divid, divid);

            recur(x + divid, y, divid);
            recur(x + divid, y + divid, divid);
            recur(x + divid, y + 2 * divid, divid);

            recur(x + 2 * divid, y, divid);
            recur(x + 2 * divid, y + divid, divid);
            recur(x + 2 * divid, y + 2 * divid, divid);
        } else {
            map.put(paper[x][y], map.getOrDefault(paper[x][y], 0) + 1);
        }
        
    }
}