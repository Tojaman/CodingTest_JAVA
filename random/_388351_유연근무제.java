import java.util.*;

/* 문제 해석
지각 안한 사람 수 구하기
월~금, <=희망+10
요일: startday%7 (1~6, 0)
*/
// 1시간;; -> 테스트 케이스 구성과 조건 잘 봐야 댐
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int n = schedules.length; // 직원 수 (<= 1000)
        int result = 0;
        // O(nm): 700만 -> 가능
        for (int i = 0; i < n; i++) {
            int schedule = getSchedule(schedules[i]);
            boolean isLate = false;

            for (int j = 0; j < timelogs[i].length; j++) {
                int day = (startday + j) % 7; // 오늘 요일
                if (day >= 1 && day <= 5) { // 평일
                    if (timelogs[i][j] > schedule) { // 지각
                        isLate = true;
                    }
                }
            }
            if (!isLate) {
                result++;
            }
        }
        return result;
    }
    
    // 시간 조정
    public int getSchedule(int schedule) {
        schedule += 10;
        if (schedule % 100 >= 60) { // 61분, 65분 ... (1265)
            // 시간+1, 분%60
            int h = schedule / 100 + 1;
            int m = schedule % 100 - 60;
            schedule = h*100 + m;
        }
        return schedule;
    }
}

// 2차
// 조건에 1 ≤ startday ≤ 7라고 적혀 있는데, 내 맘대로 1~6, 0(일)로 정의해서 테케랑 안맞음

/* 문제 해석
지각 안한 사람 수 구하기
월~금, <=희망+10
요일: startday%7 (1~6, 0)
*/
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int n = schedules.length; // 직원 수 (<= 1000)
        int result = 0;
        // O(nm): 700만 -> 가능
        for (int i = 0; i < n; i++) {
            int schedule = getSchedule(schedules[i]);
            boolean isLate = false;
            int day = startday%7; // 1 ~ 6, 0
            
            for (int j = 0; j < timelogs[i].length; j++) {
                if (day >= 1 && day <= 5) { // 평일
                    if (timelogs[i][j] > schedule) { // 지각
                        isLate = true;
                    }
                }
                day++;
            }
            if (!isLate) {
                result++;
            }
        }
        return result;
    }
    
    // 시간 조정
    public int getSchedule(int schedule) {
        schedule += 10;
        if (schedule % 100 >= 60) { // 61분, 65분 ... (1265)
            // 시간+1, 분%60
            int h = schedule / 100 + 1;
            int m = schedule % 100 - 60;
            schedule = h*100 + m;
        }
        return schedule;
    }
}

// 1차

/* 문제 해석
지각 안한 사람 수 구하기
월~금, <=희망+10
요일: startday%7 (1~6, 0)
*/
// 15분
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int n = schedules.length; // 직원 수 (<= 1000)
        int result = 0;
        // O(nm): 700만 -> 가능
        for (int i = 0; i < n; i++) {
            int schedule = schedules[i];
            boolean isLate = false;
            int day = startday%7; // 1 ~ 6, 0
            
            for (int j = 0; j < timelogs[i].length; j++) {
                if (day >= 1 && day <= 5) { // 평일
                    if (timelogs[i][j] > schedule) { // 지각
                        isLate = true;
                    }
                }
                day++;
            }
            if (!isLate) {
                result++;
            }
        }
        return result;
    }
}