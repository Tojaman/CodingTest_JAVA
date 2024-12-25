package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 1. 방 탐색
 *     1. 있다
 *         1. 정원이 남았는가?
 *         2. 방에 처음 입장한 플레이어의 레벨을 기준으로 -10 ~ +10 이내인가?
 *     2. 마지막 방까지 탐색했는데 조건에 맞지 않는다면
 *         1. 방 만들기
 */

/** 놓친 부분
 * 방에 있는 플레이어들의 정보는 닉네임이 사전순으로 앞서는 플레이어부터 출력한다.
 */

public class _20006_랭킹전_대기열 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); // 플레이어 수
        int m = Integer.parseInt(st.nextToken()); // 방의 정원

        ArrayList<ArrayList<Player>> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            // 1. 방 탐색
            boolean isAdd = false;
            for (ArrayList<Player> room : rooms) {
                // 1-1. 자리가 남았고 레벨 조건에 맞다면
                if (room.size() < m && Math.abs(room.get(0).level - level) <= 10) {
                    room.add(new Player(level, name));
                    isAdd = true;
                    break;
                }
            }

            // 2. 모든 방을 둘러봤는데 들어갈 방이 없다면 -> 방 만들기
            if (!isAdd) {
                ArrayList<Player> newRoom = new ArrayList<>();
                newRoom.add(new Player(level, name));
                rooms.add(newRoom);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Player> room : rooms) {
            if (room.size() == m) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            // 이름 사전순 정렬
            Collections.sort(room, Comparator.comparing(player -> player.name));

            // 플레이어 출력
            for (int j = 0; j < room.size(); j++) {
                Player player = room.get(j);
                sb.append(player.level).append(" ").append(player.name);
                if (j < room.size() - 1) {
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static class Player {
        int level;
        String name;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }
}
