package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 내기 기간: 1일 ~ 14일 총 14일(현금 + 14일 주가*주식 수)
public class _20546_기적의_매매법 {
    static int[] price = new int[14];
    static int joon_stock = 0;
    static int sung_stock = 0;
    static int joon_cash = 0;
    static int sung_cash = 0;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        joon_cash = Integer.parseInt(br.readLine());
        sung_cash = joon_cash;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++)
            price[i] = Integer.parseInt(st.nextToken());

        for (int day = 0; day < 14; day++) {
            joon(day);
            sung(day);
        }

        int joon = joon_cash + price[13] * joon_stock;
        int sung = sung_cash + price[13] * sung_stock;
        if (joon > sung) System.out.println("BNP");
        if (sung > joon) System.out.println("TIMING");
        if (joon == sung) System.out.println("SAMESAME");
    }

    /** 준현
     * 갖고 있는 현금으로 가능한 많은 주식을 매수
     */
    public static void joon(int day) {
        if (price[day] <= joon_cash) {
            int stocksToBuy = joon_cash / price[day];
            joon_stock += stocksToBuy;
            joon_cash -= price[day] * stocksToBuy;
        }
    }

    /** 성민
     * 3일 연속 가격 전일 대비 상승 -> 다음날 가격 하락 -> 전량 매도
     * 3일 연속 가격 전일 대비 하락 -> 다음날 가격 상승 -> 즉시 매수
     */
    public static void sung(int day) {
        if (day > 2) {
            // 3일 연속 상승
            if (price[day] > price[day - 1] && price[day - 1] > price[day - 2] && price[day - 2] > price[day - 3]) {
                if (sung_stock > 0) {
                    sung_cash += price[day] * sung_stock;
                    sung_stock = 0;
                }
            }
            // 3일 연속 하락
            if (price[day] < price[day - 1] && price[day - 1] < price[day - 2] && price[day - 2] < price[day - 3]) {
                if (sung_cash >= price[day]) {
                    int stocksToBuy = sung_cash / price[day];
                    sung_stock += stocksToBuy;
                    sung_cash -= price[day] * stocksToBuy;
                }
            }
        }
    }
}
