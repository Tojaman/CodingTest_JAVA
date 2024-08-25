package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] liqs = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            liqs[i] = Integer.parseInt(st.nextToken());

        int low = 0;
        int high = n-1;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (low < high) {
            int mid = liqs[low] + liqs[high];
            if (Math.abs(mid) < Math.abs(min)) {
                min = mid;
                result[0] = liqs[low];
                result[1] = liqs[high];
            }

            if (mid > 0) high -= 1;
            else low += 1;
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
