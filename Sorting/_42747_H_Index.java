package Sorting;

import java.util.Arrays;
/**
- n = citations.length()
1. citations 배열의 특정 값 m보다 크거나 같은 값이 m개 이상이라면 후보
2. 후보들을 모은 후 최대 값을 return
**/
class _42747_H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); // 0 1 3 5 6
        int size = citations.length; // 5
        for (int i = 0; i < size; i++) {
            int h = size - i;
			
			if(citations[i] >= h) {
				answer = h;
				break;
			}
        }
        return answer;

        
        
        
    }
}