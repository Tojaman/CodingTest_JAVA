package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21918_전구 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] bulbs = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            bulbs[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            /** switch-case
             * case 범위가 좁고 연속적일 경우 테이블 기반 점프(jump table) 생성
             * 즉, a가 1~4까지의 좁은 범위이고 연속적이므로 테이블 기반 점프를 생성한다.
             * "테이블 기반 점프": 순차적으로 case 1부터 4까지 검사하는 것이 아닌 바로 case 4로 가서 실행
             * jump table이 생성될 경우 O(1) 보장
             */
            /** if-else
             * 조건을 순차적으로 검증
             * 즉, a가 4일 경우 if (a == 1) 부터 else if (a == 3) 까지 모두 검증한 후 else(4)를 실행하므로 switch-case문에 비해 느림
             * 최악의 경우(case가 4인 경우) O(n)
             */
            switch (a) {
                case 1:
                    bulbs[b] = c;
                    break;
                case 2:
                    _2(bulbs, b, c);
                    break;
                case 3:
                    _3(bulbs, b, c);
                    break;
                case 4:
                    _4(bulbs, b, c);
                    break;
            }
//            if (a == 1) {
//                bulbs[b] = c;
//            } else if (a == 2) {
//                _2(bulbs, b, c);
//            } else if (a == 3) {
//                _3(bulbs, b, c);
//            } else { // a == 4
//                _4(bulbs, b, c);
//            }
        }

        // 숫자 중간에 띄어쓰기 추가O 및 마지막 숫자에는 추가X
        // 이런 부분 놓치지 않기 !!!
        for (int i = 1; i < bulbs.length; i++)
            if (i == bulbs.length-1)
                System.out.print(bulbs[i]);
            else
                System.out.print(bulbs[i] + " ");
    }

    public static void _2(int[] bulbs, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (bulbs[i] == 0)
                bulbs[i] = 1;
            else
                bulbs[i] = 0;
        }
    }

    public static void _3(int[] bulbs, int l, int r) {
        for (int i = l; i <= r; i++)
            bulbs[i] = 0;
    }

    public static void _4(int[] bulbs, int l, int r) {
        for (int i = l; i <= r; i++)
            bulbs[i] = 1;
    }
}
