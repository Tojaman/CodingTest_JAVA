import java.util.HashSet;
import java.lang.Math;
import java.util.Iterator;

class Solution {
    
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        
        // 숫자 조합 구하기(DFS 재귀 이용)
        dfs("", numbers);
            
        // 소수인지 확인
        int cnt = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (prime(iterator.next())) {
                cnt++;
            }
        }
        return cnt;
    }
    
    /**
    1. dfs()를 호출하면 for문 동작
    2. for에서 숫자를 조합하여 dfs()의 첫번째 인수로 보내고 조합에 사용되지 않는 숫자를 두 번째 인수로 준다.
    3. 2번이 반복적으로 실행되면서 모든 숫자 조합 완성
    */
    public void dfs(String start, String arr) {
        // 조합이 완료된 start를 재귀로 받아서 set에 삽입(첫 빈 start는 예외)
        if (!start.equals("")) {
            set.add(Integer.valueOf(start));
        }
        
        // start와 남은 숫자를 조합
        // dfs(조합된 숫자, 조합에 사용한 숫자를 제외하고 남은 숫자들) 재귀
        for (int i = 0; i < arr.length(); i++) {
            dfs(start + arr.charAt(i), arr.substring(0, i) + arr.substring(i + 1));
        }
    }
    
    public boolean prime(int num) {
        if (num <= 1) {  // 0이나 1일 경우 false 반환
            return false;
        }
        if (num == 2) {  // 2는 소수
            return true;
        }
        if (num % 2 == 0) {  // 짝수는 소수가 아님
            return false;
        }
        int sq = (int) Math.sqrt(num);
        for (int i = 2; i <= sq; i++) {
            if (num % i == 0) {
                return false;  // 나누어 떨어지면 소수가 아님
            }
        }
        return true;  // 나누어 떨어지지 않으면 소수
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("17")); // 테스트 예제: "17" -> 소수: 7, 17 -> 출력: 2
        System.out.println(sol.solution("011")); // 테스트 예제: "011" -> 소수: 11 -> 출력: 2
    }
}
