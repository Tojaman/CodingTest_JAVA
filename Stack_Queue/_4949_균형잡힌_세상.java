package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/** 조건
 * 알파벳, 공백, (), []만 사용 가능 && 마지막은 .으로 끝남(종료 조건)
 * 소괄호는 소괄호끼리, 대괄호는 대괄호끼리
 */

/** 풀이 방법
 * 열린 괄호가 나오면 스택에 push하고 같은 종류의 닫힌 괄호가 나오면 pop한다.
 * 스택에 괄호가 남으면 no
 * 스택에 짝이 없는 닫힌 괄호가 나오면 no
 */

/** 실수
 * 각 문자를 char가 아닌 String으로 받음 -> 만약 "(str home"이라는 문자열이 있다면 "(str"을 한 덩어리로 받음
 */
public class _4949_균형잡힌_세상 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true) {
            Stack<Character> stack = new Stack<>();
            String result = "yes";

            String input = br.readLine();
            // 종료 조건
            if (input.equals(".")) break;
            char[] chars = input.toCharArray();

            // 문자열이 끝날 때까지 반복
            for (char ch : chars) {
                // 열린 괄호
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                    continue;
                }
                // 닫힌 괄호
                if (ch == ')' || ch == ']') {
                    if (stack.isEmpty()) { // 스택이 비어있으면 바로 오류 처리
                        result = "no";
                        break;
                    }
                    char stNow = stack.pop();
                    // 열린 괄호와 닫힌 괄호의 짝이 안 맞으면 no 출력 후 종료
                    if (ch == ')' && stNow != '(') {
                        result = "no";
                        break;
                    }
                    if (ch == ']' && stNow != '[') {
                        result = "no";
                        break;
                    }
                }
            }
            // 스택이 비어있지 않은 경우
            if (!stack.isEmpty()) {
                result = "no";
            }
            System.out.println(result);
        }

    }
}
