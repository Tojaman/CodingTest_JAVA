package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1182_부분수열 {
    static HashMap<Integer, Boolean> map = new HashMap<>();
    static int[] arrs;
    static int n, s, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1 ≤ N ≤ 20, |S| ≤ 1,000,000
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        cnt = 0;
        arrs = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, false);
            arrs[i] = num;
        }

        back(0, 0);

        System.out.println(cnt);
    }

    static void back(int sum, int depth) {

        // base condition (종료 조건)
        if (depth == n) {
            return;
        }


        if (sum == s && depth > 0) {
            cnt++;
        }

        for (int arr : arrs) {
            if (!map.get(arr)) {
                map.put(arr, true);
                back(sum + arr, depth+1);
                map.put(arr, false);
            }
        }
        
        
    }
}