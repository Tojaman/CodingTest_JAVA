import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int m = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] <= k) //
                m = i;

        }

        int cnt = 0;
        for (int j = m; j >= 0; j--) {
            if (k >= arr[j]) {
                cnt += k / arr[j];
                k = k % arr[j];
            }
        }
        System.out.println(cnt);
    }
}