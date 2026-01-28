import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
1. 인접한 () 쌍: 레이저
2. 인접하지 않은 () 쌍: 쇠막대기
*/

/* 풀이 방법 - 스택(수식의 괄호 쌍)
1. '('은 무조껀 push
2. ')'는 레이저와 쇠막대기로 구분
2-1. st.peek()의 index가 현재 index 바로 이전(인접한 쌍)이라면 -> 레이저: 조각 += st.size()
2-2. 인접한 쌍이 아니라면 -> 쇠막대기: 조각 + 1

레이저가 한 번 발사되면 Stack에 있는 쇠막대기들이 잘라지기 때문에 "조각 += st.size()"
쇠막대기의 끝지점에서 조각이 하나 추가되므로 "조각++"
*/

// 구현 시간: 35분
// O(n)
// 항상 시간 복잡도 미리 계산해보자
public class _10799_쇠막대기 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<int[]> st = new Stack<>();
        char[] input = br.readLine().toCharArray(); // <= 100,000
        int result = 0;
        // O(n): n = 100,000
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                st.push(new int[] {input[i], i});
            } else {
                if (!st.isEmpty() && st.peek()[1] == i-1) { // 레이저
                    // 레이저의 위치 저장
                    st.pop();
                    result += st.size();
                    // rager.add(i-1); // 레이저 위치
                }
                 else if (!st.isEmpty()) { // 쇠막대기
                    st.pop();
                    result++;
                }
            }
        }
        System.out.print(result);
    }
}

/* 풀이 방법 - 스택(수식의 괄호 쌍)
1. '('은 무조껀 push
2. ')'는 레이저와 쇠막대기로 구분
2-1. st.peek()의 index가 현재 index 바로 이전(인접한 쌍)이라면 -> 레이저 -> 레이저 저장
2-2. 인접한 쌍이 아니라면 -> 쇠막대기 -> 레이저 위치를 확인하여 쇠막대기 조각 개수를 저장

- 주의점
시간이 1초이므로 자바 기준 연산량이 약 1~2억 이하여야 함
아래 코드는 O(n^2)이므로 시간 초과
*/

// 구현 시간: 30분
// O(n^2)
// public class Main {
//     public static void main(String[] args) throws IOException{

//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         Stack<int[]> st = new Stack<>();

//         Set<Integer> rager = new HashSet<>();

//         int result = 0;
//         char[] input = br.readLine().toCharArray(); // <= 100,000
//         // 레이저 + 막대기 최대 50,000개 -> 이중 반복문 돌리면 25000 * 25000 = 6.25억 -> 시간 초과
//         // O(n): n = 100,000
//         for (int i = 0; i < input.length; i++) {
//             if (input[i] == '(') {
//                 st.push(new int[] {input[i], i});
//             } else {
//                 if (!st.isEmpty() && st.peek()[1] == i-1) { // 레이저
//                     // 레이저의 위치 저장
//                     st.pop();
//                     rager.add(i-1); // 레이저 위치
//                 }
//                  else if (!st.isEmpty()) { // 쇠막대기
//                     // 레이저의 위치와 쇠막대기의 위치를 비교하여 조각 개수를 구하고 result에 +
//                     // start index부터 레이저 탐색
//                     int start = st.pop()[1];
//                     int slice = 1;
//                     // O(m): m = 100,000
//                     for (int j = start+1; j < i-1; j++) {
//                         if (rager.contains(j)) slice++;
//                     }
//                     result += slice;
//                 }
//             }
//         }
//         System.out.print(result);
//     }
// }