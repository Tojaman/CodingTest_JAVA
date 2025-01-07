package HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _19583_싸이버개강총회 {
    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int wait = calTime("00:00"); // 대기 시작 시간
        int s = calTime(st.nextToken()); // 개강총회 시작 시간
        int e = calTime(st.nextToken()); // 개강총회 끝난 시간
        int q = calTime(st.nextToken()); // 개강총회 스트리밍 끝난 시간

        // 저장 형식: HashSet<닉네임>

        /** 풀이 로직
         * 입력 받은 시간을 분으로 계산한다.
         * 첫 종료 시간 채팅을 기준으로 출석 시간 / 종료 시간 두 구간을 나눈다.
         * 출석 시간에 채팅을 입력한 인원을 Set에 삽입한다.
         * 종료 시간 이후 채팅을 입력한 인원의 key를 탐색하여 만약 있다면 해당 인원을 Set에서 제거하고 출석 인원(result)을 카운팅한다.
         * 모든 채팅 검색이 끝나고 Set의 size()를 출력한다.
         */ 
        
        HashSet<String> hs = new HashSet<>();
        int result = 0;
        while(true) {
            String input = br.readLine();
            
            // 종료 조건(이거 못떠올려서 다른 사람 풀이 봄)
            if (input == null || input.equals("")) break;

            // 객체 메서드를 호출하기 전에 그 객체가 null인지 반드시 먼저 확인해야 함
            // 만약 먼저확인하지 않으면 참조할 객체가 메모리상에 존재하지 않으므로 "NullPointerException"가 뜸
            // if (input.equals("") || input == null) break;

            st = new StringTokenizer(input);
            int time = calTime(st.nextToken());
            String name = st.nextToken();

            // 출석 점검(대기 ~ 시작)
            if (wait <= time && time <= s) {
                hs.add(name);
            }
            // 종료 점검(개강총회 끝 ~ 스트리밍 끝)
            else if (e <= time && time <= q) {
                if (hs.contains(name)) {
                    hs.remove(name); // 중복 카운트 예외처리
                    result++;
                }
            }
        }
        System.out.println(result);

    }

    public static int calTime(String time) {
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]); 
        int minute = Integer.parseInt(times[1]);

        return (hour * 60) + minute;
    }
    
}
