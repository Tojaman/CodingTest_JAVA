package Implementation;

import java.util.*;

/**
- 중복 가능
- 순서 존재(순서 다르면 다른 튜플)
- 튜플 개수 유한

튜플({})을 집합([])안에 넣음
집한 안에서 튜플의 순서는 상관 없음
**/
public class _64064_튜플 {
    public int[] solution(String s) { // s: 튜플 포함된 집합
        /**
        1. split() 함수로 쪼갠다.
        2. 쪼갠 값들의 크기 순으로 오름차순 정렬한다.
        3. {} 안에 값을 꺼내서 result에 집어 넣는다.
        **/
        Set<Integer> set = new HashSet<>();
        
        s = s.substring(2, s.length()-2);
        s = s.replace("},{", "-");
        String[] tuples = s.split("-");
        int[] answer = new int[tuples.length];
        
        // 길이순 오름차순 정렬
        Arrays.sort(tuples, (s1, s2) -> s1.length() - s2.length());
        
        for (int i = 0; i < tuples.length; i++) {
            String[] tupleList = tuples[i].split(",");
            
            for (int j = 0; j < tupleList.length; j++) {
                int num = Integer.parseInt(tupleList[j]);
                if (!set.contains(num)) {
                    answer[i] = num;
                    set.add(num);
                }
            }
        }

        return answer;
    }
}