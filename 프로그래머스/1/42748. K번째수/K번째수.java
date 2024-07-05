/** 문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수 구하기

*/

/** 풀이 방식

*/
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        int s = 0;
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            ArrayList<Integer> al = new ArrayList<>();
            
//             for (int index = i-1; index < j-1; index++) {
//                 al.add(array[index]);
//             }
            
//             al.sort(null); // 2 3 5 6
//             result[s++] = al.get(k-1); // 5
            
            int[] temp = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(temp);
            result[s++] = temp[k-1];
        }
        return result;
    }
}