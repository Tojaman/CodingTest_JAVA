package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 풀이 방법 - dfs(백트래킹 아님)
1. base condition: 탈출 조건
2. 재귀 함수: arr(m)의 index를 가르키는 index를 인자로 줌
3. 로직: n을 순환하며 arrs[index]에 넣고 다음 index로 이동(재귀)
중복 허용이라 사용한지 검증 필요 없음
*/

// 구현 시간: 4분
public class _15651_N과M3 {
    static int n, m;
    static int[] arrs;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrs = new int[m];

        dfs(0);

        System.out.println(sb.toString().trim());
    }

    // index는 n 값
    static void dfs(int index) {
        
        if (index == m) {
            for (int arr : arrs) sb.append(arr).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arrs[index] = i;
            back(index+1);
        }
    }
}