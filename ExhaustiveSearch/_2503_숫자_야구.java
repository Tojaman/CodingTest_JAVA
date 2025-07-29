package ExhaustiveSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 반성
 * 입력값에서 규칙성을 찾아 정답 가능성이 있는 수를 찾아내려고 했다..
 * 그러나 경우의 수가 너~무 많고 규칙이 찾을 수가 없었다.
 * 그럼 걍 바로 아니구나하고 바로 방향 틀어서 다른 방법을 좀 찾아보자.. 붙잡고 있지좀 마...
 */

/** 풀이 방법(실패) - 다시 풀어보기
 * 답이 될 수 있는 모든 경우의 수(123 ~ 987)와 입력한 수의 스트라이크와 볼을 비교하여 같다면 영수 입장에서는 다음 질문으로 낼 수 있는 수이다.
 * 따라서 3자리 수를 모두 탐색하면서 조건에 맞는 수를 찾아 개수를 출력하면 된다. 
 */
public class _2503_숫자_야구 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 질문 횟수
        int[] arr = new int[988];
        int result = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            // 123 ~ 987 탐색하며 입력 조건에 모두 맞는지 검증
            for (int idx = 123; idx <= 987; idx++) {
                String now = Integer.toString(idx);
                if (now.charAt(0) == now.charAt(1) || now.charAt(0) == now.charAt(2) || now.charAt(1) == now.charAt(2)
                    || now.contains("0")) {  //서로 다른 숫자로 구성되지 않았으면 -1로 지정
                    continue;
                }
                
                int strCnt = 0;
                int ballCnt = 0;

                // 탈출 조건: 앞의 조건에서 맞지 않은 경우 가능성 없는 답이므로 스킵
                if (arr[idx] == -1) {
                    continue;
                }

                // 스트라이크 검증
                for (int k = 0; k < 3; k++) {
                    if (now.charAt(k) == input.charAt(k)) {
                        strCnt++;
                    }
                }

                // 볼 검증
                for (int k = 0; k < 3; k++) {
                    for (int m = 0; m < 3; m++) {
                        // 같은 자리가 아니고(스트라이크 제외) 같은 숫자인 경우 == 볼
                        if (k != m && now.charAt(k) == input.charAt(m)) {
                            ballCnt++;
                        }
                    }
                }

                // n개의 조건 중 i번째 조건과 같은 경우 -> +1
                if (strCnt == strike && ballCnt == ball) {
                    arr[idx]++;
                }
                // i번째 조건에 맞지 않은 경우 탈락 -> -1
                else {
                    arr[idx] = -1;
                }
            }
        }

        for (int idx = 123; idx <= 987; idx++) {
            if (arr[idx] == n)
            result++;
        }
        System.out.print(result);
    }
}
