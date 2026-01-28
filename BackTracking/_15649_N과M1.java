package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 풀이 방법
1. base condition: 탈출 조건
2. 재귀 함수: arr(m)의 index를 가르키는 index를 인자로 줌
3. 로직: n을 순환하며 사용되지 않은 값은 arrs[index]에 넣고 다음 index로 이동(재귀)
이때 뒤로 이동할 때는 반드시 방문 표시를 해제해야함
*/
// 구현 시간: 15분
public class _15649_N과M1 {
    static int[] arrs;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arrs = new int[m];
        isUsed = new boolean[n+1];

        back(0, n, m);

        System.out.println(sb.toString().trim());
    }

    // index는 n 값
    static void back(int index, int n, int m) {
        
        // base condition
        if (index == m) {
            for (int arr : arrs) sb.append(arr).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                arrs[index] = i;
                isUsed[i] = true;
                back(index+1, n, m);
                isUsed[i] = false;
            }
        }
    }
}