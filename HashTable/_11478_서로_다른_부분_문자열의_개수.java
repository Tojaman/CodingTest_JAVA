package HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/** 부분 문자열
 * substring(int beginIndex)
 * substring(int beginIndex, int endIndex)
 */

public class _11478_서로_다른_부분_문자열의_개수 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        HashSet<String> hs = new HashSet<>();

        // int beginIndex = 0;
        // while (beginIndex < s.length()) {
        //     int endIndex = beginIndex + 1;
        //     while (endIndex <= s.length()) {
        //         hs.add(s.substring(beginIndex, endIndex++));
        //     }
        //     beginIndex++;
        // }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                hs.add(s.substring(i, j));
            }
        }
        System.out.println(hs.size());
    }
}
