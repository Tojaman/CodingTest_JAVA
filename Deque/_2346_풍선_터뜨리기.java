package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * n개의 풍선이 덱에 존재
 * 각 풍선에는 (-n <= 값 <= +n) 값 할당
 * 반복 (풍선 제거하고 풍선값 만큼 이동(1번째 풍선부터 시작): -면 왼쪽, +면 오른쪽
 * 원형으로 가정하기 때문에 (1번째에서 왼쪽으로 가면 마지막 풍선), (n번째에서 오른쪽으로 가면 첫번쨰 풍선)
 */

/** 시도1 X
 * 1. 첫 번째 풍선을 remove하고 첫 번째 풍선의 값을 확인한다.
 * 2. 풍선의 값이 +n이면 앞에서부터 +(n-1)까지 각각 poll하고 뒤로 offer / -n이면 뒤에서부터 -(n-1)까지 poll하고 앞으로 offer / n번째 값은 remove하고 값 확인한다.
 * 3. 2번 반복
 */

/** 시도2 X
 * 1. 맨 앞의 충선을 remove하고 값을 확인한다.
 * 2. 풍선의 값이 +n이면 앞에서부터 +(n-1)까지 각각 poll하고 뒤로 offer / -n이면 뒤에서부터 -n까지 poll하고 앞으로 offer
 * 3. 만약 덱이 비었다면 탈출
 * 위 과정 반복
 */

/** 시도3 - 시도2와 같지만 풍선과 종이를 따로 두지 않고 객체로 만들어서 덱에 저장
 * 1. 맨 앞의 충선을 remove하고 값을 확인한다.
 * 2. 풍선의 값이 +n이면 앞에서부터 +(n-1)까지 각각 poll하고 뒤로 offer / -n이면 뒤에서부터 -n까지 poll하고 앞으로 offer
 * 3. 만약 덱이 비었다면 탈출
 * 위 과정 반복
 */
public class _2346_풍선_터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        // 초기값 삽입: 1 2 3 4 ... n
        Deque<Balloon> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            // 풍선 번호, 종이 값
            dq.offer(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            Balloon num = dq.removeFirst();
            sb.append(num.idx).append(" ");

            if (dq.isEmpty()) {
                break; // 덱이 비어 있으면 종료
            }

            // 종이 값 == 양수
            if (num.val > 0) {
                for (int i = 0; i < num.val-1; i++) {
                    dq.offerLast(dq.pollFirst());
                }
            }
            // 종이 값 == 음수
            else {
                for (int i = 0; i > num.val; i--) {
                    dq.offerFirst(dq.pollLast());
                }
            }
        }
        System.out.println(sb.toString().trim()); // trim(): String의 앞 뒤 공백 제거
    }
}
class Balloon {
    int idx, val;

    public Balloon(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}
