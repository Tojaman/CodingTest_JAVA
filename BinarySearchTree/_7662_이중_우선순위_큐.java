package BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/* 풀이 방법
우선 순위 큐에 저장된 정수들 중 최댓값과 최솟값을 출력
I n: n 삽입
D 1: 최댓값 삽입
D -1: 최솟값 삭제
Q 비었는데 D라면 -> 무시

Q에 남은 최대/최소 데이터 출력
*/


// 2026.02.07
public class _7662_이중_우선순위_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Integer, Integer> bst = new TreeMap<>();
        int t = Integer.parseInt(br.readLine());
        // O(3TlogK)
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine()); // k ≤ 1,000,000
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char ch = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                switch (ch) {
                    case 'I':
                        bst.put(num, bst.getOrDefault(num, 0)+1);
                        break;
                    case 'D':
                        if (bst.isEmpty()) break; // 비어 있다면 넘어감

                        if (num == 1) { // 최댓값
                            int lastKey = bst.lastKey();
                            int lastValue = bst.get(lastKey);
                            if (lastValue > 1) bst.put(lastKey, lastValue - 1);
                            else bst.remove(lastKey);
                            break;
                        } else { // 최솟값
                            int firstKey = bst.firstKey();
                            int firstValue = bst.get(firstKey);
                            if (firstValue > 1) bst.put(firstKey, firstValue - 1);
                            else bst.remove(firstKey);
                            break;
                        }
                }
            }

            if (bst.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(bst.lastKey() + " " + bst.firstKey());
            }
            bst.clear();
        }
    }
}
