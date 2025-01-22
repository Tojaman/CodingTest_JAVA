import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 각자 예상 등수를 제출하고 예상 등수를 기반으로 동석차 없이 실제 등수 매기기
 * 불만도 = |예상 등수 - 실제 등수|
 * 불만도를 최소로 할 때 불만도 출력
 */
public class _2012_등수_매기기 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] rank = new int[n+1];
        for (int i = 1; i <= n; i++) {
            rank[i] = Integer.parseInt(br.readLine());
        }

        /** 풀이 방법
         * 1. 예상 등수를 오름차순한 뒤 가장 가까운 등수로 배치 -> 불만도가 가장 적음(사람마다 불만도가 최소로 하는 그리디 방법)
         * 2. 예상 등수에 맞게 배치한 후 나머지 사람을 배치 -> 불만도 높음(한 사람 제외 나머지 사람이 일치한다면 1번과 불만도 동일 but, 그 외에는 불만도 높음)
         */
        Arrays.sort(rank);
        long result = 0; // n = 500000이고 예상 등수가 모두 1일 경우 124,999,750,000이 나오므로 int 범위를 넘어섬
        for (int i = 1; i <= n; i++) {
            result += Math.abs(rank[i] - i);
        }
        System.out.println(result);

    }
}