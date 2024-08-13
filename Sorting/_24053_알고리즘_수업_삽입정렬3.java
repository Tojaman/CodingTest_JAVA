package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _24053_알고리즘_수업_삽입정렬3 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st1.nextToken());
            b[i] = Integer.parseInt(st2.nextToken());
        }

        insert_sort(a, b);

    }

    public static void insert_sort(int[] a, int[] b) {
        if (Arrays.equals(a, b)) {
            System.out.println(1);
            return;
        }
        for (int i = 1; i < a.length; i++) {
            int loc = i-1;
            int tmp = a[i];

            while (loc >= 0 && a[loc] > tmp) {
                a[loc+1] = a[loc];
                loc--;
                if (Arrays.equals(a, b)) {
                    System.out.println(1);
                    return;
                }

            }
            if (loc + 1 != i) {
                a[loc + 1] = tmp;
                if (Arrays.equals(a, b)) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}
