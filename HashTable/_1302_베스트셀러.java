package HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 가장 많이 팔린 책 출력
 * HashMap에 키로 책 이름을 넣고 value로 판매량을 넣는다.
 * HashMap에 있는 모든 데이터의 Key와 Value를 동시에 사용해야 할 때 주로 사용
 */
public class _1302_베스트셀러 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            hm.put(book, hm.getOrDefault(book, 0) + 1);
            max = Math.max(max, hm.get(book));
        }

        List<String> result = new ArrayList<>(); // 가장 많이 팔린 책이 여러권일 경우 사전 순 정렬을 위함

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        System.out.println(result.get(0));
    }
}
    