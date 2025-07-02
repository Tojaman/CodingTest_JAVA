import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/** 풀이 방법 - 25.07.02(따른 자료구조로도 풀어보기)
 * 이진 탐색을 이용하여 풀었다.
 * A의 원소들을 B의 원소들과 비교하며 동일한 원소가 존재한다면 X 존재하지 않는다면 O
 * 이때 A의 차집합 원소들의 개수를 출력하고 원소들을 오름차순으로 출력해야 하기 때문에 우선순위 큐를 사용했다.
 * (풀이가 너무 더럽다;;;)
 */
public class _1822_차집합 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aCnt = Integer.parseInt(st.nextToken());
        int bCnt = Integer.parseInt(st.nextToken());
    
        int[] a = new int[aCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aCnt; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] b = new int[bCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bCnt; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색을 위한 정렬
        Arrays.sort(b);

        for (int i = 0; i < aCnt; i++) {
            int result = BinarySearch(0, bCnt-1, a[i], b);
            if (result != 0) {
                pq.offer(result);
            }
        }

        if (pq.isEmpty()) {
            System.out.print(0);
        } else {
            System.out.println(pq.size());
            StringBuilder sb = new StringBuilder();
            int n = pq.size();
            for (int i = 0; i < n; i++) {
                sb.append(pq.poll() + " ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    public static int BinarySearch(int left, int right, int target, int[] b) {

        int mid = (left + right) / 2;

        if (left > right) 
            return target;

        if (target == b[mid]) {
            return 0;
        } else if (target > b[mid]) {
            return BinarySearch(mid+1, right, target, b);
        } else {
            return BinarySearch(left, mid-1, target, b);
        }
    }
}
