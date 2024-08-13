/** 문제 설명
모든 명함을 수납할 수 있는 명함 지갑의 최소 크기를 구하라.
필요에 따라 명함의 가로와 세로의 길이를 서로 교환할 수 있다.
*/

/** 문제 풀이
가로 세로 길이를 교환한 후 가로 세로의 최댓값을 뽑는다.
이중 최소 최댓값으로 명합 지갑을 만들면 된다.
시간 복잡도: O(2^명함의 개수)
*/
package ExhaustiveSearch;
import java.util.*;
class _86491_최소직사각형 {
    public int solution(int[][] sizes) {
        
        // 각 명함의 가로 세로 길이 중 큰 값을 가로에 넣고 작은 값을 세로에 넣는다.
        for (int i = 0; i < sizes.length; i++) {
            int width = Math.max(sizes[i][0], sizes[i][1]); // 큰 값을 가로
            int length = Math.min(sizes[i][0], sizes[i][1]); // 작은 값을 세로
            sizes[i][0] = width;
            sizes[i][1] = length;
        }
        Arrays.sort(sizes, (o1, o2) -> Integer.compare(o2[0], o1[0]));
        int maxWidth = sizes[0][0];
        Arrays.sort(sizes, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        int maxLength = sizes[0][1];
        
        return maxWidth * maxLength;
        
        
        // int[] size = new int[2]; // 명함 지갑 가로 세로 최댓값
        
        // Arrays.sort(sizes, (o1[0], o2[0]) -> Integer.compare(o2[0], o1[0]));
        // int size[0] = sizes[0][0];
        // Arrays.sort(sizes, (o1[1], o2[1]) -> Integer.compare(o2[1], o1[1]));
        // int size[1] = sizes[1][1];
        // int maxWidth = findMax(sizes, 0);
        // int maxLength = findMax(sizes, 1);
        // for (int i = 0; i < sizes.length; i++) {
        //     swap(sizes, i);
        //     int tmpMaxWidth = findMax(sizes, 0);
        //     int tmpMaxLength = findMax(sizes, 1);
        //     if (tmpMaxWidth > maxWidth) {
        //         maxWidth = tmpMaxWidth;
        //     }
        //     if (tmpMaxLength > maxLength) {
        //         maxLength = tmpMaxLength;
        //     }
        // }
        // return maxWidth*maxLength;
        
    }
    
//     public int findMax(int[][] sizes, int row) {
//         int max = 0;
//         for (int i = 0; i < sizes.length; i++) {
//             if (sizes[i][row] > max) {
//                 max = sizes[i][row];
//             }
//         }
//         return max;
//     }
    
//     public void swap(int[][] sizes, int i) {
//         int tmp = sizes[i][0];
//         sizes[i][0] = sizes[i][1];
//         sizes[i][1] = tmp;
//     }
}