package HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 채팅방 입장할 때 각 유저는 첫 채팅은 무조껀 이모티콘 사용
 * 이모티콘 사용 횟수 구하기
 * ENTER: 채팅방 입장
 * 나머지: 닉네임(숫자 or 영어 대소문자)
 * 
 */
public class _25192_인사성_밝은_곰곰이 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>(); // 이모티콘 저장 Set
        int result = 0; // 이모티콘 사용 횟수

        // "ENTER"가 입력되면 전까지 입력된 이모티콘의 수를 세서 result에 저장장
        for (int i = 0; i < n; i ++) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
                result += hs.size();
                hs.clear();
                continue;
            }
            hs.add(input);
        }

        // 순회 후 남은 이모티콘 사용 횟수를 result에 더해서 출력력
        System.out.println(result + hs.size());
    }
}