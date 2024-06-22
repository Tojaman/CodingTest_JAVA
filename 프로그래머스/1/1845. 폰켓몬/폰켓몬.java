/**
2/N 폰케몬 가져가
번호로 종류 구분
가장 많은 종류의 폰케몬 선택하는 방법 찾아 개수 반환
*/

/** 풀이 방법
중복을 제거한다.
남은 개수가 2/N보다 작다면 개수 그대로 반환.
크다면 2/N 반환
*/
import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int select = nums.length/2; // N/2
        
        HashSet<Integer> hs = new HashSet<>(); // 중복을 제거하기 위해 HashSet 사용
        
        // HashSet에 중복되는 값을 제거한 nums[] 요소 삽입
        for (int num : nums) {
            hs.add(num);
        }
        
        // size == 3 | select == 2
        if (hs.size() <= select) {
            return hs.size();
        }
        return select;
    }
}