package HashTable; /** 문제 설명
의상 종류 4가지가 주어진다.
최소 한 개 이상의 의상을 입어야 하고 매일 다른 의상을 입어야 할 때 입을 수 있는 의상 조합의 수는?
모든 의상의 종류가 겹칠 때만 같은 의상으로 계산한다. 
*/

import java.util.HashMap;
import java.util.Map;

class _42578_의상 {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesCountMap = new HashMap<>();
        
        // clothes 배열의 행을 돌면서 옷 종류의 개수를 세고 Map 형태로 개수 저장 
        for (String[] pair : clothes) {
            String category = pair[1];
            // clothesCountMap에 카테고리(옷종류)가 있다면 +1 없다면 1
            // getOrDefault(key, default값) : key가 없다면 default 반환 / key가 있다면 value 반환
            // 만약 카테고리가 없다면 0을 반환한 후 +1을 하므로 새로운 카테고리에 1이 들어감
            clothesCountMap.put(category, clothesCountMap.getOrDefault(category, 0) + 1);
        }
    
        // 조합 개념을 까먹어서 헷갈림
        // 옷 종류별 개수를 모두 곱하여 조합 계산
        int answer = 1;
        for (int cnt : clothesCountMap.values()) {
            // 옷을 입지 않는 경우(1)
            answer *= (cnt + 1);
        }
        
        // 아무것도 입지 않는 경우 -1
        return answer - 1;
    }
}