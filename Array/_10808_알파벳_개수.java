import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 구현 시간: 5분
public class _10808_알파벳_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine(); // <= 100, 소문자

        int[] result = new int[26];
        // O(n) 8
        for (int i = 0; i < input.length(); i++) {
            int alpaIndex = input.charAt(i) - 'a'; // 아스키코드 ('a' == 97, 이후부터 +1)
            result[alpaIndex]++;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        StringBuilder sb = new StringBuilder();
        // O(n) 26
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i] + " ");
            // sb.append(result[i]).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}
