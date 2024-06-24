/** 문제 설명
1. 정렬
    2차원 배열 data[]가 주어진다.
    각 행의 col(열) 값을 기준으로 오름차순 정렬을 한다.
    이때 각 행의 col(열)값이 같다면 같은 행(row)값은 첫 번째 col(열) 값을 기준으로 내림차순 정렬한다.
2. S_i 계산 및 XOR 계산
    정렬된 데이터에서 row_begin ~ row_end까지의 행의 요소들(열값들)을 i(행)값으로 나눈 후 더한다.
    모든 S_i값을 누적하여 XOR한 결과값을 반환한다.
*/

/** 풀이 방법
1. 각 행을 순회하며 각 행의 col(열)값을 기준으로 오름차순 정렬한다.
   if 각 행의 col이 같다 then 각 행의 첫 번째 값을 기준으로 내림차순 정렬
2. row_begin ~ row_end 행의 S_i를 계산한다.
3. S_i값들의 XOR을 계산하여 결과값을 반환한다.
*/

/** 상세 풀이 방법
- HashMap을 이용하여 각 행의 col 요소를 {행, 행의 col}로 저장한다.
- 행의 col을 기준으로 오름차순 정렬한다.
- 행의 col이 같다면 행[0]을 기준으로 내림차순 정렬한다.
- 정렬이 완료됐다면 key 값을 이용하여 data 배열 정렬을 완성한다.



*/
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        // *** 혼자 해결 못함 ***
        // 각 행의 col번째 요소를 기준으로 내림차순 정렬
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] row1, int[] row2) {
                int compareCol = Integer.compare(row1[col-1], row2[col-1]);
                
                // col(열)값이 같다면 첫번째 값을 기준으로 내림차순 정렬
                if (compareCol == 0)
                    return Integer.compare(row2[0], row1[0]);
                return compareCol;
            }
        });
        
        // S_i 구하기
        int[] S = new int[data.length]; // 2
        for (int i = row_begin-1; i < row_end; i++) { // 1 ~ 2
            S[i] = 0;
            for (int j = 0; j < data[i].length; j++) {
                S[i] += data[i][j] % (i+1);
            }
        }
        
        int result = S[row_begin-1];
        for (int i = row_begin; i < row_end; i++) {
            result ^= S[i];
        }
        
        return result;
        
        // return data[2];
        // return Arrays.stream(S).sum();
        
        
        
        
        // HashMap<Integer, Integer> hm = new HashMap<>();
        // // 각 행을 돌면서 각 행의 col 요소를 기준으로 HashMap에 저장
        // for (int i = 0; i < data.length; i++) {
        //     hm.put(i, data[i][col]); // i번째 행의 col번째 요소를 hm에 저장
        // }
        
        
        
    }
}