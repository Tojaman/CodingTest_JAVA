import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        return bfs(numbers, target);
    }
    
    public int bfs(int[] numbers, int target) {
        // {현재 값, 인덱스}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {numbers[0], 0});
        q.offer(new int[] {-numbers[0], 0});
        boolean[][] visited = new boolean[numbers.length][2];
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cIndex = current[1]+1;
            if (cIndex < numbers.length) {
                int nextP = current[0] + numbers[cIndex];
                q.offer(new int[]{nextP, cIndex});
                int nextM = current[0] - numbers[cIndex];
                q.offer(new int[]{nextM, cIndex});
            }
            
            if (cIndex == numbers.length && current[0] == target) {
                cnt++;
            }
        }
        return cnt;
    }
}