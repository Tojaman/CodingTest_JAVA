import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] problem = new int[a];
        for (int i = 0; i < a; i++) {
            problem[i] = Integer.parseInt(st2.nextToken());
        }

        // 삽입정렬 구현
        int cnt = 0;
        for (int i = 1; i < problem.length; i++) {
            int key = problem[i];
            int j = i - 1;
            while (j >= 0 && key < problem[j]) {
                problem[j+1] = problem[j];
                cnt++;
                if (cnt == k) {
                    System.out.println(problem[j]);
                    return;
                }
                j--;
            }
            if (j + 1 != i) {  // key가 실제로 이동했을 때만 카운트
                problem[j + 1] = key;
                cnt++;
                if (cnt == k) {
                    System.out.println(key);
                    return;
                }
            }
        }
        if (cnt - 1 < k) {
            System.out.println(-1);
        }
    }
}
