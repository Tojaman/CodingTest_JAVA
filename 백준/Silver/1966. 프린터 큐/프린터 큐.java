import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            Queue<int[]> q = new LinkedList<int[]>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int N = 0;
            int M = 0;
            int cnt = 0;
            
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st1.nextToken());
            M = Integer.parseInt(st1.nextToken());

            int[] priority = new int[N];
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st2.nextToken());
                q.add(new int[]{j, num});
                pq.add(num);
            }
            while (!q.isEmpty()) {
                if (q.peek()[1] == pq.peek()) {
                    if (q.poll()[0] == M) {
                        pq.poll();
                        System.out.println(++cnt);
                        break;
                    }
                    pq.poll();
                    cnt++;
                }
                else
                    q.add(q.poll());
            }
        }
    }
}