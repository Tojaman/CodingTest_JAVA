package Heap; /** 문제 설명
모든 음식 스코빌 지수 >= K로 만들기.
아래 방식을 이용하여 모든 음식의 스코빌 지수를 K이상으로 만든다.
섞은 음식의 스코빌 지수 = 스코빌 지수 가장 낮은 음식 스코빌 지수 + (두 번째로 낮은 음식 스코빌 지수 *2)
*/

/** 입력값, 출력값
- 입력값
scoville[]: 스코빌 지수 담은 배열
K: 목표 스코빌 지수
- 출력값
스코빌 지수를 K로 만들기 위해 섞어야 하는 최소 횟수
*/

/** 풀이 방법

*/
import java.util.*;
class _42626_더_맵게 {
    public int solution(int[] scoville, int K) {
        
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : scoville)
            minHeap.add(num);
        
        int cnt = 0;
        while (minHeap.size() > 1 && minHeap.peek() < K) {
            minHeap.add(minHeap.poll() + (minHeap.poll() * 2));
            cnt++;
        }
        if (minHeap.size() == 1 && minHeap.peek() < K)
                return -1;
        // while (!minHeap.isEmpty() && minHeap.peek() < K) {
        //     if (minHeap.size() == 1 && minHeap.peek() < K)
        //         return -1;
        //     minHeap.add(minHeap.poll() + (minHeap.poll() * 2));
        //     cnt++;
        // }
        
        
        
        return cnt;
    }
}