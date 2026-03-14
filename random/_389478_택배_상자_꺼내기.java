import java.util.*;

/* 풀이 방법
1. 2차원 배열에 상자 쌓기
- 행 순환하며 짝수일 때 오른쪽, 홀수일 때 왼쪽으로
- 찾고자 하는 값이 나오면 col 기록
- 박스가 n을 넘어가지 않도록 순환 설정

2. 행을 순환하며 result가 나올 때까지 개수 기록
- col을 보고 상자가 있고(!=0), num가 아니라면 개수++
- num이 나오면 개수++하고 탈출
*/

// 39분
class Solution {
    public int solution(int n, int w, int num) {
        int result = 0;
        
        int row = n%w == 0 ? n/w : n/w +1;
        int[][] boxes = new int[row][w];
        
        int box = 1;
        int col = 0;
        for (int i = 0; i < row; i++) {
            
            // 짝수: 왼->오
            if (i%2 == 0) {
                // ✅&& box <= n 
                for (int j = 0; j < w && box <= n; j++) {
                    if (num == box) col = j;
                    boxes[i][j] = box++;
                }
                continue;
            }
            
            // 홀수: 오->왼
            // ✅&& box <= n 
            for (int j = w-1; j >= 0 && box <= n; j--) {
                if (num == box) col = j;
                boxes[i][j] = box++;
            }
        }
        
        for (int i = row-1; i >= 0; i--) {
            int nowBox = boxes[i][col];
            if (nowBox != 0 && nowBox != num) result++;
            if (nowBox == num) {
                result++;
                break;
            }
        }
        
        return result;
    }
}