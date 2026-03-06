// 갈색, 노란색 격자 수 주어질 때 전체 카펫 크기(가로/세로) 구하기
/* 풀이 방법
O(노랑*갈색) 시간 초과

꼭짓점 4개 필수
2가로 + 2세로 - 4 = 2(가로 + 세로 - 2) = brown
가로 + 세로 = brown/2 + 2 = 14

(가로-2) * (세로-2) = yellow
이때 가로 >= 세로이기 때문에 큰 값이 가로
*/
// 30분
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown/2 + 2;
        for (int i = 3; i <= sum/2; i++) {
            int height = i;
            int width = sum-i;
            if (yellow == (height-2) * (width-2)) {
                answer[0] = Math.max(height, width);
                answer[1] = Math.min(height, width);
            }
        }
        
        return answer;
    }
}