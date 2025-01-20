import java.io.*;
import java.util.StringTokenizer;

public class _1543_문서_검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // ------------------------------------- 풀이1 -------------------------------------
        // char[] document = br.readLine().toCharArray();
        // char[] word = br.readLine().toCharArray();

        // /** 풀이 방식
        //  * 1. document를 한글자씩 순환한다.
        //  * 2. 만약 document와 word의 첫 번째 글자가 같으면 나머지 글자도 같은지 확인한다.
        //  *  같다면 -> cnt++ && word 글씨만큼 순환을 건너뛴다.
        //  *  다르다면 -> 다시 순환을 시작한다.
        //  */

        // int cnt = 0;
        // for (int i = 0; i < document.length; i++) {
        //     if (document[i] == word[0] && document.length - i >= word.length) {
        //         boolean same = true;
        //         for (int j = 0; j < word.length; j++) {
        //             if (document[i + j] != word[j]) {
        //                 same = false;
        //             }
        //         }
        //         if (same) {
        //             cnt++;
        //             i += word.length - 1;
        //         }
        //     }
        // }

        // System.out.println(cnt);

        // ------------------------------------- 풀이2 -------------------------------------
        String document = br.readLine();
        String word = br.readLine();

        /** 풀이 방법
         * document를 순환하면서 word와 같은 단어가 있는지 확인한다.
         *  같은 단어라면 -> cnt++ && word 길이만큼 건너뛰어 재순환
         *  같지 않은 단어라면 -> 다시 순환 시작
         */
        int i = 0;
        int cnt = 0;
        while (i <= document.length() - word.length()) {
            if (document.substring(i, i + word.length()).equals(word)) {
                cnt++;
                i += word.length();
                continue;
            }
            i++;
        }

        System.out.println(cnt);
    }
}