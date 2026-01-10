import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

// 구현 시간: 25분 (풀이방법 떠올리는건 쉬운데 구현이 너무 오래걸림;;)
public class _5397_키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 알파벳 대문자, 소문자, 숫자, 백스페이스, 화살표
        int n = Integer.parseInt(br.readLine());
        // O(nm): n(안주어짐), m(1,000,000)
        for (int i = 0; i < n; i++) {
            String input = br.readLine(); // 1 ≤ 길이 ≤ 1,000,000
            LinkedList<Character> ls = new LinkedList<>();
            ListIterator<Character> li = ls.listIterator();
            
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);

                if (ch == '<') {
                    if (li.hasPrevious())
                        li.previous();
                } else if (ch == '>') {
                    if (li.hasNext())
                        li.next();
                } else if (ch == '-') {
                    if (li.hasPrevious()) {
                        li.previous();
                        li.remove();
                    }
                } else { // 숫자
                    li.add(ch);
                }
            }

            StringBuilder sb = new StringBuilder();
            // O(m): 1,000,000
            for (Character c : ls) { // Iterator를 사용하므로 각 요소 접근이 O(1)
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
