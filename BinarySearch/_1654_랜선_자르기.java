package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1654_랜선_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 랜선의 길이는 2^31 -1보다 작거나 같은 자연수이기 때문에 int 형식 가능
        int[] lans = new int[k];
        for (int i = 0; i < k; i++)
            lans[i] = Integer.parseInt(br.readLine());

        Arrays.sort(lans);
        /* low, high, mid, cnt 모두 long을 설정해야 됨.
         low, high 모두 int 범위 안이다.
         하지만 mid를 구할 때 low + high를 하는 과정에서 int 범위를 초과할 수 있음
         그리고 cnt는 자른 랜선의 길이는 누적하는 과정에서 int 범위를 초과할 수 있음
         따라서 네 개 모두 long으로 선언해야 함*/
        long low = 1;
        long high = lans[k-1];
        while (low <= high) {
            long mid = (low + high) / 2;

            // 랜선을 자르면 int 범위를 넘어갈 수 있기 때문에 long으로 설정
            long cnt = 0;
            for (int lan : lans) {
                cnt += lan / mid;
            }

            // 잘린 랜선의 개수가 필요한 랜선의 개수보다 많거나 같다면
            if (cnt >= n)
                low = mid + 1;
            else
                high = mid - 1;
        }
        System.out.println(high);
    }
}
