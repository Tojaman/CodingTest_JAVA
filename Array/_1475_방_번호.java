import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1475_방_번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 한 세트에는 숫자 하나씩만 있음 & 6,9는 뒤집어 사용 가능
        // 따라서 최대 중복 숫자 개수 구하기

        int max = 0;
        int n = Integer.parseInt(br.readLine());

        int[] cnts = new int[10];
        // O(n)
        while (n > 0) {
            int digit = n%10; // 마지막 자리
            cnts[digit]++;
            n /= 10;
        }

        cnts[6] = (cnts[6] + cnts[9]) / 2 + (cnts[6] + cnts[9]) % 2;
        cnts[9] = 0;

        // O(n)
        for (int cnt : cnts) {
            max = Math.max(max, cnt);
        }
        System.out.println(max);

    }
}
