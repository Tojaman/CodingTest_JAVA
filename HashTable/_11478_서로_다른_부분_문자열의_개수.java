package HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/** 부분 문자열
 * substring(int beginIndex): beginindex(포함)부터 끝까지 부분 문자열
 * substring(int beginIndex, int endIndex): beginindex(포함) ~ endIndex(불포함) 부분 문자열
 * endIndex는 String 객체의 length()까지 가능능
 */

public class _11478_서로_다른_부분_문자열의_개수 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        HashSet<String> hs = new HashSet<>();
        for (int i = 1; i <= s.length(); i++) { // 부분 문자열 크기(1 ~ 5)
            for (int j = 0; j < s.length(); j++) { // 부분 문자열 시작점 (0 ~ 4)
                if (j + i > s.length()) continue;
                hs.add(s.substring(j, j + i));
            }
        }

        System.out.println(hs.size());
    }
}
