package Greedy;

/*
K칸 점프: 건전지 사용량⬇️
(현재까지 온 거리)*2의 위치 순간이동: 건전지 사용X
*/

/* 풀이 방법 - 그리디
/2를 우선으로 해야 하기 때문에 n이 짝수면 나누고, 홀수면 -1해서 짝수로 만드는 방식을 통해 가능한 많은 /2를 한다.
*/
// 풀이 시간: 10분
public class _12980_점프와_순간_이동 {
    public int solution(int n) {
        int result = 0;

        while (n != 0) {
            if (n%2 == 0) { // 짝수
                n = n/2;
            } else { // 홀수
                n--;
                result++;
            }
        }
        return result;
    }
}