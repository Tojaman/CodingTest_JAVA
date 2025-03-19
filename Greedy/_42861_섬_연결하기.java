import java.util.*;

/** n개의 모든 노드가 연결되기 위한 조건
1. 모든 노드가 간선에 연결되어 있어야 함
2. n-1개의 간선만 연결되어야 함 
3. 사이클이 생기지 않아야 함
*/

/** 최소 비용의 간선을 선택하는 방법
1. 모든 간선 중 최소 비용의 간선부터 선택해야 함(그리디) -> 간선(costs[][])의 비용(costs[i][2])을 기준으로 정렬해야 함
2. 통행 가능한 노드 간 간선은 선택할 수 없음(사이클X) -> 간선이 선택되면 연결 가능한 노드를 저장해야 함
*/

// 크루스칼 알고리즘, 최소 신장 트리(MST) 문제
/** Union-Find란?
1. 노드는 각각 집합을 갖고 있고 루트 노드(연결된 노드 중 가장 작은 노드)를 갖고 있다.
2. 두 노드를 연결하기 위해서는 루트 노드 값을 비교하여 다르다면 연결한다. 왜냐하면 루트 노드가 다를 경우 사이클이 발생하지 않기 때문이다.
3. 즉, 각 노드 별로 루트 노드를 저장해야 한다. -> 배열의 index가 node 값이고 value가 root node 값
*/
class Solution {
    static int[] parent;
    static int[] rank;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        rank = new int[n];
        int answer = 0;
        // 간선 비용 오름차순 정렬 - 세 번째 숫자 기준 오름차순 정렬(간선 비용 기준 오름차순 정렬)
        Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));
        

        // MakeSet
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        // Find && Union by Rank
        for (int i = 0; i < costs.length; i++) {
            // find
            int rootNode1 = find(costs[i][0]);
            int rootNode2 = find(costs[i][1]);
            
            // union-by-rank
            answer += unionByRank(rootNode1, rootNode2, costs, i);
        }
        
        return answer;
    }
    
    public static int unionByRank(int rootNode1, int rootNode2, int[][] costs, int i) {

        int answer = 0;
        // union-by-rank
        if (rootNode1 != rootNode2) {
            if (rank[rootNode1] < rank[rootNode2]) {
                parent[rootNode1] = rootNode2;
            }
            else if (rank[rootNode1] > rank[rootNode2]) {
                parent[rootNode2] = rootNode1;
            }
            else {
                parent[rootNode2] = rootNode1;
                rank[rootNode1]++;
            }

            answer = costs[i][2];
        }
        return answer;
    }
    
    public static int find(int x) {
        
        if (parent[x] == x) // 부모 노드 == 자기 자신
            return x;
        else { // 부모 노드가 있다면 부모 노드로 올라감(재귀)
            return parent[x] = find(parent[x]);
        }
    }
}


// class Solution {
//     static int[] uf;
//     public int solution(int n, int[][] costs) {
//         uf = new int[n];
//         int answer = 0;
        
//         // 간선 비용 오름차순 정렬 - 세 번째 숫자 기준 오름차순 정렬(간선 비용 기준 오름차순 정렬)
//         Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));
        
//         // 서로소 집합
         
//         for (int i = 0; i < n; i++) {
//             uf[i] = i;
//         }
        
//         // 오름차순으로 간선을 돌면서 두 노드(costs[i][0], costs[i][1])의 루트 노드를 비교하여 다르다면 연결(사이클X)
//         for (int i = 0; i < costs.length; i++) {
//             // find
//             int rootNode1 = find(costs[i][0]);
//             int rootNode2 = find(costs[i][1]);
            
//             // union
//             if (rootNode1 != rootNode2) {
//                 if (rootNode1 > rootNode2) {
//                     uf[costs[i][0]] = uf[costs[i][1]];
//                 } else {
//                     uf[costs[i][1]] = uf[costs[i][0]];
//                 }
                
//                 answer += costs[i][2];
//             }
//         }
        
//         return answer;
//     }
    
//     public static int find(int x) {
        
//         if (uf[x] == x) // 부모 노드 == 자기 자신
//             return x;
//         else { // 부모 노드가 있다면 부모 노드로 올라감(재귀)
//             return uf[x] = find(uf[x]);
//         }
//     }
// }


// class Solution {
//     public int solution(int n, int[][] costs) {
//         int answer = 0;
        
//         // 간선 비용 오름차순 정렬 - 세 번째 숫자 기준 오름차순 정렬(간선 비용 기준 오름차순 정렬)
//         Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));
        
//         // 1. 이미 연결된 간선인가?
//         // 연결된 간선을 저장하는 HashSet(costs의 인덱스) -> 헤당 index가 set에 없다면 연결 가능
//         HashSet<Integer> edges =  new HashSet<Integer>();
        
//         // 2. 통행 가능한 노드인가?(사이클 여부 확인) - X 잘못된 방법 -> Union-Find로 검증해야 함
//         // 연결 가능한 노드를 저장하는 자료구조(HashSet) -> 두 노드가 set에 있는지 확인하고 하나라도 없다면 연결
//         HashSet<Integer> nodes =  new HashSet<Integer>();
        
//         /**
//         - costs[][]를 돌면서 1과 2를 검증한 뒤 검증에 통과하면 간선으로 선택
//         - 종료 조건: edges.size() == n-1 || nodes.size() == n 둘 중 하나?
//         */
        
//         // while(true) {
//         //     if (edges.size() == n-1 || nodes.size() == n) {
//         //         break;
//         //     }
            
//         for (int i = 0; i < costs.length; i++) {
//             // 해당 간선이 사용됐는가 && 연결되는 두 노드 중 하나롣 없는가(사이클) 검증
//             if (!edges.contains(i) && (!nodes.contains(costs[i][0]) || !nodes.contains(costs[i][1]))) {
//                 edges.add(i);
//                 nodes.add(costs[i][0]);
//                 nodes.add(costs[i][1]);
//                 answer += costs[i][2];
//                 // break;
//             }
//         }
//         // }
        
//         return answer;
//     }
// }