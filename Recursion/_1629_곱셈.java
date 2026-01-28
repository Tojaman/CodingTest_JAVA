import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// a^b % c
/* 사고 흐름
a, b, c가 모두 21억이므로, a를 b번 반복하며 곱하고 c로 나눈 나머지를 구하면 총 21억 번이 넘는 연산이 수행되어 시간 제한을 넘긴다.
따라서 O(n)으로는 문제를 풀 수 없다.
그럼 O(logn)으로 해결해야겠찌?? 반으로 쪼개면서 해결해야 한다는 생각을 떠올릴 수 있다.
또한, a, b가 모두 21억이라면 int는 물론 long에도 담을 수 없기 때문에 다른 방법을 떠올려야 한다.
*/

/* 풀이 방법
- 오버플로우 해결 방법
    - (a*a*a*a*a*...*a) % c == (a%c)*(a%c)*(a%c)*(a%c)*(a%c)*(a%c)*(a%c)*...*(a%c)
    - 즉, 나머지를 저장해야 오버플로우를 해결할 수 있다.
- 시간 복잡도 - O(logn)
    - a^2 = a^1 * a^1
    - a^2n = a^n * a^n
    - a^(b/2) * a^(b/2) = a^b
    - 결국 재귀를 이용해 절반으로 쪼갠 값을 곱하는 방식으로 구하면 O(logn)으로 해결할 수 있다.
*/
public class _1629_곱셈 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(recur(a, b, c));
    }

    /*
    recur(a, 1, c)을 계산할 수 있다.
    recur(a, 1, c) == a % c
    recur(a, 2, c) == recur(a, 1, c) * recur(a, 1, c)

    recur(a, k, c)을 계산할 수 있으면 recur(a, 2k, c)과 recur(a, 2k+1, c)도 계산할 수 있다.
    recur(a, k, c) -> recur(a, k/2, c) * recur(a, k/2, c) // k는 짝수
    recur(a, 2k, c) -> recur(a, k, c) * recur(a, k, c) // k는 짝수
    recur(a, 2k+1, c) -> {recur(a, k, c) * recur(a, k, c)} * a % c // k는 홀수
    */
    // 재귀적으로 b/2되기 때문에 O(logn)
    static long recur(int a, int b, int c) {

        if (b == 1) return a % c; // base condition

        long result = recur(a, b/2, c);
        result = result * result % c;
        if (b % 2 == 0) return result; // 짝수
        else return result * a % c;
    }
}