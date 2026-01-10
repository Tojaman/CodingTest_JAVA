import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

// O(m+n)
public class _1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine(); // 길이 <= 100,000
        int n = str.length();

        LinkedList<Character> list = new LinkedList<>();
        // O(n): 100,000
        for (int i = 0; i < n; i++) {
            list.add(str.charAt(i)); // O(1)
        }

        ListIterator<Character> it = list.listIterator();
        for (int i = 0; i < n; i++) {
            it.next(); // O(1)
        }

        int m = Integer.parseInt(br.readLine()); // 1 ≤ M ≤ 500,000
        // O(m)
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char input = st.nextToken().charAt(0);

            switch (input) {
                case 'L':
                    if (it.hasPrevious()) it.previous();
                    break;
                case 'D':
                    if (it.hasNext()) it.next();
                    break;
                case 'B':
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                    break;
                case 'P':
                    char plus = st.nextToken().charAt(0);
                    it.add(plus);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        // O(n)
        for (Character c : list) { // Iterator를 사용하므로 각 요소 접근이 O(1)
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     String str = br.readLine(); // 길이 <= 100,000
    //     int n = str.length();

    //     LinkedList<Character> list = new LinkedList<>();
    //     // O(n): 100,000
    //     for (int i = 0; i < n; i++) {
    //         list.add(i, str.charAt(i));
    //     }

    //     int index = n; // index-1 = 왼쪽 원소 / index+1 = 오른쪽 원소
    //     int m = Integer.parseInt(br.readLine()); // 1 ≤ M ≤ 500,000
    //     // O(m^2): 500,000 * 500,000 == 250,000,000,000(2500억)
    //     // add(index, value), remove(index) 메소드는 모두 index까지 순차 접근해야 하므로 O(m) 비용 발생
    //     // 대충 자바 기준 2억번 연산에 1초라고 가정하면 1250초 -> 22.5분
    //     for (int i = 0; i < m; i++) {
    //         String input = br.readLine();

            // if (input.length() > 1) { // P
            //     char pInput = input.split(" ")[1].charAt(0);
            //     if (index == list.size()) {
            //         list.addLast(pInput);
            //         index++;
            //         continue;
            //     }
            //     list.add(index++, pInput);
            // }

            // if (input.equals("L") && index != 0) { // L
            //     index--;
            // }

            // if (input.equals("D") && index != list.size()) { // D
            //     index++;
            // }

            // if (input.equals("B") && index != 0) { // B
            //     list.remove(index-1);
            //     index--;
            // }
    //     }

    //     for (int i = 0; i < list.size(); i++) {
    //         System.out.print(list.get(i));
    //     }
    // }
// }