package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 비슷한 문제에서 같은 실수 반복
 * - 매 순간순간 값을 계산해서 저장하면 쉽게 풀 수 있는 문제를 한 번에 계산하려고만 생각해서 못푸는 경우가 많음
 * - 이번 문제도 매 순간마다 시간 계산하면 쉽게 풀리는 문제인데 한번에 풀려고 해서 실패함
 */

public class _2852_NBA_농구 {
    //    static String[] time = new String[3]; // 팀별 시간 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
//        int[] recordTeam = new int[n];
//        String[] recordTime = new String[n];

        int[] score = new int[3];
        int[] time = new int[3];
        int leadingTeam = 0;
        String lastTime = "00:00";
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 팀 번호: 1 or 2
            int team = Integer.parseInt(st.nextToken());
            // 득점 시간: MM:SS 형식
            String currentTime = st.nextToken();

            if (leadingTeam != 0)
                time[leadingTeam] += toSeconds(currentTime) - toSeconds(lastTime);

            score[team]++;
            if (score[1] > score[2]) {
                leadingTeam = 1; // 팀 1이 리드
            } else if (score[1] < score[2]) {
                leadingTeam = 2; // 팀 2가 리드
            } else {
                leadingTeam = 0; // 동점
            }

            lastTime = currentTime; // 마지막 득점 시간 갱신

        }
        // 마지막 득점 이후 남은 시간 처리
        if (leadingTeam != 0) {
            time[leadingTeam] += toSeconds("48:00") - toSeconds(lastTime);
        }

        System.out.println(toTime(time[1]));
        System.out.println(toTime(time[2]));
    }

    public static int toSeconds(String time) {
        String[] parts = time.split(":");
        int minute = Integer.parseInt(parts[0]);
        int second = Integer.parseInt(parts[1]);
        return minute * 60 + second;
    }

    public static String toTime(int time) {
        int minute = time / 60;
        int second = time % 60;
        return String.format("%02d:%02d", minute, second);
    }
}

        /** 동점이 되는 순간 이기고 있던 순간의 시간을 계산하도록 구현 -> 실패
         * 현재 동점O -> 이긴 팀 현재 시간 기록 및 점수 추가
         * 현재 동점X -> 동점이 된다면 -> 이기고 있던 팀 시간 측정 및 기록
         *             동점이 되지 않는다면 -> 넘어가기
         */
//        int[] score = new int[3];
//        String[] startTime = new String[3];
//        for (int i = 0; i < 3; i++) {
//            time[i] = "00:00";
//            startTime[i] = "00:00";
//        }
//        int nowTeam = 0;
//        int beforeTeam = -1;
//        for (int i = 0; i < n; i++) {
//
//            if (i == 0) {
//                startTime[recordTeam[i]] = recordTime[i];
//                score[recordTeam[i]] += 1;
//                continue;
//            }
//            if (recordTeam[i] != nowTeam)
//                beforeTeam = nowTeam;
//            nowTeam = recordTeam[i];
//            String nowTime = recordTime[i];
//
//             // 현재 동점 -> 동점 깨짐 -> 시작 시간 기록
//            if (score[1] == score[2]) {
//                startTime[nowTeam] = nowTime;
//                score[nowTeam] += 1;
//            } else {
//                // 동점이 되는 경우
//                if (score[nowTeam] == (score[beforeTeam] + 1) || (score[nowTeam] +1) == score[beforeTeam]) {
//                    time[beforeTeam] = calTime(nowTime, startTime[beforeTeam]);
//                }
//                score[nowTeam] += 1;
//            }
//            if (i + 1 == n && score[1] != score[2]) {
//                if (score[1] > score[2]) {
//                    time[1] = calTime("48:00", startTime[1]);
//                } else {
//                    time[2] = calTime("48:00", startTime[2]);
//                }
//            }
//        }


//    }

//    public static String calTime(String nowTime, String beforeTime) {
//        // 현재 시간 - 이전 시간
//        int now = toSeconds(nowTime);
//        int before = toSeconds(beforeTime);
//        return toTime(now - before);
//    }


//}
