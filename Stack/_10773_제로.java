import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10773_제로 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> st = new Stack<>();
        // 0 -> 한자리 삭제 (stack pop)
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine()); // 0 ~ 1,000,000

            if (n == 0) {
                st.pop();
                continue;
            }

            st.push(n);
        }

        int result = 0;
        while (!st.empty()) {
            result += st.pop();
        }
        System.out.println(result);
    }
}
