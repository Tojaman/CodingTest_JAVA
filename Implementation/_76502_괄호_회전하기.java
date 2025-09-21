package Implementation;

import java.util.HashMap;
import java.util.Stack;

class _76502_괄호_회전하기 {
    public int solution(String s) {
        int answer = 0;
        HashMap<Character, Character> revers = new HashMap<>();
        revers.put(']', '[');
        revers.put('}', '{');
        revers.put(')', '(');
        Stack<Character> stack = new Stack<>();
        
        // 최종: O(n^2): 1,000,000
        // O(n)
        for (int i = 0; i < s.length(); i++) {
            stack.clear();
            StringBuilder sb = new StringBuilder();
            String moveString = sb.append(s.substring(i)).append(s.substring(0, i)).toString();
            boolean result = true;
            // O(n)
            for (int j = 0; j < moveString.length(); j++) {
                char now = moveString.charAt(j);
                
                if (now == '[' || now == '{' || now == '(') {
                    stack.push(now);
                } else {
                    if (stack.isEmpty() || stack.pop() != revers.get(now)) {
                        result = false;
                        break;
                    }
                }
            }
            if (stack.isEmpty() && result) {
                answer++;
            }
        }
        return answer;
    }
}