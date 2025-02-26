import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/** 풀이 방법
 * 가장 짧은 체인으로 가장 긴 체인부터 연결해나가는 그리디 방법으로 해결
 */
public class _2785_체인 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> chains = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            chains.add(num);
        }
        Collections.sort(chains);

        int result = 0;
        while (true) {
            // 모든 체인이 연결됐다면 탈출
            if (chains.size() <= 1) break;

            // 가장 작은 체인의 고리를 떼어 내어 가장 큰 체인 두 개를 엮어서 Array에 삽입
            chains.add((chains.remove(chains.size()-2) + chains.remove(chains.size()-1) + 1) + 1);
            chains.set(0, chains.get(0)-1);
            
            // 가장 작은 체인을 모두 사용했다면 Array에서 제거
            if (chains.get(0) == 0) {
                chains.remove(0);
            }
            result++;
        }

        if (chains.size() == 2) result++;

        System.out.println(result);
      }
}