import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _2667_단지번호붙이기 {
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] cx = {1, 0, -1, 0};
    public static int[] cy = {0, 1, 0, -1};
    public static int n;
    public static ArrayList<Integer> al = new ArrayList<>(); // 단지별 집 수
    public static int count = 0; // 집 수수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int set = 0;
        // map을 돌면서 1이면서 방문하지 않은 곳에 dfs
        // set: 단지 수
        // al: 각 단지 별 집 수
        // 한 단지 탐색이 끝나면 count를 0으로 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    set++;
                    al.add(count);
                    count = 0;
                }
            }
        }
        System.out.println(set);

        // 각 단지의 집 수를 오름차순으로 정렬
        Collections.sort(al);
        for (int i = 0; i < al.size(); i++)
            System.out.println(al.get(i));
    }

    public static void dfs(int row, int column) {
        visited[row][column] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = row + cx[i];
            int ny = column + cy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
    
}
