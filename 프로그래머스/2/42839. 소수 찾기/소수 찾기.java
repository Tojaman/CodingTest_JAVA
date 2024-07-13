import java.util.*;
/** 문제 설명
numbers에 주어진 값을 이용하여 만들 수 있는 소수는 몇개인가?
ex. "17": 1, 7, 17 총 3개
*/

/** 풀이 방법
1. 재귀로 숫자를 조합한 후 HashSet에 삽입한다.
2. 숫자를 조합하여 소수를 카운트한다.
*/
class Solution {
    HashSet<Integer> hs = new HashSet<>();
    public int solution(String numbers) {
        
        // 1. 재귀로 숫자를 조합한 후 HashSet에 삽입한다.
        combination("", numbers);
        
        // 2. hs에서 소수의 개수를 구한다.(에라테스테네의 체)
        int cnt = 0;
        for (int num : hs) {
            if (prime(num)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public void combination(String target, String arr) {
        if (!target.equals("")) 
            hs.add(Integer.valueOf(target)); // Integer.valueOf()를 통해 맨 앞에 0이 온다면 무시(011, 11 -> 모두 11로 변환)
        
        /** 아래 코드는 중복된 숫자가 있을 경우 오류 발생
        ex. arr가 "110"이고 arrValue가 '1'일 때 앞에 1과 뒤 1중 뭘 ""로 대체할지 알 수 없음*/
        // for (char arrValue : arr.toCharArray()) {
        //     combination(target + arrValue, arr.replace(String.valueOf(arrValue), ""));
        // }
        
        for (int i = 0; i < arr.length(); i++) 
            combination(target + arr.charAt(i), arr.substring(0, i) + arr.substring(i + 1));
    }
                        
    public boolean prime(int target) {
        if (target == 0 || target == 1) {
            return false;
        }
        for(int i = 2 ; i <= Math.sqrt(target); i++){
            if(target % i == 0 ) { // 소수가 아님
                return false;
            }
        }
        return true;
    }
}
