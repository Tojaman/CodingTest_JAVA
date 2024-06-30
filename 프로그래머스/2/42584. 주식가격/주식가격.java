/** 문제 설명
초 단위로 주식의 가격이 담긴 배열 prices[]가 주어진다.
가격이 떨어지지 않은 기간이 몇 초인지 return
- (ex. 1, 3, 2, 1)
    1은 끝까지 떨어지지 X -> 3
    3은 2로 떨어지고 1로 2초간 떨어짐 -> 0
    2는 1로 1초간 떨어짐 -> 0
    1은 마지막이므로 떨어지지X -> 0
*/
class Solution {
    public int[] solution(int[] prices) {
        
        
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) // 떨어지지 않았다면
                    answer[i] += 1;
                else {
                    answer[i] += 1;
                    break;
                }
            }
            
        }
        return answer;
    }
}