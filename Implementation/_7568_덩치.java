package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/** 반례
 * 아래 경우 5번이 4번보다 작고 1, 2번과는 우열을 가릴 수 없다.
 * 따라서 1, 2번과 등수가 같고 3번보다 등수가 커야 한다.
 * 하지만 1, 2번은 4번과 우열을 가릴 수 없다.
 * 이 경우 3 3 1 2 3과 2 2 1 2 3중 뭐가 맞는지 모르겠다.
 * 내 코드는 2 2 1 2 3이 나온다.
 * 5
 * 55 185
 * 58 183
 * 88 186
 * 60 175
 * 59 155
 */

/** 해결
 * 문제에 "만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다."라고 적혀 있다.
 * 즉, 그냥 전부 다 비교 한 다음 자기보다 더 큰 덩치만 비교하면 되는 거다..............
 * 자꾸 문제를 제대로 안읽어서 이상한 곳에서 헷갈리지좀 말자 좀!!!
 */
public class _7568_덩치 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayList<int[]> mass = new ArrayList<int []>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            mass.add(new int[] {weight, height});
        }

        int[] rank = new int[n];
        for (int i = 0; i < n; i++)
            rank[i] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                // 작은 경우
                if (mass.get(i)[0] < mass.get(j)[0] && mass.get(i)[1] < mass.get(j)[1])
                    rank[i]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(rank[i]);
            if (i < rank.length - 1)
                sb.append(" "); // 요소 사이에 공백 추가
        }
        System.out.println(sb.toString());
    }
}
