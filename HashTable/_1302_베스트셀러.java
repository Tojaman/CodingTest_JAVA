package HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 아이디어는 떠올렸으나 HashMap 메서드 미숙지로 풀지 못함.
 * 나중에 다시 풀어보기
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
            max = Math.max(max, hm.get(book)); // 최대 값 구하기
        }

        // 가장 많이 팔린 책이 여러가지 일 경우를 대비해 출력
        List<String> books = new ArrayList<>();
        List<Map.Entry<String, Integer>> entrys = new ArrayList<>(hm.entrySet());
        for (Map.Entry<String, Integer> entry : entrys) {
            if (entry.getValue() == max)
            books.add(entry.getKey());
        }
        Collections.sort(books);
        System.out.println(books.get(0));
    }
}
