package HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 곰곰 이모티콘 사용 횟수
 * ENTER: 입장 / 외: 닉네임
 * 첫 채팅은 이모티콘 -> 첫 채팅을 친 사람의 수를 구하시오
 */

/** HashSet 메소드
 * add(), remove(), contains()
 * equals(): HashSet 객체 끼리 비교(순서 상관X)
 * size(): 크기
 * clear(): 전부 삭제
 */
public class _25192_인사성_밝은_곰곰이 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * ENTER가 나오면 이후에 나오는 닉네임 수 카운팅
         * 이때 닉네임이 두 번 이상 나올 경우 카운팅하지 X
         */
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String chat = br.readLine();
            if (chat.equals("ENTER")) {
                cnt += hs.size(); // 외우기
                hs.clear(); // 외우기
                continue;
            }
            if (!hs.contains(chat))
                hs.add(chat);
        }
        System.out.println(cnt + hs.size());
    }
}