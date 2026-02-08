package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 풀이 방법
전우/중위/후위 순회 결과 출력

A: 루트 노드

lc[]: index(현재 노드), value(왼쪽 자식 노드)
rc[]: index(현재 노드), value(오른쪽 자식 노드)
*/
// 2026.02.08
// 구현 시간: ❌실패
public class _1991_트리_순회 {
    static int n;
    static int[] lc, rc;
    static StringBuilder vlr, lvr, lrv;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vlr = new StringBuilder(); // 전위
        lvr = new StringBuilder(); // 중위
        lrv = new StringBuilder(); // 후위
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        lc = new int[n+1];
        rc = new int[n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            char now = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left != '.') lc[now-'A'] = left-'A';
            if (right != '.') rc[now-'A'] = right-'A';
        }

        vlr(0);
        lvr(0);
        lrv(0);
        System.out.println(vlr.toString());
        System.out.println(lvr.toString());
        System.out.println(lrv.toString());
    }

    static void vlr(int now) {
        // now -> 왼 -> 오
        vlr.append((char) (now + 'A'));
        if (lc[now] != 0) vlr(lc[now]);
        if (rc[now] != 0) vlr(rc[now]);
        
    }

    static void lvr(int now) {
        // 왼 -> 중 -> 오
        if (lc[now] != 0) lvr(lc[now]);
        lvr.append((char) (now + 'A'));
        if (rc[now] != 0) lvr(rc[now]);
    }

    static void lrv(int now) {
        // 왼 -> 오 -> 중
        if (lc[now] != 0) lrv(lc[now]);
        if (rc[now] != 0) lrv(rc[now]);
        lrv.append((char) (now + 'A'));
    }
}
