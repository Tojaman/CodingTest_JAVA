package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2343_기타레슨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] lecs = new int[n];
        for (int i = 0; i < n; i++)
            lecs[i] = Integer.parseInt(st.nextToken());

        int low = Arrays.stream(lecs).max().getAsInt();
        int high = Arrays.stream(lecs).sum();
        while (low <= high) {
            int mid = (low+high) / 2;

            int sum = 0;
            int cnt = 1;
            for (int lec : lecs) {
                if (sum + lec <= mid) sum += lec;
                else {
                    cnt += 1;
                    sum = lec;
                }
            }

            if (cnt <= m) high = mid -1;
            else low = mid + 1;
        }
        System.out.println(low);
    }
}