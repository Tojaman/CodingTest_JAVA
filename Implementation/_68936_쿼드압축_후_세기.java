package Implementation;

/* 풀이 방법 - 재귀
1. 전체를 4등분한다.
2. 나눠진 각 부분이 0 or 1으로만 이루어져 있는지 확인한다
  2.1 0 or 1으로만 이루어져 있다면 그 부분은 STOP & answer[n]++
  2.2 아니라면 1로 돌아간다.
위를 "if (행, 열 크기가 1) then 탈출" 한다.
*/

// 풀이 시간: 1시간
class Solution {
    static int[] result = {0, 0};
    
    public int[] solution(int[][] arr) {
        
        recul(arr, 0, arr.length, 0, arr[0].length);
        return result;
    }
    
    public void recul(int[][] arr, int startX, int endX, int startY, int endY) {
        
        // 마지막 분할인 경우
        if (startX+1 == endX && startY+1 == endY) {
            result[arr[startX][startY]]++;
            return;
        }
        
        int num = arr[startX][startY]; // 시작 번호: 얘랑 다르면 재귀
        boolean b = true;
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                // 압축 불가
                if (num != arr[i][j]) {
                    // 4등분
                    recul(arr, startX, (startX+endX)/2, startY, (startY+endY)/2);
                    recul(arr, startX, (startX+endX)/2, (startY+endY)/2, endY);
                    recul(arr, (startX+endX)/2, endX, startY, (startY+endY)/2);
                    recul(arr, (startX+endX)/2, endX, (startY+endY)/2, endY);
                    return;
                }
            }
        }
        // 모든 값이 같은 경우
        result[arr[startX][startY]]++;
    }
}