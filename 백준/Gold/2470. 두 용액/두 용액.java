import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] liquid = new int[n];
        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquid);

        int left = 0;
        int right = liquid.length - 1;
        int before = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while (left < right) {
            if (Math.abs(liquid[left] + liquid[right]) < before) {
                before = Math.abs(liquid[left] + liquid[right]);
                start = liquid[left];
                end = liquid[right];
            }
            else { // 이전 값보다 0에서 멀다면
                if (liquid[left] + liquid[right] > 0) { // 양수
                    right--;
                    
                }
                else { // 음수
                    left++;
                }

            }
        }
        System.out.println(start + " " + end);
    }
}
