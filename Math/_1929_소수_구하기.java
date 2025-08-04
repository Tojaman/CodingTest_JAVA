package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 소수 구하는 알고리즘
 * 소수란 1과 자기 자신만을 약수로 갖는 수를 의미한다.
 * 2 ~ 자기 자신-1까지 자기 자신과 나누어 떨어지는지 확인하고 하나라도 있다면 소수가 아닌 것
 * 그런데 약수는 대칭 형태를 이루고 있으므로 sqrt(자기 자신)까지만 확인해도 소수인지 확인이 가능하다.
 * 이러한 원리를 이용하여 특정 범위의 소수를 구하는 것이 에라토스테네스의 체이다.
*/

/** 에라토스테네스의 체 - O(nlog(log n))
 * 1은 소수이므로 제외하고 2부터 n까지 순회하며 소수임을 검증한다. (2 <= i <= n)
 * 이때 i의 배수는 소수가 아니므로 전부 소수에서 제외한다.
 * 즉, 2 ~ n까지 순회하면서 소수가 아닌 i의 배수를 제외한다.
 */
public class _1929_소수_구하기 {
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        
        eratosthenes(m, n);
        for (int i = m; i <= n; i++) {
            if (isPrime[i])
                System.out.println(i);
        }
        
    }
    
    public static void eratosthenes(int m, int n) {
        for (int i = 2; i*i <= n; i++) { //m ~ sqrt(n)까지 탐색
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j+=i) { //i 자기 자신을 제외한 i의 배수(j+=i)를 소수에서 제거
                    isPrime[j] = false;
                }
            }
        }
    }
}