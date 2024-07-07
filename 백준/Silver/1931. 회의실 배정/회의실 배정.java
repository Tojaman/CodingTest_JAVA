import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] meeting = new int[n][2];
        // 시간 복잡도: O(n)
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meeting[i][0] = start;
            meeting[i][1] = end;
        }

//        Arrays.sort(meeting, (o1, o2) -> {
//            return o1[1]-o2[1];
//        });
        /**
         * o1[1](앞) < o2[1](뒤): (o1, o2) 작은 숫자가 앞으로(순서 유지)
         * o1[1](앞) > o2[1](뒤): (o2, o1) 작은 숫자가 뒤로(순서 변경)
         * o1[1](앞) == o2[1](뒤): (o1, o2) 순서 유지
         */
        Arrays.sort(meeting, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });

        int cnt = 0;
        int now = 0;
        for (int i = 0; i < n; i++) {
            if (now <= meeting[i][0]) {
                now = meeting[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
