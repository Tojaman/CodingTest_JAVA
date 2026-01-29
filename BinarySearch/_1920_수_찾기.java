import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 조건
제한 시간: 1초
M 배열의 값 하나하나 N 배열이랑 비교해서 찾아내야 하기 때문에, O(nm)이 나옴
그러나 100,000이기 때문에 시간 초과 발생
따라서 이분 탐색으로 O(nlogm)으로 풀어야 함
*/

/* 풀이 방법 - 이분 탐색(O(logn))
b 배열의 값 하나하나 a 배열에 있는지 탐색
이때 순차 탐색의 경우 O(nm)으로 시간 초과가 발생하므로, 이분 탐색을 진행해야하고 이분 탐색을 위해 a배열을 정렬한 뒤 탐색을 진행한다.
*/

// 2026.01.29
// 구현 시간: 5분
public class _1920_수_찾기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 100,000
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine()); // 1 ≤ m ≤ 100,000
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(st.nextToken());
            int index = Arrays.binarySearch(a, now);
            if (index > -1) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
