/**
총 참여 선수 participant[]
완주한 선수 completion[] (한 명 빼고 모두 완주)
완주하지 못한 선수 return
*/

/** 풀이 방법
participant[]에 있는 선수들 중 completion[]에 없는 선수를 찾아 return
*/

/** 가능한 풀이
1. ArrayList의 contains()를 이용한 풀이
2. HashSet을 이용한 풀이
*/
import java.util.HashSet;
import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // HashSet<String> hs = new HashSet<>();
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String com : completion) {
            // hs.add(com);
            hm.put(com, hm.getOrDefault(com, 0) + 1); // key = com | value = com의 개수
        }
        
        for (String part : participant) {
            // if (!hs.contains(part)) {
            //     answer = part;
            //     break;
            // }
            if (!hm.containsKey(part) || hm.get(part) == 0) // part가 존재하지 않고 part의 개수가 0이라면
                return part;
            else // part가 존재하고 part의 value가 1 이상이라면
                hm.put(part, hm.get(part) - 1); // 완주자 -1
        }
        
        return answer;
    }
}