package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 입력 값과 출력 값을 구분하지 않고 cloud[][]에 표현
 */
public class _10709_기상캐스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] cloud = new int[h][w];
        for (int i = 0; i < h; i++) {
            int cnt = -1;
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                char now = line.charAt(j);
                if (now == 'c') {
                    cloud[i][j] = 0;
                    cnt = 1;
                } else if (cnt > 0) cloud[i][j] = cnt++;
                else cloud[i][j] = cnt;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cloud.length; i++) {
            for (int j = 0; j < cloud[i].length; j++) {
                sb.append(cloud[i][j]);
                if (j < cloud[i].length - 1) {
                    sb.append(" "); // 요소 사이에 공백 추가
                }
            }
            sb.append("\n"); // 각 행이 끝날 때 줄바꿈 추가
        }
        System.out.println(sb.toString());
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                if (j == w - 1)
//                    System.out.println(result[i][j]);
//                else
//                    System.out.print(result[i][j] + " ");
//            }
//        }
    }
}

/**
 * 입력 값과 출력 값을 구분해서 구현
 */
//public class _10709_기상캐스터 {
//    public static void main(String [] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int h = Integer.parseInt(st.nextToken());
//        int w = Integer.parseInt(st.nextToken());
//
//        char[][] cloud = new char[h][w];
//        for (int i = 0; i < h; i++) {
//            String line = br.readLine();
//            for (int j = 0; j < w; j++)
//                cloud[i][j] = line.charAt(j);
//        }
//
//        int[][] result = new int[h][w];
//        for (int i = 0; i < h; i++) {
//            boolean hasCloud = false;
//            int cnt = -1;
//            for (int j = 0; j < w; j++) {
//                if (cloud[i][j] == 'c') {
//                    cnt = 0;
//                    result[i][j] = cnt;
//                    hasCloud = true;
//                } else {
//                    if (hasCloud) {
//                        result[i][j] = ++cnt;
//                    } else {
//                        result[i][j] = cnt;
//                    }
//                }
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result[i].length; j++) {
//                sb.append(result[i][j]);
//                if (j < result[i].length - 1) {
//                    sb.append(" "); // 요소 사이에 공백 추가
//                }
//            }
//            sb.append("\n"); // 각 행이 끝날 때 줄바꿈 추가
//        }
//        System.out.println(sb.toString());
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                if (j == w - 1)
//                    System.out.println(result[i][j]);
//                else
//                    System.out.print(result[i][j] + " ");
//            }
//        }
//    }
//}
