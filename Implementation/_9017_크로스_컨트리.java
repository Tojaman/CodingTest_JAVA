package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 제발 조건을 좀 잘 보자!!!! 상위 4명만 더하는 조건 추가 안해서 한참 헤멤
 * 팀 점수 = 개인 성적들의 합(★총 6명 중 상위 4명 점수의 합★)
 * 팀 점수가 가장 낮은 점수가 우승
 * 6명 모두 참석 못한 팀은 탈락
 * 동점의 경우 5번째 주자로 비교(작으면 승)
 */
public class _9017_크로스_컨트리 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] people = new int[2][n];
            Map<Integer, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                people[0][j] = Integer.parseInt(st.nextToken());
                // 팀 인원 체크를 위한 Map
                map.put(people[0][j], map.getOrDefault(people[0][j], 0) + 1);
            }

            int score = 1;
            for (int j = 0; j < n; j++) {
                if (map.get(people[0][j]) == 6)
                    people[1][j] = score++;
            }

            // 팀별 점수
            int[] sum = new int[map.size() + 1];
            int[] cnt = new int[map.size() + 1];
            int[] fifth = new int[map.size() + 1];
            int[] fourth = new int[map.size() + 1];
//            Arrays.fill(sum, Integer.MAX_VALUE); // 초기값을 최대값으로 설정
//            Arrays.fill(fifth, Integer.MAX_VALUE); // 초기값을 최대값으로 설정
            for (int j = 0; j < n; j++) {
                // 총 인원 6명 이상인 팀의 합계 점수 계산
                int nowTeam = people[0][j];
                if (map.get(nowTeam) == 6) {
                    // 상위 4명까지만 계산
                    if (fourth[nowTeam] < 4) {
                        sum[nowTeam] += people[1][j];
                        fourth[nowTeam]++;
                        // 5번째 주자 값 저장
                    }
                    cnt[nowTeam]++;
                    if (cnt[nowTeam] == 5)
                        fifth[nowTeam] = people[1][j];
                }
                else {
                    sum[nowTeam] = Integer.MAX_VALUE;
                    fifth[nowTeam] = Integer.MAX_VALUE;
                }
            }

            // 우승 팀 계산
            int min = Integer.MAX_VALUE;
            int win = 0;
            for (int j = 1; j < sum.length; j++) {
                // 동점이 아닐 경우
                if (sum[j] < min) {
                    min = sum[j];
                    win = j;
                }
                // 동점일 경우 ->
                else if (sum[j] == min) {
                    if (fifth[j] < fifth[win])
                        win = j;
                }
            }
            System.out.println(win);
        }
    }
}
