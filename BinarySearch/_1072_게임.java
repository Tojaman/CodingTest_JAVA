import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/** 풀이 방법1(수학 공식) - 25.07.03
 * 승률: z = (y / x) * 100
 * 구해야하는 값: z가 변하기 위해서 해야하는 게임 수
 * 공식: "z+1 >= (y+n) * 100 / (x+n)"인 n을 구하기
 * n <= ((z+1)x - 100y) / (99-z)
 */

/** 풀이 방법2(이진 탐색) - 25.07.03
 * 수학적 방법은 자료형 문제가 있지만 이는 없음.
 * 좀 더 직관적?
 * 다만 이진 탐색의 right(10억)을 뭘 해야 할지 몰랐음
 */
public class _1072_게임 {
    static long min = 1000000001;

    public static void binarySearch(long x, long y, long z, long left, long right) {

        if (left > right) {
            return;
        }

        long mid = (left + right) / 2; // 추가 승리 횟수
        long newZ = (y+mid) * 100 / (x+mid);

        if (newZ > z) {
            min = mid;
            binarySearch(x, y, z, left, mid-1);
        } else if (newZ == z) { // else도 가능
            binarySearch(x, y, z, mid+1, right);
        }
    }

    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long z = y * 100 / x;

        if (z >= 99) {
            System.out.print(-1);
            return;
        }

        binarySearch(x, y, z, 0, 1000000000);
        System.out.print(min);


        
        /** 시도3 -> 맞은 이유
         * z가 정수여야만 하기 때문에 x, y, z를 정수로 선언
         * 단, n값은 소수점까지 계산한 뒤 올림을 해야 하므로 소수점까지 계산
         */
        // long x = Long.parseLong(st.nextToken());
        // long y = Long.parseLong(st.nextToken());
        // long z = y * 100 / x; // int형으로 받기 위해 순서 변경(만약 나누기부터 하면 z는 0이 됨)

        // if (z >= 99) {
        //     System.out.print(-1);
        //     return;
        // }

        // double n = (double) ((z+1)*x - 100*y) / (99-z);
        // System.out.print((int)Math.ceil(n));

        /** 시도2 -> 틀린 이유
        이 방식은 z가 정수가 아닌 소수점이 존재하는 값임
        따라서 계산 결과가 잘못나올 수 있음
        n이 정확히 정수가 나오면 n은 정답보다 1 큰 값이 나옴
        예를 들어 n = 6.0이라면 올림을 적용한 7이 출력됨
         */
        // double x = Double.parseDouble(st.nextToken());
        // double y = Double.parseDouble(st.nextToken());
        // double z = y * 100 / x; // int형으로 받기 위해 순서 변경(만약 나누기부터 하면 z는 0이 됨)

        // if (z >= 99) {
        //     System.out.print(-1);
        //     return;
        // }

        // double n = ((z+1)*x - 100*y) / (99-z);
        // System.out.print((int)Math.ceil(n));

        /** 시도1 -> 틀린 이유(시간 초과)
         * 시간 복잡도: O(n)
         * 최악의 경우 10억번 반복해야 함
         * 현재 승률이 매우 높고(98%), 총 게임 횟수(x)가 매우 높은 경우 이겨야 하는 게임 횟수(n)은 기하급수적으로 올라감
         * 예를 들어 총 게임 횟수(x)가 최댓값인 10억이고 이긴 게임 횟수(y)가 9.8억이어서 승률(z)가 98%인 경우 추가로 이겨야 하는 게임 횟수(n)은 약 10억번이다.
         */
        // int x = Integer.parseInt(st.nextToken());
        // long y = Integer.parseInt(st.nextToken());
        // long z = y * 100 / x; // int형으로 받기 위해 순서 변경(만약 나누기부터 하면 z는 0이 됨)


        // long afterZ = z;

        // if (x == y) {
        //     System.out.print(-1);
        //     return;
        // }

        // int result = 0;
        // while (afterZ == z) {
        //     result++;
        //     afterZ = ++y * 100 / ++x;
        // }
        // System.out.print(result);
    }
}
