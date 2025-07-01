package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/** 풀이 방법 - 25.07.01
 * 매우 간단하게 풀 수 있다.
 * 가장 작은 값을 출력 -> 최소 힙(우선순위 큐)
 * 가장 큰 값을 출력 -> 최대 힙(우선순위 큐 reverse)
 * 따라서 이번 문제는 최소힙에 값을 넣고 조건에 맞게 출력하면 되는 간단한 문제이다.
 */
public class _1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());
                }
                else {
                    System.out.println(0);
                }
                continue;
            }
            pq.offer(input);
        }
    }
}

/** 이전 풀이
public class _1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            // x가 양수면 최소 힙에 삽입
            // x가 0이면 최소 힙에서 최솟값(우선순위가 높은 값) 출력 / 만약 최소 힙이 비어 있다면 0 출력
            // x가 음수면 무시
            if (x > 0) {
                minHeap.offer(x);
            }else if(x == 0) {
                if (minHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(minHeap.poll());
                }
            }
        }
    }
}
*/