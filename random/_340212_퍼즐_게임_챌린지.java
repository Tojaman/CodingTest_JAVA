package random;

/** 조건
 * 퍼즐 난이도 <= 숙련도: time_cur 소요
 * 퍼즐 난이도 > 숙련도: {(퍼즐 난이도 - 레벨) * (time_cur+ time_prev)} + time_cur
 * 제한 시간 내에 퍼즐 해결하는 숙련도 `최솟값`
**/

/** 풀이 방법
 * 완전 탐색 (숙련도 1~limit일 때 사용 시간 전부 구함): O(n) (n == 10^15) -> 시간 초과
 * 이분 탐색: O(logN) (50번) -> 가능
**/

/** 부족한 점
 * 이진 탐색 구현
 * 이진 탐색, lower bound, upper bound 목적 이해
**/

public class _340212_퍼즐_게임_챌린지 {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int left = 0;
        int right = 100000;
        
        while (left < right) {
            int mid = (right + left) / 2;
            long time = cal(mid, diffs, times);
            
            if (time < limit) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
    
    public long cal(int mid, int[] diffs, int[] times) {
        long time = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= mid) {
                time += times[i];
            } else {
                if (i == 0) {
                    time += (diffs[i] - mid) * times[i] + times[i];
                    continue;
                }
                time += (diffs[i] - mid) * (times[i] + times[i-1]) + times[i];
            }
        }
        return time;
    }
}
