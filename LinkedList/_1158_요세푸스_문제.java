import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1158_요세푸스_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int cnt = 1;
        while (!q.isEmpty()) {
            if (cnt == k) {
                if (q.size() == 1)
                    sb.append(q.poll()).append(">");
                else
                    sb.append(q.poll()).append(", ");
                cnt = 1;
                continue;
            }
            q.offer(q.poll());
            cnt++;
        }
        System.out.println(sb.toString());
    }
}
