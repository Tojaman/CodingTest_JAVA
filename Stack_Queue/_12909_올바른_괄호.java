package Stack_Queue;

import java.util.Stack;
/**
 스택을 이용한 풀이
 1. '('가 나오면 stack에 push
 2. ')'가 나오면 stack을 pop
 이때 실패하는 경우 2가지
 - 모든 String을 돌았는데도 stack이 비어있지 않은 경우
 - stack이 비어 있는데 ')'가 나온 경우
 **/
class _12909_올바른_괄호 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}