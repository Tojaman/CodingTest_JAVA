package ExhaustiveSearch;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 문제 설명
 * 암호는 서로 다른 L개의 소문자로 이루어져 있고 최소 한 개의 모음, 두 개의 자음으로 이루어져 있다.
 * 암호는 오름차순(사전 순)으로 정렬되어 있다.
 * 문자의 종류는 C개이다.
 * 즉, 암호는 L개의 서로 다른 소문자이고 이때 사용할 수 있는 문자의 종류는 C개이다.
 */

public class _1759_암호_만들기 {
    static ArrayList<String> result = new ArrayList<>();

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[] words = br.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(words);
        
        for (int i = 0; i < words.length; i++) {
            backtracking("", words, i, L);
        }

        for (String rs : result) {
            bw.write(rs);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static void backtracking(String nowWord, char[] word, int idx, int L) {
        String newWord = nowWord + word[idx];
        
        if (newWord.length() == L && vowelCheck(newWord)) {
            result.add(newWord);
            return;
        }

        for (int i = idx + 1; i < word.length; i++) {
            backtracking(newWord, word, i, L);
        }
    }

    public static boolean vowelCheck(String newWord) {
        String[] vowels = {"a", "e", "i", "o", "u"};
        int vowelCnt = 0;
        for (String vowel : vowels) {
            if (newWord.contains(vowel))
                vowelCnt++;
        }
        if (vowelCnt >= 1 && newWord.length() - vowelCnt >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
