/** 문제 설명
프로세스들이 대기 큐에 있을 때 우선순위(priorities)에 따라 실행됨.
    큐에서 프로세스를 꺼낸 뒤 우선순위가 가장 높은 프로세스라면 실행, 아니라면 다시 큐에 넣음
location 위치에 있는 프로세스가 몇 번째로 실행되는지 return
*/

/** 문제 풀이
priorities를 
*/
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        // 내림차순으로 우선순위 큐 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int answer = 0;
        // 우선순위 큐에 우선순위 삽입
        for (int prioritie : priorities) {
            pq.add(prioritie);
        }
        
        
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    if (location == i)
                        return answer;
                }
            }
        }
        return answer;
    }
    
}