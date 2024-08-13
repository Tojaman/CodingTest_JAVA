// /** 문제 설명
// 'A', 'E', 'I', 'O', 'U'으로 5자리 이하 단어가 사전 순으로 정렬되어 있다.
// 이때 word가 몇 번째로 정렬되어 있는지 반환하라.
// */

// /** 문제 풀이
// 1. 모든 단어 조합 만들어 배열에 삽입
// 2. 배열을 사전 순서대로 정렬
// 3. 배열 index == 단어의 순서
// */

// /** 단어 조합 만들기
// - 재귀로 만들자
// - 5글자로 제한하자
// - 중복이 되지 않도록 하자
// */
package ExhaustiveSearch;
import java.util.*;
// class Solution {
//     ArrayList<String> combination = new ArrayList<>();
//     String[] vowels = {"A", "E", "I", "O", "U"};
//     public int solution(String word) {
//         for (String vo : vowels) {
//             dfs(vo, "");
//         }
//         // Arrays.sort(combination);
//         Collections.sort(combination);
//         // for (int i = 0; i < conbination.size(); i++) {
//         //     if (combination.get(i).equals(word))
//         //         return i+1;
//         // }
//         return binarySearch(word) + 1;
//         // return combination.indexOf(word) + 1;
        
//     }
    
//     public void dfs(String vowel, String addVowel) {
//         String newVowel = vowel + addVowel;
//         if (newVowel.length() > 5)
//             return;
//         // if (!combination.contains(newVowel)) // 어차피 중복은 발생하지 않기 때문에 필요 없음.(없애면 시간 많이 줄어듬)
//         combination.add(newVowel);
//         for (String vo : vowels) {
//             dfs(newVowel, vo);
//         }
//     }
    
//     private int findIndex(String word) {
//         for (int i = 0; i < combination.size(); i++) {
//             if (combination.get(i).equals(word)) {
//                 return i;
//             }
//         }
//         return -1; // 찾지 못한 경우
//     }
    
//     // 이진 탐색을 사용하여 단어의 인덱스를 찾는 메서드
//     private int binarySearch(String word) {
//         int low = 0;
//         int high = combination.size() - 1;

//         while (low <= high) {
//             int mid = (low + high) / 2;
//             int cmp = combination.get(mid).compareTo(word);

//             if (cmp == 0) {
//                 return mid;
//             } else if (cmp < 0) {
//                 low = mid + 1;
//             } else {
//                 high = mid - 1;
//             }
//         }

//         return -1; // 단어를 찾지 못한 경우
//     }
// }

class _84512_모음_사전 {
    List<String> list = new ArrayList<>();
    void dfs(String str, int len) {
        if(len > 5) return;
        list.add(str);
        for(int i = 0; i < 5; i++) dfs(str + "AEIOU".charAt(i), len + 1);
    }
    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
}