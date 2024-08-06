import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 순간 이동(0초): 2*현재 위치
 * 걷기(1초): 현재 위치 -1 or +1
 */
public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        System.out.println(BFS(N, K));
    }

    public static int BFS(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});

        HashSet<Integer> visited = new HashSet<>();
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cLocation = current[0];
            int cTime = current[1];
            visited.add(cLocation);

            int minus = cLocation -1;
            int plus = cLocation +1;
            int multiply = cLocation *2;

            if (cLocation == target) min = Math.min(min, cTime);

            if (minus >= 0 && !visited.contains(minus)) {
                queue.offer(new int[] {minus, cTime+1});
            }
            if (plus <= 100000 && !visited.contains(plus)) {
                queue.offer(new int[] {plus, cTime+1});
            }
            if (multiply <= 100000 && !visited.contains(multiply)) {
                queue.offer(new int[] {multiply, cTime});
            }
        }
        return min;
    }
}
