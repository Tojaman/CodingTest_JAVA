import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 풀이 시간: 1시간 6분 → 문제를 이해하는 데 시간이 오래 걸림.. 독해력 뭐냐?
/** n일 동안 k원을 총 m번 인출해서 사용하기
 * - k 충분: 그대로 사용
 * - k 부족: 남은 금액 입금 && 다시 k원 인출
 * 만약 충분하더라도 M번에 맞추기 위해 부족 동작을 진행할 수 있음 → 마지막 날에 필요한 만큼 반복하면 되기 때문에 이건 구현하지 않아도 됨
 * k를 최소화 k 구하기
 */
public class _6236_용돈_관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n일 동안
        int m = Integer.parseInt(st.nextToken()); // m번만 인출

        int[] dayPrice = new int[n];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            dayPrice[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, dayPrice[i]);
            sum += dayPrice[i];
        }
        System.out.println(binarySearch(max, sum, dayPrice, m));
        // binarySearch(Arrays.stream(dayPrice).max().getAsInt(), Arrays.stream(dayPrice).sum(), dayPrice);
    }
    
    // left: price의 최댓값
    public static int binarySearch(int left, int right, int[] dayPrice, int m) {
        if (left >= right) return right;
        int mid = (left + right) / 2; // k
        
        int s = 0;
        int cnt = 0;
        for (int price : dayPrice) {
            // 수중의 돈(s)이 오늘 사용해야 하는 돈(price)보다 많다면 -> 인출하지 않고 사용
            // 수중의 돈(s)이 오늘 사용해야 하는 돈(price)보다 적다면 -> 수중의 돈(s)는 입금하고 k원 인출해서 사용
            if (price <= s) {
                s -= price; // s = price 사용하고 남은 돈
            } else {
                s = mid - price; // s = k(mid)원 인출하고 price 사용하고 남은 돈
                cnt++;
            }
        }
        if (cnt <= m) {
            return binarySearch(left, mid, dayPrice, m);
        } else {
            return binarySearch(mid + 1, right, dayPrice, m);
        }

    }
}
