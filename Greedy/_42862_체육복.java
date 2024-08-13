package Greedy; /** 조건
1. lost 학생이 reserve에도 있는지 확인(있다면 빌릴 필요 없음)
2. 1에 해당하지 않다면 앞 뒤로 reserve 학생이 있는지 확인
3. reserve 학생이 있다면 그 학생이 lost에 있는지 확인한 후 없다면 빌리기
**/

/** 풀이 방법
여벌 체육복이 있는 학생만 빌려줄 수 있기 때문에 다른 학생의 전달에 의해 빌려주는 방식은 불가능하다.
즉, 바로 앞 뒤 학생에게만 빌릴 수 있다.
**/
import java.util.*;
class _42862_체육복 {
    // n: 전체 학생 수, lost[]: 도난당한 학생들의 번호, reserve[]: 여벌 체육복 있는 학생들의 번호
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int result = n - lost.length;
        
        // 여분이 있으면서 도난 당한 학생 처리
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    result += 1;
                    break;
                }
            }
        }
        
        // 여분이 없고 도난 당한 학생 처리
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) continue;
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == -1) continue;
                if (lost[i] -1 == reserve[j] || lost[i] +1 == reserve[j]) {
                    reserve[j] = -1;
                    result += 1;
                    break;
                }
            }
        }
        return result;
    }
}