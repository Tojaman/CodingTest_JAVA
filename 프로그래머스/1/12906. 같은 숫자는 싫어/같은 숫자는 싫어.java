/** 문제 설명
arr[] = 0 ~ 9 종류의 숫자로 이루어져 있음
연속되는 숫자는 하나만 남기고 나머지 삭제하고 배열 반환(이때 원소 순서는 유지)
*/

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                result.add(arr[i]);
                continue;
            }
            
            if (arr[i] != arr[i-1])
                result.add(arr[i]);
            // else
            //     continue;
                
        }
        return result.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}