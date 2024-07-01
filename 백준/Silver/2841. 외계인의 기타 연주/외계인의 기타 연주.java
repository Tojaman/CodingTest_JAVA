import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 각 라인의 스택을 따로따로 만들어줌
        Stack<Integer>[] st = new Stack[7];
        int cnt = 0;

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int P = Integer.parseInt(st1.nextToken());

        // 스택 초기화
        for (int i = 0; i <= 6; i++)
            st[i] = new Stack<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st2.nextToken());
            int prat = Integer.parseInt(st2.nextToken());

            while (!st[line].isEmpty() && st[line].peek() > prat) {
                st[line].pop();
                cnt++;
            }
            if (st[line].isEmpty() || st[line].peek() < prat) {
                st[line].push(prat);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}