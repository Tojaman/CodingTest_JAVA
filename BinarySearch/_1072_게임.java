import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1072_게임 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long z = (y * 100) / x;

        // z = (y+a / x+a) * 100
        // #z = (y+a / x+a) * 100
        
        // 승률이 99%, 100%일 경우 승률이 더 높아질 수 없음
        if (z >= 99) System.out.println(-1);
        else System.out.println(lowerBound(1, 1000000000, x, y, z));
    }

    public static long lowerBound(long left, long right, long x, long y, long z) {
        if (left >= right) return right;
        long mid = (left + right) / 2;
        long newZ = (y +mid) * 100 / (x + mid);

        if (z < newZ) {
            return lowerBound(left, mid, x, y, z);
        } else { // z == newZ (같은 경우는 있을 수 없음)
            return lowerBound(mid + 1, right, x, y, z);
        }
    }
}
