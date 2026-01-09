import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 알파벳 (아스키코드)
 * 문자(char)도 내부적으로는 아스키코드(숫자)이기 때문에 반복문으로 출력 가능하다.
 * 예를 들어 'A'는 아스키코드로 65이고, 이후 알파벳은 1씩 증가한다.
 * 'a'는 아스키코드로 90이고 z는 122이다. 
 */

public class _10809_알파벳_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < input.length(); i++) {
            int point = input.charAt(i) - 'a';
            if (arr[point] == -1) {
                arr[point] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + " ");
        }

        System.out.print(sb.toString().trim());


        // int[] arr = new int['z' - 'a' + 1];
        // int index = 0;
        // for (char c = 'a'; c <= 'z'; c++) {
        //     for (int i = 0; i < input.length(); i++) {
        //         if (input.charAt(i) == c) {
        //             arr[index] = i;
        //             break;
        //         }
        //         arr[index] = -1;
        //     }
        //     index++;
        // }
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
    }
}
