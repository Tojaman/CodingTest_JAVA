package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14467_소가_길을_건너간_이유1 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 관찰 횟수
        int n = Integer.parseInt(br.readLine());

        // 관찰 결과 - 소의 번호, 소의 위치(0: 왼쪽 / 1: 오른쪽)
        StringTokenizer st;
        int[] cow = new int[11];
        int cnt = 0;
        for (int i = 0; i < 11; i++) {
            cow[i] = -1;
        }
//        Arrays.fill(cow, -1);


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            // 처음인 경우 / 위치를 옮긴 경우 / 위치가 그대로 인 경우
            if (cow[num] == -1) {
                cow[num] = location;
            } else if (cow[num] != location) {
                cow[num] = location;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
