package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _18126_너구리_구구 {
    static List<Pair>[] rooms;
    static boolean[] visited;
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        rooms = new LinkedList[n+1];
        visited = new boolean[n+1];
        
        for (int i = 1; i <= n; i++)
            rooms[i] = new LinkedList<>();

        StringTokenizer st;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int room1 = Integer.parseInt(st.nextToken()); // 1 <= room1
            int room2 = Integer.parseInt(st.nextToken()); // room2 <= n
            int distance = Integer.parseInt(st.nextToken()); // 1 <= distance <= 1,000,000,000
            rooms[room1].add(new Pair(room2, distance));
            rooms[room2].add(new Pair(room1, distance));
        }

        dfs(1, 0);
        System.out.print(result);
    }

    public static void dfs(int nowRoom, long distance) {
        visited[nowRoom] = true;
        result = Math.max(result, distance);

        for (int i = 0; i < rooms[nowRoom].size(); i++) {
            Pair nextRoom = rooms[nowRoom].get(i);
            if (!visited[nextRoom.room]) {
                dfs(nextRoom.room, distance + nextRoom.distance);
            }
        }

    }
}

class Pair{
    int room;
    int distance;

    Pair(int room, int distance) {
        this.room = room;
        this.distance = distance;
    }
}
