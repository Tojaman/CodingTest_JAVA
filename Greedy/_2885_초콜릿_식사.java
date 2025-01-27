import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 엄청 간단한 문젠데 왤케 오래 풀었지;;

/** 문제
 * n개의 초콜릿을 n/2로 쪼개고 쪼갠 초콜릿들의 합으로 k개가 되도록 만들어야 함
 * -> 32 -> 16,16 -> 8, 8, 16 -> 4, 4, 8, 16 ...
 * n의 최솟값과 쪼개는 수의 최솟값 구하기
 */

/** 풀이 방법
 * 1. 초콜릿의 최소 크기 구하기 -> k보다 큰 2의 거듭제곱 수 구하기
 * 2. 초콜릿의 조합으로 k가 나오는지 구하기
 * 초콜릿을 절반으로 쪼개기 때문에 모든 초콜릿 조각은 가장 작은 크기의 초콜릿 조각의 배수이다.(4 4 8 16 32 64 ...)
 * 따라서 k가 가장 작은 초콜릿 조각(minSize)의 배수이면 현재 초콜릿 조각들로 k를 만들 수 있기 때문에 쪼개기를 종료한다.
 * ex
 * k가 28일 경우
 * 32 -> 16 16 -> 8 8 16 -> 4 4 8 16 ==> 4+8+16=28
 */
public class _2885_초콜릿_식사 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        // 초콜릿의 최소 크기 구하기
        int minSize = 2;
        while (minSize < k) minSize *= 2;
        System.out.println(minSize);

        int minSplit = 0; // 쪼갠 횟수

        while (k % minSize != 0) {
            minSize = minSize / 2;
            minSplit++;
        }
        System.out.println(minSplit);

    }
}