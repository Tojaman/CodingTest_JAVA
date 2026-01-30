package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/* 풀이 방법
1. 배열을 오름차순으로 정렬한다.
2. 두 개의 포인터(start, end)를 시작 지점(0)에 놓는다.
3. start를 이동시키며, 차이가 m 미만인 동안 end를 뒤로 밀어 범위를 넓힌다.
4. 차이가 m 이상이 되는 지점을 찾으면 최솟값을 갱신한다.
*/
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(br.readLine());
        // O(nlogn)
        Arrays.sort(a);

        int end = 0, min = Integer.MAX_VALUE;;

        // O(2n)
        for (int start = 0; start < n; start++) {
            
            while (end < n && a[end] - a[start] < m) {
                end++;
            }
            if (end == n) break;
            min = Math.min(min, a[end] - a[start]);
            
        }
        System.out.println(min);
    }
}

/* 풀이 방법 - 투 포인터
1. 두 개의 포인터(start, end)를 시작 지점(0)에 놓는다.
2. 두 포인터가 가르키는 값의 차이 m 이상이라면 최솟값을 구한다.
3. 차이가 m 이하라면 end++, m 초과라면 start++
*/
// ✅전형적인 투 포인터 구조가 아님
// 2026.01.30
/*
public class _2230_수_고르기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(br.readLine());
        // O(nlogn)
        Arrays.sort(a);

        int start = 0, end = 0, min = Integer.MAX_VALUE;;

        // O(2n)
        while (start < n) {

            int difference = a[end] - a[start];
            if (difference >= m) {
                min = Math.min(min, difference);
            }

            if (difference <= m && end < n-1) {
                end++;
            } else {
                start++;
            }
        }


        System.out.println(min);
    }
}
*/