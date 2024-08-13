package BFS;
import java.util.*;
class _43162_네트워크 {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(computers, i);
                cnt++;
            }
        }
        return cnt;
    }
    
    public void bfs(int[][] computers, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            int current = q.poll();
            
            for (int i = 0; i < computers[current].length; i++) {
                if (computers[current][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
            
        }
    }
}