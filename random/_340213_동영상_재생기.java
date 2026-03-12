import java.util.*;

// 2차

/* 문제 해석
10초 전으로 이동("prev"), 10초 후로 이동("next" )
오프닝 건너뛰기: op_start ≤ 현재 재생 위치 ≤ op_end 순간 next
최종 위치 "mm:ss" 형식 반환
*/

/* 제한사항
0 ~ 59, 60이상은 조정
한자리 -> 두자리
video_len 넘어가지 않게, 0 이전 X 설정
*/
// 1시간 20분;;;
class Solution {
    static int len = 0;
    // 동영상 길이, 기능 수행 직전 위치, 오프닝 시작, 종료, 입력(기능)
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        len = changeToInt(video_len);
        int now = changeToInt(pos);
        int start = changeToInt(op_start);
        int end = changeToInt(op_end);

        // 오프닝 건너뛰기는 "자동으로" 이동이기 때문에 현재 위치가 오프닝이면 이동해야 해서 앞뒤로 필요
        for (String command : commands) {
            // 오프닝 건너뛰기
            if (now >= start && now <= end) now = end;
            
            
            switch (command) {
                case "next":
                    now = next(now);
                    break;
                case "prev":
                    now = prev(now);
                    break;
            }
            if (now >= start && now <= end) now = end;
        }
        return result(now);
    }
    
    public int next(int time) {
        int moved = time+10;
        if (isOverLen(moved)) {
            return len;
        }
        return moved;
    }

    public int prev(int time) {
        int moved = time-10;
        if (isOverLen(moved)) {
            return 0;
        }
        return moved;
        
    }
    public boolean isOverLen(int time) {
        if (time < 0 || time > len) {
            return true;
        }
        return false;
        
    }

    public int changeToInt(String now) {
        String[] time = now.split(":");
        return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
    }
    
    public String result(int now) {
        int h = now/60;
        int m = now%60;
        StringBuilder sb = new StringBuilder();
        if (h < 10) {
            sb.append(0).append(h);
        } else {
            sb.append(h);
        }
        sb.append(":");
        if (m < 10) {
            sb.append(0).append(m);
        } else {
            sb.append(m);
        }
        
        return sb.toString();
        
    }
}


// 1차 (분, 초단위로 함)

/* 문제 해석
10초 전으로 이동("prev"), 10초 후로 이동("next" )
오프닝 건너뛰기: op_start ≤ 현재 재생 위치 ≤ op_end 순간 next
최종 위치 "mm:ss" 형식 반환
*/

/* 제한사항
0 ~ 59, 60이상은 조정
한자리 -> 두자리
video_len 넘어가지 않게, 0 이전 X 설정
*/
class Solution {
    static int len = 0;
    // 동영상 길이, 기능 수행 직전 위치, 오프닝 시작, 종료, 입력(기능)
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        len = changeToInt(video_len);
        int now = changeToInt(pos);
        int start = changeToInt(op_start);
        int end = changeToInt(op_end);

        
        for (String command : commands) {
            // 오프닝 건너뛰기 
            if (command.equals("next")){
                if (now >= start && now <= end) { 
                    now = end;
                }
            }
            
            switch (command) {
                case "next":
                    now = next(now);
                    if (now >= start && now <= end) { 
                       now = end;
                    }
                    break;
                case "prev":
                    now = prev(now);
                    break;
            }
        }
        return result(now);
    }
    
    public int next(int time) {
        int moved = time+10;
        if (isOverLen(moved)) {
            return len;
        }
        return moved;
    }

    public int prev(int time) {
        int moved = time-10;
        if (isOverLen(moved)) {
            return 0;
        }
        return moved;
        
    }
    public boolean isOverLen(int time) {
        if (time < 0 || time > len) {
            return true;
        }
        return false;
        
    }

    public int changeToInt(String now) {
        String[] time = now.split(":");
        return Integer.parseInt(time[0])*100 + Integer.parseInt(time[1]);
    }
    
    public String result(int now) {
        int h = now/100;
        int m = now%100;
        StringBuilder sb = new StringBuilder();
        if (h < 10) {
            sb.append(0).append(h);
        } else {
            sb.append(h);
        }
        sb.append(":");
        if (m < 1) {
            sb.append(0).append(m);
        } else {
            sb.append(m);
        }
        
        return sb.toString();
        
    }
}