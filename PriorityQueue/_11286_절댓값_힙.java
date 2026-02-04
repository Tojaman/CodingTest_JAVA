package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/* 몰랐던 것
1. Comparator 정렬 인터페이스 << 외우기
*/

/* 풀이 방법 - 못품
절댓값을 기준으로 최소힙에 넣어야하는데,
"절댓값이 같다면 실제 값을 기준으로 넣어라"라는 조건이 있기 때문에 <절댓값, 실제값> 모두 비교해서 넣어야 함
*/

// 2026.02.04
public class _11286_절댓값_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 절댓값으로 비교
        // 같다면 -> 실제 값으로 비교
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int n = Integer.parseInt(br.readLine()); // 1≤N≤100,000

        // O(2nlogn)
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.offer(new int[] {Math.abs(x), x});
                continue;
            }

            int min = 0;
            // O(nlogn)
            if (!pq.isEmpty()) {
                min = pq.poll()[1];
            }
            sb.append(min).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}