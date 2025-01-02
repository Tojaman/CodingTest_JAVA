package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _11279_최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Collections.reverseOrder(): 최대힙으로 변경
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            // x가 자연수라면 최대 힙에 삽입
            // x가 0이라면 최대 힙에서 최대값(우선순위가 높은 값) 출력 / 만약 최대 힙이 비어 있다면 0 출력
            // x가 음수면 무시
            if (x > 0)
                maxHeap.offer(x);
            else if (x == 0) {
                if (maxHeap.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(maxHeap.poll());
            }
        }
    }
}
