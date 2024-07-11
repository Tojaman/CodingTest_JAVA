import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(a, 0, n-1, k);
        if (cnt == k) {
            for (int num : a) {
                System.out.print(num + " ");
            }
        }
        else {
            System.out.println(-1);
        }
    }

    public static void merge_sort(int[] a, int left, int right, int k) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(a, left, mid, k);
            if (cnt == k) {
                return;
            }
            merge_sort(a, mid + 1, right, k);
            if (cnt == k) {
                return;
            }
            merge(a, left, mid, right, k);
            if (cnt == k) {
                return;
            }
        }
    }


    public static void merge(int[] a, int left, int mid, int right, int k) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                tmp[t++] = a[i++]; // tmp <- left
            }
            else { // a[i] > a[j]
                tmp[t++] = a[j++]; // tmp <- mid+1
            }
        }

        // 왼쪽 배열 부분이 남은 경우
        while (i <= mid) {
            tmp[t++] = a[i++];
        }
        // 오른쪽 배열 부분이 남은 경우
        while (j <= right) {
            tmp[t++] = a[j++];
        }
        i = left;
        t = 0;
        // 최종적으로 정렬된 배열을 a[]에 옮김
        while (i <= right) {
            a[i++] = tmp[t++];
            cnt++;
            if (cnt == k) {
                return;
            }
        }
    }
}