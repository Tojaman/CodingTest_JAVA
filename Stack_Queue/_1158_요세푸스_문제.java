package Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * n = 총 인원(1 ~ n)
 * k = 제거되는 사람 번호
 * 첫 번째 인원은 제거된 사람 바로 다음 사람
 */
public class _1158_요세푸스_문제 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>(); 
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!q.isEmpty()) {
            for (int i = 1; i <= k; i++) {
                if (i == k) {
                    sb.append(q.poll() + ", ");
                    break;
                }

                q.offer(q.poll());
                
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.print(sb.toString());
    }

    // 처음 푼 방식
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     Queue<Integer> q = new LinkedList<>();
    //     StringTokenizer st = new StringTokenizer(br.readLine());
    //     int n = Integer.parseInt(st.nextToken()); // 사람 수
    //     int k = Integer.parseInt(st.nextToken()); // k번째 사람 제거

    //     for (int i = 1; i <= n; i++) q.offer(i);

    //     ArrayList<Integer> arr = new ArrayList<>();
    //     while(true) {
    //         for (int i = 0; i < k; i++) {
    //             if (i == k - 1) {
    //                 arr.add(q.poll());
    //                 break;
    //             }
    //             q.offer(q.poll());
    //         }
    //         if (arr.size() == n) break;
    //     }

    //     StringBuilder sb = new StringBuilder();
    //     sb.append("<");
    //     for (int i = 0; i < arr.size(); i++) {
    //         sb.append(arr.get(i));
    //         if (i != arr.size()-1) {
    //             sb.append(", ");
    //         }
    //     }
    //     sb.append(">");
    //     System.out.println(sb);
    // }
}
