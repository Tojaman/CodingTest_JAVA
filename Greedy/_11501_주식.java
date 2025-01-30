import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 두 번째 풀이(역순환 아이디어 참고함) - O(t*n) ~= O(n)
/** 풀이 방법
 * 1. 각 날짜의 미래 주가를 확인한다.
 * 2-1. 미래에 주가가 오른다면 매수하고 고점에 매도(고점 - 현재)
 * 2-2. 미래에 주가가 오르지 않는다면 아무것도 하지 않음
 */
public class _11501_주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        // O(t*n*(n-1))
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 날짜 별 주가 입력
            int[] dailyPrice = new int[n];
            for (int j = 0; j < n; j++) { // 1,000,000
                dailyPrice[j] = Integer.parseInt(st.nextToken());
            }

            long result = 0; // 부호있는 64bit 정수형으로 출력해야 하기 때문에 long(64bit == 8byte) 자료형으로 변경( int(32bit == 4byte))
            int max = dailyPrice[n-1];
            /** 역순으로 순환하며 고점 갱신
             * 현재 가격 < 고점 -> 고점 매도
             * 현재 가격 >= 고점 -> 아무것도 하지 않기
             */
            for (int k = n-2; k >= 0; k--) {
                max = Math.max(max, dailyPrice[k]); // 현재 값과 이전의 최댓값을 비교하여 삽입 -> 만약 현재 값이 가장 크다면 max엔 현재 값이 / 현재 값이 작다면 max엔 매도 가격이 있음음
                // 현재 값 < 최댓값 -> 매도
                if (dailyPrice[k] < max) {
                    result += max - dailyPrice[k];
                    
                }   
            }
            System.out.println();
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}

// 첫 번째 풀이(시간초과) - O(t*n^2) ~= O(n^2)
/** 풀이 방법
 * 1. 각 날짜의 미래 주가를 확인한다.
 * 2-1. 미래에 주가가 오른다면 매수하고 고점에 매도(고점 - 현재)
 * 2-2. 미래에 주가가 오르지 않는다면 아무것도 하지 않음
 */
// public class _11501_주식 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         StringBuilder sb = new StringBuilder();
//         int t = Integer.parseInt(br.readLine());
//         for (int i = 0; i < t; i++) {
//             int n = Integer.parseInt(br.readLine());
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             // 날짜 별 주가 입력
//             int[] dailyPrice = new int[n];
//             for (int j = 0; j < n; j++) {
//                 dailyPrice[j] = Integer.parseInt(st.nextToken());
//             }

//             int result = 0;
//             // 매수 매도 진행
//             for (int k = 0; k < n-1; k++) {
//                 int max = 0;
//                 for (int m = k+1; m < n; m++) {
//                     max = Math.max(max, dailyPrice[m]);
//                 }
//                 // 미래에 주가가 오른다면 -> 매수 후 최고점 매도
//                 if (dailyPrice[k] < max) {
//                     result += max - dailyPrice[k];
//                 }
//             }
//             sb.append(result).append("\n");
//         }
//         System.out.println(sb.toString().trim());
//     }
// }