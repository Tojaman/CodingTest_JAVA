package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 조건 0.5초
0.5초 제한이 있기 떄문에 O(n^2)은 안된다.
따라서 포인터를 옮길 때마다 sum을 갱신하며 O(n)에 끝내야 한다.
*/

/* 풀이 방법 - 투 포인터
연속된 수들의 합을 구하는 것이라서 정렬X

1. start를 순환하며 부분합(sum)이 s미만인 경우, s이상이 될 때까지 end를 한 칸 옆으로 옮기고 sum을 갱신한다.
2. 부분합(sum)이 s이상인 경우 최솟값(min)을 갱신한다.
3. start를 옮기기 전 부분합(sum)에서 이전 값을 제거한다. 
*/
// 2026.01.30
public class _1806_부분합 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 10 ≤ N < 100,000
        int s = Integer.parseInt(st.nextToken()); // 0 < S ≤ 100,000,000

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int start = 0; start < n; start++) {

            while (end < n && sum < s) sum += a[end++];

            // while문에서 end++했기 때문에 현재 end-start
            if (sum >= s) min = Math.min(min, end-start);
            sum -= a[start];
        }
        if (min == Integer.MAX_VALUE) min = 0;
        System.out.println(min);
    }
}