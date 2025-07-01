package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/** 문제 설명명
 * 후보 n명, 마을 주민 m명
 * 기호 1번이 나머지 후보들보다 크도록 만들기(동점X)
 */

/** 풀이 방법
 *   1번을 제외한 나머지 후보의 득표수를 우선순위 큐에 넣음
    득표수가 가장 큰 후보의 1표를 매수수
    "1번 후보의 득표수 > 나머지 후보 중 득표수가 가장 높은 후보"까지 반복
 */
public class _1417_국회의원_선거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.print(result);
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int num1 = Integer.parseInt(br.readLine()); // 1번 후보
        for (int i = 1; i < n; i++) { // 2번 ~ n번 후보
            int candidate = Integer.parseInt(br.readLine());
            pq.offer(candidate);
        }

        
        while (true) {
            int topCandidate = pq.poll();
            if (num1 > topCandidate) break; // 탈출 조건

            num1++;
            result++;
            pq.offer(--topCandidate);
        }

        System.out.print(result);
    }
}
