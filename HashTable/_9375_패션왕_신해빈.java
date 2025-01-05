package HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _9375_패션왕_신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hm = new HashMap<>();
            
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 옷의 이름은 필요 없음
                String type = st.nextToken();
                hm.put(type, hm.getOrDefault(type, 1) + 1); // 이미 있는 종류면 +1 / 없는 종류면 1(안입는 것도 가정해서 기본값은 1)
            }
            
            // HashMap의 모든 값을 가져와서 조합 공식 구하기
            int result = 1;
            for (int cnt : hm.values()) {
                result = result * cnt; // 각 종류의 옷의 개수 곱하기(안입는 경우도 포함되어 있음)
            }
            System.out.println(result - 1); // 아무것도 입지 않는 경우(-1)
        }
    }
}
