import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/** 문제 풀이
 * D[n] = [시그마(D[n-1] 각 자리 숫자 * P)]
 * D[n] = nm -> D[n+1] = (n^2)+(m^2) -> D[n+2] = (n^2)^2 + (m^2)^2
 * 같은 숫자가 나오면 그때부터 반복순열이 시작되므로 같은 숫자가 나오는지 검증하고 나온 index 반환하면 됨
 */

// 첫번째 풀이에서 개선된 코드
public class _2331_반복수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        ArrayList<Integer> array = new ArrayList<>();
        array.add(a);
        int now;
        int i = 0;
        while (true) {
            // 외우기 get(index) -> return value, indexOf(value) -> return index
            int before = array.get(i++);
            now = 0;

            String sNum = String.valueOf(before); // "4873"
            for (int j = 0; j < sNum.length(); j++) {
                now += Math.pow(sNum.charAt(j) - '0', p);
            }

            if (array.contains(now)) {
                break;
            }
            array.add(now);
        }

        System.out.print(array.indexOf(now));
    }
}

/** 첫번째 풀이
public class _2331_반복수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> array = new ArrayList<>();
        array.add(a);
        hs.add(a);

        int result = 0;
        int i = 0;
        while (true) {
            // 외우기 get(index) -> return value, indexOf(value) -> return index
            int before = array.get(i++);
            int now = 0;
            // 결과를 저장할 리스트 생성
            List<Integer> digits = new ArrayList<>();
            String sNum = String.valueOf(before); // "4873"
            for (char c : sNum.toCharArray()) {
                // 3. 각 문자를 숫자로 변환하여 리스트에 추가
                digits.add(Character.getNumericValue(c));
            }

            for (double digit : digits) {
                now += Math.pow(digit, p);
            }


            if (hs.contains(now)) {
                for (int j = 0; j < array.size(); j++) {
                    if (now == array.get(j)) {
                        result = j;
                        break;
                    }
                }
                break;
            }
            hs.add(now);
            array.add(now);
        }

        System.out.print(result);
    }
}
*/