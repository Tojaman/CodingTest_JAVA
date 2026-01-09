import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구현 시간: 12분
public class _13300_방_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 남/녀, 같은 학년(1~6), 한 방 최대 k명
        // 필요한 방 최소 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // <= 1000
        int k = Integer.parseInt(st.nextToken()); // <= 1000
        
        int[][] arr = new int[7][2];
        // O(n): 1000
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 성별: 여(0), 남(1)
            int y = Integer.parseInt(st.nextToken()); // 학년

            arr[y][s]++;
        }

        int result = 0;
        // O(m): 6
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) {
                result += arr[i][j] / k; // 몫만큼 방 추가
                if (arr[i][j] % k > 0) { // 나머지가 있으면
                    result += 1; // 방 1개만 추가
                }
            }
        }
        System.out.println(result);
    }
}
