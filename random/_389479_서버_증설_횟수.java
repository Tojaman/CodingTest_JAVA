package random;

import java.util.*;
/** 풀이 방법
1. players 순환
1-1. 서버 운영 시간 초과시 반납
1-2. 현재 게임 이용자 수와 현재 서버 대수를 비교 -> 만약 서버 대수가 부족하다면 추가 (증설 횟수 기록)
2. 최종 증설 횟수 반환
**/

// class Solution {
public class _389479_서버_증설_횟수 {
    public int solution(int[] players, int m, int k) {
        int scaleUpCnt  = 0; // 증설 횟수
        int serverCnt = 0; // 현재 서버 수
        HashMap<Integer, Integer> downTime = new HashMap<>(); // 서버 다운 시간
        
        for (int i = 0; i < players.length; i++) {
            
            // 서버 반납
            if (downTime.containsKey(i)) {
                serverCnt -= downTime.get(i);
                downTime.remove(i);
            }
            
            int neededCnt = players[i] / m;
            
            if (neededCnt > serverCnt) {
                int lackCnt = neededCnt - serverCnt;
                scaleUpCnt += lackCnt;
                serverCnt += lackCnt;
                downTime.put(i+k, lackCnt);
            }
        }
        
        return scaleUpCnt;
    }
}