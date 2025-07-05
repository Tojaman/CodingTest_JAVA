import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

/** 조건
 * -10억 <= Xi <= +10억
 * 1 <= N <= 1,000,000
 */
/** 풀이 방법
 * 1. X 값들의 중복을 제거하고 정렬한다.
 *   1-1. 중복 제거: HashSet으로 중복 제거한 값을 구함
 *   1-2. HashSet에 있는 값을 배열로 옮긴 후 정렬(Iterator<Integer> 변수명 = hs.iterator();)
 * 2. X 값들을 하나하나 순환하며 1에서 구한 값들로 X'i를 구한다.
 *   2-1. 이진 탐색을 이용하며 구함(O(nlogm))
 */

// 시간 복잡도: O(nlogn) + O(nlogm)
public class _18870_좌표_압축 {
    static int[] sortedX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] X = new int[n];
        HashSet<Integer> hs = new HashSet<>();
        // O(n)
        for (int i = 0; i < n; i++) {
            X[i] = Integer.parseInt(st.nextToken());
            hs.add(X[i]);
        }
        
        sortedX = new int[hs.size()];
        int j = 0;
        for (int set : hs) {
            sortedX[j++] = set;
        }

        // O(nlogn)
        Arrays.sort(sortedX);

        StringBuilder sb = new StringBuilder();
        // O(nlogm)
        for (int i = 0; i < n; i++) {
            int cnt = binarySearch(0, sortedX.length-1, X[i]);
            sb.append(cnt + " ");
        }

        System.out.print(sb.toString().trim());
    }

    public static int binarySearch(int left, int right, int target) {

        int midIndex = (left + right) / 2;
        int mid = sortedX[midIndex];

        if (left > right) return left;
        if (target > mid) {
            return binarySearch(midIndex+1, right, target);
        } else {
            return binarySearch(left, midIndex-1, target);
        }
    }
}
