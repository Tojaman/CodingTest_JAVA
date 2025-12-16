package random;
/** 조건
 * 최소 미사일 개수 구하기
 * 개구간(s, e) 요격 미사일 구하기 (관통 요격 가능)
 * s < 요격 < e
**/

/** 풀이 방법 - Greedy (정답 봐버림;;)
 * targets[] 끝점 기준 정렬
 * 순서대로 탐색하며 현재 미사일의 시작지가 요격 지점 이후 -> 추가 요격(최대 요격을 위해 현재 미사일 끝지점 요격)
**/
import java.util.Arrays;

public class _181188_요격_시스템 {
    public int solution(int[][] targets) {
        int result = 0;
        
        
        // 시간복잡도: O(nlogn) (n = 500,000)
        // targets[i][1] 기준 오름차순
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int intercept = 0;
        for (int i = 0; i < targets.length; i++) { // 시간 복잡도: O(n) (n = 500,000)
            // 만약 이전 요격 지점이 현재 미사일 이전이라면(시작점은 요격이 불가하므로 `>=`) 추가 요격 필요
            // -> 최대한 많이 요격하기 위해 현재 미사일의 끝지점 요격(targets[i][1])
            if (targets[i][0] >= intercept) {
                intercept = targets[i][1];
                result++;
            }
        }
        return result;
    }
}