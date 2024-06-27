import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.HashMap;

/** 문제 설명
 * 입력값이 0이 아니라면 배열에 삽입
 * 입력값이 0이라면 절댓값이 가장 작은 값 출력하고 제거
 * 만약 절댓값이 0이 아닌 값이 여러개라면 그중 가장 작은 값을 출력하고 제거
 */
public class Main{ // Main으로 바꿔서 제출해야 함
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> absolute_pq = new PriorityQueue<>();
        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
	            absolute_pq.add(Math.abs(num));
                if (!hm.containsKey(Math.abs(num))) {
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.offer(num);
                    hm.put(Math.abs(num), pq);
                    // hm.put(Math.abs(num), new PriorityQueue(num));
                }
                else
                    hm.get(Math.abs(num)).offer(num);
            }
            else { // 0
                if (!absolute_pq.isEmpty()) {
                    int min = absolute_pq.poll();
                    System.out.println(hm.get(min).poll());
                }
                else   
                    System.out.println(0);
                
            }
        }
    }
}