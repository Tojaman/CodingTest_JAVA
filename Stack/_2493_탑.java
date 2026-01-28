import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 구현 시간: 50분
// 1차 시간 초과 (O(n^2))
// 2차 GPT 참고 (O(n+n)): 모노토닉 스택: 
public class _2493_탑 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 500,000
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // O(n+n)
        for (int i = 1; i <= n; i++) {
            int cur = Integer.parseInt(st.nextToken());

            // 총 n번 실행 시간 복잡도 +n
            while (!stack.empty() && stack.peek()[0] < cur) {
                stack.pop();
            }

            if (stack.empty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek()[1]).append(" ");
            }

            stack.push(new int[] {cur, i});
        }
        
        System.out.println(sb.toString().trim());
    }
}

/*
// 브루트포스 방식
// 시간 복잡도 O(n^2)
public class _2493_탑 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tmpSt = new Stack<>();

        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 500,000
        StringTokenizer st = new StringTokenizer(br.readLine());

        // O(n)
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }
        
        // O(n)
        while (!stack.empty()) {
            int cur = stack.pop();

            // O(n)
            while (!stack.empty() && stack.peek() < cur) {
                tmpSt.push(stack.pop());
            }

            if (stack.empty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.lastIndexOf(stack.peek())+1).append(" ");
            }

            // O(n)
            while (!tmpSt.empty()) {
                stack.push(tmpSt.pop());
            }
        }
        
        System.out.println(new StringBuilder(sb.toString()).reverse().toString().trim());
    }
}
*/