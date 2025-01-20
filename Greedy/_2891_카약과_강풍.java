import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 여분의 바로 전 or 바로 다음 팀만 빌려줌 ( 3 <- 4 -> 5 )
 * 다른 팀에게 빌린 카약은 빌려줄 수 없음
 * 만약 카약이 고장나서 여분의 카약을 사용해야 한다면 빌려줄 수 없음
 * 카약 적절히 빌려주고 출발하지 못하는 팀의 최솟값
 */
public class _2891_카약과_강풍 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 팀의 수
        int s = Integer.parseInt(st.nextToken()); // 카약이 손상된 팀의 수
        int r = Integer.parseInt(st.nextToken()); // 여분의 카약이 있는 팀의 수

        team[] teams = new team[n+1];
        for (int i = 0; i < n+1; i++) {
            teams[i] = new team(false, false);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            teams[Integer.parseInt(st.nextToken())].damage = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            teams[Integer.parseInt(st.nextToken())].surplus = true;
        }

        /** 풀이 방법
         * 1. 팀을 순환하면서 카약이 손상됐는지 확인한다.
         * 2. 만약 손상되었다면 전, 후 팀의 카약이 손상되지 않았고 여분의 카약이 있는지 확인한다.
         *  if 전, 후 팀 카약 손상X && 여분 카약O then 해당 팀 여분 카약 가져오기
         *  else cnt++
         */
        int cnt = 0;
        for (int i = 1; i < teams.length; i++) {
            if (teams[i].damage && !teams[i].surplus) {
                if (i == teams.length - 1) {
                    if (teams[i - 1].surplus && !teams[i-1].damage) {
                        teams[i - 1].surplus = false;
                    } else {
                        cnt++;
                    }
                } else {
                    if (teams[i - 1].surplus && !teams[i-1].damage) {
                        teams[i - 1].surplus = false;
                    } else if (teams[i + 1].surplus && !teams[i+1].damage) {
                        teams[i + 1].surplus = false;
                    } else {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
class team {
        public boolean damage;
        public boolean surplus;

        team(boolean damage, boolean surplus) {
            this.damage = damage;
            this.surplus = surplus;
        }
    }