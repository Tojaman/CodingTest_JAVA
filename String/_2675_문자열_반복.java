import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* StringBuilder, StringTokenizer, split()
 * 
 */
public class _2675_문자열_반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int t = Integer.parseInt(br.readLine()); // (1 ≤ T ≤ 1,000)
        for (int i = 0; i < t; i++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();  // (1 ≤ s < 20)

            String[] ch = s.split("");
            for (int j = 0; j < ch.length; j++) {
                for (int k = 0; k < r; k++) {
                    sb.append(ch[j]);
                }
                
            }
            System.out.println(sb.toString());
        }
    }
}
