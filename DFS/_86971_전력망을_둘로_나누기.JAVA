/** 문제 설명
n: 송전탑 개수
wires[][]: 전선 정보
전선을 하나 끊어서 송전탑 개수가 비슷한 두 전력망으로 나누기
*/

/* 풀이 방법 - DFS
각 간선을 잘랐을 때 송전탑 개수를 구하고, 최소를 출력

자른 간선의 양쪽 노드에 DFS 수행하여 송전탑 개수 구하고 뺀 값을 구함
각 값의 최소 출력
*/

// 1시간 4분;; 구현 연습좀 하자;
import java.util.*;
class Solution {
    static LinkedList<Integer>[] list;
    public int solution(int n, int[][] wires) {
        
        list = new LinkedList[n+1];  // 배열 생성 (null로 초기화)
        for(int i = 1; i <= n; i++) {
            list[i] = new LinkedList<Integer>();  // 각 요소 초기화
        }
        
        for (int i = 0; i < wires.length; i++) {
            int node1 = wires[i][0];
            int node2 = wires[i][1];
            list[node1].add(node2);
            list[node2].add(node1);
        }
        
        int min = Integer.MAX_VALUE;
        // O(n^2)
        for (int i = 0; i < wires.length; i++) {
            int node1 = wires[i][0];
            int node2 = wires[i][1];
            
            boolean[] visited1 = new boolean[n+1];
            visited1[node2] = true;
            int cnt1 = dfs(node1, visited1);

            min = Math.min(Math.abs(cnt1-(n-cnt1)), min);
            
            // boolean[] visited2 = new boolean[n+1];
            // visited2[node1] = true;
            // int cnt2 = dfs(node2, visited2);
            
            // min = Math.min(Math.abs(cnt1-cnt2), min);
        }
        return min;
    }
    
    public int dfs(int cur, boolean[] visited) {
        visited[cur] = true;
        int cnt = 1;
        
        for (int j = 0; j < list[cur].size(); j++) {
            int next = list[cur].get(j);
            if (!visited[next]) {
                cnt += dfs(next, visited);
            }
        }
        return cnt;
    }
}