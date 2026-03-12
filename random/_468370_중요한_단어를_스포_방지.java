import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        
        Set<String> general = new HashSet<>();
        Set<String> important = new HashSet<>();
        
        boolean[] isImportant = new boolean[message.length()];
        for (int[] range : spoiler_ranges) {
            
            for (int i = range[0]; i <= range[1]; i++) {
                isImportant[i] = true;
            }
        }
        
        boolean isIn = false;
        int wordStart = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                String word = message.substring(wordStart, i);
                
                if (!isIn) { // 일반
                    general.add(word);
                    if (important.contains(word)) important.remove(word);
                } else { // 중요 & 일반X
                    if (!general.contains(word)) important.add(word);
                }
                
                wordStart = i +1;
                isIn = false;
                continue;
            }
            
            if (isImportant[i]) {
                isIn = true;
            }
        }
        
        // 마지막 단어 처리
        String word = message.substring(wordStart);
        if (!isIn) {
            general.add(word);
            if (important.contains(word)) important.remove(word);
        } else {
            if (!general.contains(word)) important.add(word);
            
        }
        
        return important.size();
    }
}