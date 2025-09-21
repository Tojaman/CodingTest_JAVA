/* 내 풀이
2진수 뒷자리가 0으로 시작하는 짝수는 +1만 하면 됨
반면, 2진수 뒷자리가 1으로 시작하는 홀수는 연속으로 오는 1의 개수에 따라 다름
10진수 = 2^(1 연속 개수-1)
---
짝수(맨 뒤 0): + 1
홀수(맨 뒤 1): + 2^(1연속 개수-1) == +(Math.pow(2, 1연속 개수-1)
*/
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            
            if (num % 2 == 0) { // 짝수
                answer[i] = num+1;
                continue;
            }
            
            // 홀수: 뒷자리 1개수 확인
            String binary = Long.toBinaryString(num);

            int cnt = 0;
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(binary.length() -j-1) == '1')
                    cnt++;
                else
                    break;
                // cnt = binary.lastIndexOf("1") - binary.lastIndexOf("0");
            }

            if (cnt == 1)
                answer[i] = num + 1;
            else
                answer[i] = num + (long) Math.pow(2, cnt-1);
        }
        return answer;
    }
}