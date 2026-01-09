import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 아스키 코드
 * 형변환을 통해 출력한다.
 * 문자 -> 아스키 코드(char -> int)
 * 아스키 코드 -> 문자(int -> char)
*/
public class _11654_아스키_코드 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        System.out.println((int) input.charAt(0));
    }
}
