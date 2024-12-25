package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 1 2 3 4 5 6 7
 * 4 5 6 7 1 2
 * 7 1 2 4 5
 * 4 5 7 1
 * 1 4 5
 * 1 4
 * 3 6 2 7 5 1 4
 */

/**
 * k-1까지 offer -> poll하고 k번째 값 저장
 */
public class _1158_요세푸스_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int k = Integer.parseInt(st.nextToken()); // k번째 사람 제거

        for (int i = 1; i <= n; i++) q.offer(i);

        ArrayList<Integer> arr = new ArrayList<>();
        while(true) {
            for (int i = 0; i < k; i++) {
                if (i == k - 1) {
                    arr.add(q.poll());
                    break;
                }
                q.offer(q.poll());
            }
            if (arr.size() == n) break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
            if (i != arr.size()-1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
