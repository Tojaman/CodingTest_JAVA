import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 구현 시간: 10분
public class _1919_애너그램_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 일치하는 알파벳 빼고 다 삭제

        char[] one = br.readLine().toCharArray();
        char[] two = br.readLine().toCharArray();

        int[] cnt = new int[26];
        for (int i = 0; i < one.length; i++) {
            cnt[one[i] - 'a']++;
        }

        for (int i = 0; i < two.length; i++) {
            cnt[two[i] - 'a']--;
        }

        int result = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                result += cnt[i];
            } else if (cnt[i] < 0) {
                result -= cnt[i];
            }
        }

        System.out.println(result);
    }
}
