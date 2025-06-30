package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * (), [] 균형 맞는지 검증 -> 맞으면 yes, 안맞으면 no
 */

/** 풀이 방법
 * 여는 괄호가 나오면 Stack에 넣고 닫는 괄호가 나오면 짝 검증
 */

public class _4949_균형잡힌_세상 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            if (input.equals(".")) break;

            String result = "yes";
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (ch == '.') break;

                // 왼쪽 괄호면 넣기
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                    continue;
                }
                // 오른쪽 괄호면 짝 검증
                if (ch == ')' || ch == ']') {
                    if (stack.isEmpty()) {
                        result = "no";
                        break;
                    }

                    char pop = stack.pop();
                    if (ch == ')') {
                        if (pop != '(') {
                            result = "no";
                            break;
                        }
                    }
                    else {
                        if (pop != '[') {
                            result = "no";
                            break;
                        }
                    }
                }
            }
            // ⭐조건⭐
            if (!stack.isEmpty()) result = "no";
            System.out.println(result);
        }
    }
}