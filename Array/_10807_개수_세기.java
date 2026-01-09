import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구현 시간: 2분
public class _10807_개수_세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (now == target) {
                result++;
            }
        }

        System.out.println(result);
    }
}
