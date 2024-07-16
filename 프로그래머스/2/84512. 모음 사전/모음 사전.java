/** 문제 설명
'A', 'E', 'I', 'O', 'U'으로 5자리 이하 단어가 사전 순으로 정렬되어 있다.
이때 word가 몇 번째로 정렬되어 있는지 반환하라.
*/

/** 문제 풀이
1. 모든 단어 조합 만들어 배열에 삽입
2. 배열을 사전 순서대로 정렬
3. 배열 index == 단어의 순서
*/

/** 단어 조합 만들기
- 재귀로 만들자
- 5글자로 제한하자
- 중복이 되지 않도록 하자
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
// class Solution {
//     ArrayList<String> combination = new ArrayList<>();
//     String[] vowels = {"A", "E", "I", "O", "U"};
//     public int solution(String word) {
//         for (String vo : vowels) {
//             dfs(vo, "");
//         }
//         // Arrays.sort(combination);
//         Collections.sort(combination);
//         return combination.indexOf(word) + 1;
        
//     }
    
//     public void dfs(String vowel, String addVowel) {
//         String newVowel = vowel + addVowel;
//         if (newVowel.length() > 5)
//             return;
//         if (!combination.contains(newVowel))
//             combination.add(newVowel);
//         for (String vo : vowels) {
//             dfs(newVowel, vo);
//         }
//     }
    
// }

class Solution {
    public int solution(String word) {
        int answer = 0, per = 3905;
        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        return answer;
    }
}