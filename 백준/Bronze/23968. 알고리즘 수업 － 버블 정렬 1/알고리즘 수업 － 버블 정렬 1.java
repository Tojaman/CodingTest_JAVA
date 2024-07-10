import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());

        int[] a = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st2.nextToken());
        }

        buble_sort(a, k);


    }

    public static void buble_sort(int[] a, int k) {
        int cnt = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length -1 -i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    cnt++;
                    if (cnt == k)
                        System.out.println(a[j] + " " + a[j+1]);
                }
            }
        }
        if (cnt < k)
            System.out.println(-1);
    }
}