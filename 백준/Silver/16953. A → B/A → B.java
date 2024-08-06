import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2를 곱한다.
 * 1을 수의 가장 오른쪽에 추가한다.
 * 위 두 경우를 BFS로 모두 계산하고 목표 값이 나오는 경로의 edge 개수 + 1을 출력한다.
 */
public class Main {
        public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = -1;

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int A = Integer.parseInt(st.nextToken());
//        int B = Integer.parseInt(st.nextToken());

        System.out.println(BFS(A, B));

    }

    public static long BFS(int A, int B) {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[] {A, 1});

        long level = -1;

        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long cvalue = current[0];
            long clevel = current[1];
            long two = cvalue * 2;
//            one = Integer.parseInt(Integer.toString(cvalue) + "1");
            long one = Long.parseLong(Long.toString(cvalue) + "1");
            if (two == B || one == B) {
                level = clevel + 1;
                break;
            }
            if (two < B) {
                queue.offer(new long[] {two, clevel+1});
            }
            if (one < B) {
                queue.offer(new long[] {one, clevel+1});
            }
        }
        return level;
    }
}

