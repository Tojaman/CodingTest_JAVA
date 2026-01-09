import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* StringTokenizer
 * StringTokenizer 함수 - countTokens() 개수 응답
 */
public class _1152_단어의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.print(st.countTokens());

        // String input = br.readLine().trim();
        // if (input.isEmpty()) {
        //     System.out.print(0);
        //     return;
        // }
        // String[] words = input.split(" ");
        // System.out.print(words.length);
    }
}
