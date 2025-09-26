package Implementation;

public class _12949_행렬의_곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int arrColumn = arr1.length;
        int arrRow = arr1[0].length;
        int arr2Row = arr2[0].length;
        
        int[][] answer = new int[arrColumn][arr2Row];
        
        // O(n*m^2): 최대 1,000,000
        for (int i = 0; i < arrColumn; i++) { // arr1의 행
            for (int j = 0; j < arr2Row; j++) { // arr2의 열
                for (int k = 0; k < arrRow; k++) { // arr1의 열 == arr2의 행
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
