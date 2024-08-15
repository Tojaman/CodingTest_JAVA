package DFS;

import java.util.Objects;

class Solution {
    static int result = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        // 변환할 수 없는 경우
        int cnt = 0;
        for (String word : words) {
            if (Objects.equals(word, target)) cnt++;
        }
        if (cnt == 0) return 0;

        boolean[] visited = new boolean[words.length];

        dfs(words, visited, begin, target, 0);
        return result;
    }

    public void dfs(String[] words, boolean[] visited, String nowWord, String target, int cost) {
        if (Objects.equals(nowWord, target)) {
            result = Math.min(result, cost);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            int cnt = 0;
            if (!visited[i]) {
                // 현재 단어와 한 개의 알파벳만 다르고 나머지 알파벳이 같은 단어를 찾기
                for (int j = 0; j < nowWord.length(); j++) {
                    if (words[i].charAt(j) == nowWord.charAt(j)) cnt++;
                }
                // 한 개의 알파벳만 다른 단어일 경우 dfs 실행
                if (cnt == nowWord.length() - 1 && !visited[i]) {
                    visited[i] = true;
                    dfs(words, visited, words[i], target, cost + 1);
                    visited[i] = false;
                }
            }
        }
    }
}

// 테스트용 코드
/*
class Solution {
    static int result = Integer.MAX_VALUE;
    public static int solution(String begin, String target, String[] words) {
        // 변환할 수 없는 경우
        int cnt = 0;
        for (String word : words) {
            if (Objects.equals(word, target)) cnt++;
        }
        if (cnt == 0) return 0;

        boolean[] visited = new boolean[words.length];

        dfs(words, visited, begin, target, 0);
        return result;

    }

    public static void dfs(String[] words, boolean[] visited, String nowWord, String target, int cost) {
        if (Objects.equals(nowWord, target)) {
            result = Math.min(result, cost);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            int cnt = 0;
            if (!visited[i]) {
                for (int j = 0; j < nowWord.length(); j++) {
                    if (words[i].charAt(j) == nowWord.charAt(j)) cnt++;
                }
                if (cnt == nowWord.length() - 1 && !visited[i]) {
                    visited[i] = true;
                    dfs(words, visited, words[i], target, cost + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int result = solution("hit", "cog", words);
        System.out.println(result);
    }
}*/
