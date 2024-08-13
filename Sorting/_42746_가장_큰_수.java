package Sorting;

import java.util.Arrays;

/** 문제 설명
numbers[]에 0 or 양의 정수가 주어졌을 때 정수를 이어 붙여서 만들 수 있는 가장 큰 수를 반환하라
*/

/** 풀이 방법
정수의 첫 번째 자리의 수를 기준으로 내림차순 정렬한다.
if 첫 번째 자리 수가 같다면 다음 수를 기준으로 내림차순
    이때 한 자리 수라면 첫 번째 자리로 비교
*/

class _42746_가장_큰_수 {
    public String solution(int[] numbers) {
        
        // numbers[] 요소들을 String 형식으로 변환
        String[] stnumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            stnumbers[i] = String.valueOf(numbers[i]);
        }
        
        /** 두 값을 이어 붙여서 비교
        1. 앞(o2+o1) > 뒤(o1+o2) = 음수 -> o1, o2 순서 그대로
        2. 앞(o2+o1) < 뒤(o1+o2) = 양수 -> o1, o2 순서 바꿔서(o2, o1)
        3. 앞(o2+o1) == 뒤(o1+o2) = 0 -> o1, o2 순서 그대로
        즉, compareTo()의 반환값이 음수 or 0이면 순서 그대로(o1, o2), 양수면 순서 바꿔서(o2, o1)
        */
        Arrays.sort(stnumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (stnumbers[0].equals("0")) {
           return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String num : stnumbers) {
            sb.append(num);
        }
        return sb.toString();
    }
}