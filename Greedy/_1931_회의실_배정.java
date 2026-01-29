package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1931_회의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 100,000
        
        int[][] time = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // <= 2^31-1
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // (a, b)는 각 행, compare() 내부 값은 각 행의 컬럼값
        // compare(앞, 뒤) 앞이 작으면 앞으로(오름차순) (밑에는 내림차순)
        Arrays.sort(time, (a, b) -> Integer.compare(b[1], a[1]));

        int cnt = 1;
        int i = 0;
        while (true) {
            if (time[i][0] < time[n-1][1]) break;
            int start = 0;
            int next = 0;
            for (int j = i+1; j < n; j++) {
                // 시작점 >= 다음 끝 점 && 
                if (time[i][0] >= time[j][1] && time[j][0] > start) {
                    start = time[j][0];
                    next = j;
                }
            }
            i = next;
            cnt++;
        }

        System.out.println(cnt);
    }
}
