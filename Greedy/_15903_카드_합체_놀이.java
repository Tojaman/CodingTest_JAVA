import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/** 문제 설명
 * 두 카드의 합을 두 카드에 덮어쓴다.(자기 자신 합X)
 * x = x + y
 * y = x + y
 * 위 과정을 m번 반복한 후 카드의 총 합을 구할 때 총 합의 최솟값은 ?
*/

/** 풀이 방법 - O(nlogn)
 * n개의 카드 중 가장 작은 두 값을 더해야 함
 * 1. 최소힙 우선순위큐에 카드 삽입
 * 2. 큐에서 두 카드 꺼내서 더하고 더한 값 다시 큐에 삽입
 *    최소힙이기 때문에 자동으로 가장 작은 두 값을 꺼내서 더하게 됨
 * 3. 1번과 2번 반복
*/
public class _15903_카드_합체_놀이 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 카드의 개수
        int m = Integer.parseInt(st.nextToken()); // 카드 합체 횟수

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        // O(nlogn) - 삽입 최악의 경우 O(logn)
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        // O(mlogn) - 삽입 최악의 경우 O(logn)
        for (int i = 0; i < m; i++) {
            long sum = pq.poll() + pq.poll();
            pq.offer(sum);
            pq.offer(sum);
        }

        long result = 0;
        // O(mlogn) - 삽입 최악의 경우 O(logn)
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        System.out.print(result);
    }
}

/** 풀이 방법 - O(m*nlogn)
 * n개의 카드 중 가장 작은 두 값을 더해야 함
 * 1. 카드를 오름차순으로 정렬
 * 2. 가장 작은 두 값을 더해서 덮어쓰기
 * 3. 1번과 2번 반복
*/
// public class _15903_카드_합체_놀이 {
//     public static void main(String[] arge) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int n = Integer.parseInt(st.nextToken()); // 카드의 개수
//         int m = Integer.parseInt(st.nextToken()); // 카드 합체 횟수

//         st = new StringTokenizer(br.readLine());
//         long[] cards = new long[n];
//         for (int i = 0; i < n; i++) {
//             cards[i] = Integer.parseInt(st.nextToken());
//         }

//         Arrays.sort(cards);

//         for (int i = 0; i < m; i++) {
//             long sum = cards[0] + cards[1];
//             cards[0] = sum;
//             cards[1] = sum;
//             Arrays.sort(cards);
//         }

//         System.out.print(Arrays.stream(cards).sum());
//     }
// }