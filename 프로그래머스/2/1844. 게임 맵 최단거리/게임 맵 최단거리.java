
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        int[][] visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            if (current[0] == maps.length -1 && current[1] == maps[0].length -1) return visited[current[0]][current[1]];
            
            for (int i = 0; i < 4; i++) {
                int cx = current[0] + dx[i];
                int cy = current[1] + dy[i];
                
                if (cx >= 0 && cx < maps.length && cy >= 0 && cy < maps[0].length) {
                    if (visited[cx][cy] == 0 && maps[cx][cy] == 1) {
                        q.offer(new int[] {cx, cy});
                        visited[cx][cy] = visited[current[0]][current[1]] + 1;
                    }
                }
            }
        }
        return -1;
    }
}