// /** 
// */
// import java.util.*;
// class Solution {
//     int[][] graph;
//     Queue<int[]> q = new LinkedList<>();
//     boolean[][] visit;
//     int[][] move;
//     public int solution(int n, int[][] edge) {
//         graph = new int[n+1][n+1];
//         visit = new boolean[n+1][n+1];
//         move = new int[n+1][n+1];
        
//         for (int i = 0; i < edge.length; i++) {
//             graph[edge[i][0]][edge[i][1]] = 1;
//             graph[edge[i][1]][edge[i][0]] = 1;
//         }
        
//         bfs(1, 1, n);
//         int max = 0;
//         int count = 0;
//         for (int i = 1; i < n+1; i++) {
//             for (int j = i; j < n+1; j++) {
//                 if (max < move[i][j]) {
//                     max = move[i][j];
//                     count = 1;
//                 }
//                 if (max == move[i][j])
//                     count++;
//             }
//         }
//         return count;
//     }
    
//     public void bfs(int x, int y, int n) {
//         q.add(new int[] {x, y});
//         visit[x][y] = true;
//         move[x][y] = 1;
        
//         int dx[] = {0,1,0,-1};
//         int dy[] = {1,0,-1,0};
        
//         while(!q.isEmpty()) {
//             int[] now = q.poll();
//             int nowx = now[0];
//             int nowy = now[1];
            
//             for (int i = 0; i < 4; i++) {
//                 int nextx = nowx + dx[i];
//                 int nexty = nowy + dy[i];
//                 if (nextx < 0 || nexty < 0 || nextx > n || nexty > n)
//                     continue;
//                 if (graph[nextx][nexty] == 1 && visit[nextx][nexty] == false) {
//                     q.add(new int[] {nextx, nexty});
//                     visit[nextx][nexty] = true;
//                     move[nextx][nexty] = move[nowx][nowy] + 1;
//                 }
//             }
//         }
        
        
//     }
// }
package BFS;
import java.util.*;

class _49189_가장먼노드 {
    ArrayList<Integer>[] graph;
    int[] distance;

    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n + 1];
        distance = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        bfs(1, n);
        
        int maxDistance = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                count = 1;
            } else if (distance[i] == maxDistance) {
                count++;
            }
        }
        
        return count;
    }
    
    private void bfs(int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph[current]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                }
            }
        }
    }
}