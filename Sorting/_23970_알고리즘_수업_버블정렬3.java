package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _23970_알고리즘_수업_버블정렬3 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st1.nextToken());

        int[] b = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            b[i] = Integer.parseInt(st2.nextToken());

        if (Arrays.equals(a, b))
            System.out.println(1);
        else
            buble_sort(a, b);
    }

    public static void buble_sort(int[] a, int[] b) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length -1 -i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    if (a[j] == b[j] && a[j+1] == b[j+1] && Arrays.equals(a, b)) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
