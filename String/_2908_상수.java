import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Stringbuilder.reverse()
 * reverse() 메소드 사용하면 문자열 거꾸로 돌릴 수 있음
 */

public class _2908_상수 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String one = new StringBuilder(st.nextToken()).reverse().toString();
        String two = new StringBuilder(st.nextToken()).reverse().toString();
        int oneInt = Integer.parseInt(one);
        int twoInt = Integer.parseInt(two);

        System.out.print(Math.max(oneInt, twoInt));
    }
}
/*
// 뒤에서부터 대소 확인하며 큰 값 체크
public class _2908_상수 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String oneSt = st.nextToken();
        String twoSt = st.nextToken();
        String result = "";
        for (int i = 2; i >= 0; i--) {
            if (oneSt.charAt(i) > twoSt.charAt(i)) {
                result = refactor(oneSt);
                break;
            }
            if (oneSt.charAt(i) < twoSt.charAt(i)) {
                result = refactor(twoSt);
                break;
            }
        }
        System.out.print(result);
    }

    public static String refactor(String result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append(result.charAt(i));
        }
        return sb.toString();
    }
}
*/