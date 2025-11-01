package Greedy;

import java.util.*;
/* 풀이 방법
budget으로 최대 몇 개의 d를 만족시킬 수 있는가?
d를 오름차순으로 정렬 후 순서대로 할당
*/
// 풀이 시간: 5분
public class _12982_예산 {
    public int solution(int[] d, int budget) {
        int result = 0;
        Arrays.sort(d);
        
        for (int i = 0; i < d.length; i++) {
            if (budget < d[i]) break;
            
            budget -= d[i];
            result++;
        }
        
        return result;
    }
}