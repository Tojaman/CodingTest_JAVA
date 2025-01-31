import java.io.*;
import java.util.*;

// 나중에 한번 더 보기
// 앞 자리에 큰 수가 오도록 하는 것이 핵심
/** 풀이 방법: 한 자리씩 비교하며(그리디) 큰 숫자가 앞에 오도록 한다.
 * 1. number 순환하며 현재 값과 덱의 peek 값을 비교
    - 현재 값이 크다면 덱에 있는 값을 삭제한다.(3, 5 일 경우 3 삭제하고 5가 앞자리가 됨)
    - 현재 값이 작다면 덱에 현재 값을 삽입한다.(5, 3 일 경우 5가 그대로 앞자리를 유지하고 3이 그 뒤를 이음)
 * 2. 아직 제거할 숫자가 남았다면(k > 0) 나머지 number를 덱에 k 개수만큼 넣는다.
 * 3. 덱에 있는 숫자를 String 형태로 변환하며 반환한다.
 */
class Solution {
    public String solution(String number, int k) {
        
        
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < number.length(); i++) {
            
            char nowNum = number.charAt(i);
            int size = dq.size();
            for (int j = 0; j < size; j++) {
                if (dq.peekLast() < nowNum && k > 0) {
                    dq.removeLast();
                    k--;
                } else break; // 이거 안붙이면 시간 초과
            }
            dq.addLast(nowNum);
        }

        while (k > 0) {
            dq.removeLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pop());    
        }
        
        
        return sb.toString();
    }
}