import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st2.nextToken());
        }

        selection_sort(a, k);
    }

    public static void selection_sort(int[] a, int k) {
        int cnt = 0;
        for (int i = a.length-1; i > 0; i--) {
            // maxidx 찾기
            int maxidx = i;
            for (int j = i-1; j >= 0; j--) {
                if (a[j] > a[maxidx]) {
                    maxidx = j;
                }
            }

            if (maxidx != i) {
                int tmp = a[maxidx];
                a[maxidx] = a[i];
                a[i] = tmp;
                cnt++;
                if (cnt == k) {
                    System.out.println(a[maxidx] + " " + a[i]);
                    return;
                }
            }
        }
        if (cnt < k) {
            System.out.println(-1);
        }
    }
}