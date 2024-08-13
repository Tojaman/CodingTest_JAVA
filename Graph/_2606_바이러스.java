package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _2606_바이러스 {
    static int[][] graph;
    static HashSet<Integer> hs = new HashSet<>();
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertexCnt = Integer.parseInt(br.readLine());
        int edgeCnt = Integer.parseInt(br.readLine());

        // 인접 행렬 그래프: 탐색이 핵심이기 때문에 인접 리스트가 아닌 인접 행렬을 이용해 구현
        graph = new int[vertexCnt+1][vertexCnt+1];
        for (int i = 0; i < edgeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            graph[vertex1][vertex2] = 1;
            graph[vertex2][vertex1] = 1;
        }


        hs.add(1);
        for (int i = 0; i < graph[1].length; i++) {
            if (graph[1][i] == 1 && !hs.contains(i)) {
                hs.add(i);
                search(i);
            }
        }
        System.out.println(hs.size()-1);


    }

    public static void search(int target) {
        for (int i = 0; i < graph[target].length; i++) {
            if (graph[target][i] == 1 && !hs.contains(i)) {
                hs.add(i);
                search(i);
            }
        }
    }
}
