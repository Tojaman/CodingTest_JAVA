import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구현 시간: 30분 아오
public class _11328_Strfry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        StringBuilder sb = new StringBuilder();

        // 두 문자열의 각각의 char가 포함되어있는가?
        int n = Integer.parseInt(br.readLine()); // < 1001
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            int[] result = new int[26];
            st =  new StringTokenizer(br.readLine());
            char[] ones = st.nextToken().toCharArray();
            char[] twos = st.nextToken().toCharArray();

            if (ones.length != twos.length) {
                System.out.println("Impossible");
                // sb.append("Impossible\n");
                continue;
            }
            for (char one : ones)
                result[one-'a']++;
            for (char two : twos)
                result[two-'a']--;
            System.out.println(isPossible(result));
        }
    }

    public static String isPossible(int[] result) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                return "Impossible";
            }
        }
        return "Possible";
    }


    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     // String result = "";
    //     // int[] result = new int[26];
    //     int result = 0;
    //     StringBuilder sb = new StringBuilder();

    //     // 두 문자열의 각각의 char가 포함되어있는가?
    //     int n = Integer.parseInt(br.readLine()); // < 1001
    //     StringTokenizer st;
    //     for (int i = 0; i < n; i++) {
    //         result = 0;
    //         st =  new StringTokenizer(br.readLine());
    //         char[] one = st.nextToken().toCharArray();
    //         char[] two = st.nextToken().toCharArray();

    //         if (one.length != two.length) {
    //             sb.append("Impossible\n");
    //             continue;
    //         }

    //         for (int j = 0; j < one.length; j++) {
    //             for (int k = 0; k < two.length; k++) {
    //                 if (one[j] == two[k]) {
    //                     result++;
    //                     break;
    //                 }
    //             }
    //         }
    //         if (result == one.length) {
    //             sb.append("Possible\n");
    //         } else {
    //             sb.append("Impossible\n");
    //         }
    //     }
    //     System.out.println(sb.toString().trim());
    // }
}
