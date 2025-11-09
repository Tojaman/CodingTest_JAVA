/*
플러스 가입자 > 판매액
10%, 20%, 30%, 40%
*/

/* 완전탐색 비용
emoticons 완탐 비용: 4^7 = 2^14 = 16384번
users 완탐 비용: 100번
총 1,638,400번 <- 완탐 가능
*/

/* 풀이 방법 - 풀이가 너무 더러운데 이거 맞나..
Map<Integer, Integer> = new Map<>() // 플러스 가입자, 판매액
1. 재귀로 모든 경우의 수를 구하고, 각 상황에 플러스 가입자, 판매액을 구한다.
2. Map에 <플러스 가입자, Math.max(기존 금액, 새로 구한 금액) 넣기
*/
import java.util.*;

class Solution {
    static Map<Integer, Integer> result = new HashMap<>(); // <플러스 가입자, 판매액>
    // users[100][2]
    // emoticons[7]
    public int[] solution(int[][] users, int[] emoticons) {
        
        int[] salePercent = new int[emoticons.length];
        for (int i = 0; i < emoticons.length; i++) {
            salePercent[i] = 0;
        }
        
        recur(users, emoticons, 0, salePercent);
        
        int maxKey = Collections.max(result.keySet());
        return new int[] {maxKey, result.get(maxKey)};

    }
    
    public static void recur(int[][] users, int[] emoticons, int nowIndex, int[] salePercent) {
        
        // 모든 값에 할인률 적용 되었다면 -> 계산
        if (nowIndex == emoticons.length) {
            int plusCnt = 0; // 플러스 가입자
            int totalCost = 0; // 판매액
            
            // 고객 별로 플러스 가입 or 이모티콘 구매 계산
            for (int i = 0; i < users.length; i++) {
                int cost = 0; // 현재 고객의 구매액
                for (int j = 0; j < emoticons.length; j++) {
                    if (users[i][0] <= salePercent[j]) { // 구매 대상인 할인률
                        cost += emoticons[j];
                    }
                }
                // 현재 고객의 가격 초과 -> 플러스 가입
                if (cost >= users[i][1]) plusCnt++;
                // 현재 고객의 가격 미만 -> 플러스 미가입 & 이모티콘 구매
                else totalCost += cost;
                
            }
            
            // 모든 고객 계산이 완료되었다면
            // 최종적으로 플러스 가입자, Math.max(기존 판매액 vs 최신 판매액 )
            int originalCost = 0;
            if (result.containsKey(plusCnt))
                originalCost = result.get(plusCnt);
            result.put(plusCnt, Math.max(totalCost, originalCost));
            return;
        }
        
        // 40% ~ 20% 할인
        int sale = 40;
        for (int i = 0; i < 4; i++) {
            salePercent[nowIndex] = sale;
            int originalPrice = emoticons[nowIndex];
            int discountedPrice = originalPrice * (100 - sale) / 100;
            
            emoticons[nowIndex] = discountedPrice;
            recur(users, emoticons, nowIndex + 1, salePercent);
            emoticons[nowIndex] = originalPrice; // 원가로 변경
            sale -= 10;
        }
        
    }
}