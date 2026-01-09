import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5622_다이얼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] words = br.readLine().toCharArray(); // 2 <= word <= 15

        int result = 0;
        for (int i = 0; i < words.length; i++) {

            int sub = words[i] - 'A';
            result += num(sub);
        }
        System.out.print(result);
    }

    public static int num(int sub) {
        if (0 <= sub && sub <= 2) {
            return 3;
        }
        else if (3 <= sub && sub <= 5) {
            return 4;
        }
        else if (6 <= sub && sub <= 8) {
            return 5;
        }
        else if (9 <= sub && sub <= 11) {
            return 6;
        }
        else if (12 <= sub && sub <= 14) {
            return 7;
        }
        else if (15 <= sub && sub <= 18) {
            return 8;
        }
        else if (19 <= sub && sub <= 21) {
            return 9;
        }
        else if (22 <= sub && sub <= 25) {
            return 10;
        }
        return 0;
    }
}
