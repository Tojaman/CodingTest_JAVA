package Implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 몰랐던 메소드
 * String.valueOf(): String 타입으로 변경해줌
 * substring(int begin, int end): index가 begin ~ end-1까지 부분 문자열
 * substring(int begin): index가 begin부터 끝까지 부분 문자열
 * array.stream().mapToInt(i -> i).toArray(): ArrayList를 int[]바꾸는 방법
   * stream().mapToInt(i -> i): 스트림의 각 요소를 Int 자료형으로 바꾸는 메서드
 */


// GPT 개선 코드
class _17684_3차_압축 {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        int code = 1;
        for (char c = 'A'; c <= 'Z'; c++) dict.put(String.valueOf(c), code++);

        List<Integer> out = new ArrayList<>();
        int n = msg.length();
        int i = 0;

        while (i < n) {
            int j = i + 1;
            int lastCode = -1;

            // i에서 시작해 앞쪽으로만 확장하며 최장 일치 찾기
            while (j <= n) {
                String w = msg.substring(i, j);
                Integer v = dict.get(w);
                if (v == null) break;
                lastCode = v;
                j++;
            }

            out.add(lastCode);                  // 최장 일치 출력
            if (j <= n) {                       // (최장일치 + 다음글자) 사전에 추가
                dict.put(msg.substring(i, j), code++);
            }
            i = j - 1;                          // 소비한 길이만큼 건너뛰기
        }

        int[] answer = new int[out.size()];
        for (int k = 0; k < out.size(); k++) answer[k] = out.get(k);
        return answer;
    }
}


// 걸린 시간: 1시간
/* 내 코드
public class _17684_3차_압축 {
    public int[] solution(String msg) {
        ArrayList<Integer> array = new ArrayList<>();
        
        HashMap<String, Integer> hm = new HashMap<>();
        int hmIndex = 1;
        for (char c = 'A'; c <= 'Z'; c++) { // 외우기
            hm.put(String.valueOf(c), hmIndex++);
        }

        // O(n^2): n == omg(1000) == 1,000,000
        // O9n)
        for (int i = 0; i < msg.length(); i++) {
            boolean insert = false;
            // O(n): 뒤에서부터 탐색하니깐 불필요한 substring() 생성됨. 비효울적임
            // 앞에서부터 탐색하는 걸로 바꾸면 뒤에 불필요한 로직 제거됨
            for (int j = msg.length()-1; j > i; j--) {
                String sub = msg.substring(i, j+1);
                

                if (hm.containsKey(sub)) {
                    array.add(hm.get(sub));
                    if (j < msg.length()-1)
                        hm.put(msg.substring(i, j+2), hmIndex++);
                    i = j;
                    insert = true;
                    break;
                }
            }
            
            
            if (!insert && i < msg.length()) {
                String now = String.valueOf(msg.charAt(i));
                array.add(hm.get(now));
                if (i < msg.length()-1)
                    hm.put(msg.substring(i, i+2), hmIndex++);
            }
        }
        
        
        return array.stream().mapToInt(i -> i).toArray();
    }
}
*/