import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 구현 시간: 5분
/* 몰랐던 것
 * String.valueOf(int): int -> String
 * 

*/
public class _2577_숫자의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int abc = a*b*c;

        char[] ch = String.valueOf(abc).toCharArray();

        int[] nums = new int[10];
        for (int i = 0; i < ch.length; i++) {
            nums[ch[i]-'0'] += 1; // << ch[i]는 int가 아니라 char
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
