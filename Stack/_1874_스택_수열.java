import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 구현 시간: 1회차 실패, 2회차 17분
public class _1874_스택_수열 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(); 
        Stack<Integer> st = new Stack<>();

        // [1, 2, 3, ..., n]
        st.push(0);
        int cur = 0;
        
        int n = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 100,000
        // O(n^2): 100억
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            if (!st.empty() && target > st.peek()) {
                while (st.peek() != target) {
                    st.push(++cur);
                    sb.append("+").append("\n");
                }
            } else if (!st.empty() && target < st.peek()){
                System.out.println("NO");
                return;
            }
            st.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}

/*
public class _1874_스택_수열 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(); 
        Stack<Integer> st = new Stack<>();

        // [1, 2, 3, ..., n]

        st.push(0);
        int cur = 0;
        int peek = 0;
        
        int n = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 100,000
        // O(n^2): 100억
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            if (peek > target) {
                System.out.println("NO");
                return;
            }

            if (peek == target) {
                st.pop();
                peek = st.peek();
                sb.append("-").append("\n");
                continue;
            }

            if (peek < target) {
                // O(n): peek가 0이고 target이 n인 최악의 경우 O(n)라고 생각할 수 있지만 아니다.
                // 왜냐하면 for (n) 반복할 동안 push()는 총 n번만 발생하기 때문에 O(n^2)이 될 수 없다.
                while (peek != target) {
                    st.push(++cur);
                    peek = st.peek();
                    sb.append("+").append("\n");
                }
                st.pop();
                peek = st.peek();
                sb.append("-").append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
*/