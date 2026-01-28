package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 풀이 방법
오름차순이면, 다음 재귀에 시작지점을 현재 설정된 값+1로 넘겨주면 된다.
*/
public class _15650_N과M2 {
    static int[] arr;
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        backtracking(0, 1);

        System.out.print(sb.toString().trim());
    }

    static void backtracking(int index, int start) {

        // 탈출 조건 (길이가 m인 수열이 만들어졌다면)
        if (index == m) {
            for (int i = 0; i < arr.length; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }

        // 재귀로 순열 만들기
        for (int i = start; i <= n; i++) {
            arr[index] = i;
            backtracking(index+1, i+1);
        }
    }
}

/* 풀이 방법
m길이의 수열을 중복없이 만든다.
오름차순인지 검증한다.
*/
/*
public class _15650_N과M2 {
    static int[] arr;
    static boolean[] visited;
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n+1];

        backtracking(0);

        System.out.print(sb.toString().trim());
    }

    static void backtracking(int index) {

        // 탈출 조건 (길이가 m인 수열이 만들어졌다면)
        if (index == m) {
            if (orderd()) {
                for (int i = 0; i < arr.length; i++) sb.append(arr[i]).append(" ");
                sb.append("\n");
            }
            return;
        }

        // 재귀로 순열 만들기
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                arr[index] = i;
                visited[i] = true; // 사용 처리
                backtracking(index+1);
                visited[i] = false; // 뒤로 한 칸 가면서 이전에 사용했던 값 미사용 처리
            }
        }
    }

    static boolean orderd() {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
}
*/