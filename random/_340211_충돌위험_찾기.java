package random;

import java.util.*;
// [PCCP 기출문제] 3번 / 충돌위험 찾기

/* 문제 해석
x대 로봇이 동시에 최단 경로 이동
최단 경로가 여러개일 경우 r(행) 좌표 우선
만약 같은 위치에 2대 이상 모인다면 충돌 -> 횟수 구하기
points[i][t]: 운송 목적지 (i는 목적지 위치, t는 2차원 배열에서의 위치)
routes[i][t]: 각 로봇의 운송 경로 (i번째 로봇은 t1에서 t2, t3, ..., tn까지 운송해야 함)
*/

/* 제한 사항
points[n=100][2]: {100, 100}
routes[x=100][m=100]
*/

/* 풀이 방법
1. routes 순회하면서 각 로봇 한 경로씩 이동 (장애물 없으니깐 BFS 필요 없고 행 이동 -> 열 이동)
1-1. 각 로봇의 이동 경로를 기록 ((HashMap)<Key: 시간:위치, Value: +1>)
2. 이동 경로(HashMap)를 순회하며 같은 시점에 같은 위치에 있는 경우 찾아서 카운팅
3. 충돌 횟수 반환
*/

/* 스스로 못찾은 부분
String key = ++time + ":" + ++curCol + "," + curRow;
위 코드를 초반에 String key = ++time + ":" + ++curCol + curRow;로 설정함.
이로 인해 (1, 23) 과 (12, 3)인 경우 둘 다 문자열이 "0:123" 형태가 되어 구분이 안되는 문제가 있었음
*/

// 풀이 시간: 2시간 30분
class Solution {
    static Map<String, Integer> visited = new HashMap<>();
    static int[][] map = new int[101][101];
    
    // points: 2차원 배열 좌표 / routes: 로봇 이동 경로
    public int solution(int[][] points, int[][] routes) {
        int result = 0;
        
        for (int[] route : routes) {
            int time = 0;
            String startKey = time + ":" + points[route[0]-1][0] + points[route[0]-1][1];
            visited.put(startKey, visited.getOrDefault(startKey, 0)+1);
            
            for (int i = 0; i < route.length-1; i++) {
                time = move(route[i]-1, route[i+1]-1, points, time);
            }
        }

        // 동일 시점에 중복 위치 있었다면 카운팅
        for (int value : visited.values()) {
            if (value > 1) {
                result++;
            }
        }
        return result;
    }
    
    public int move(int start, int end, int[][] points, int time) {
        int curCol = points[start][0]-1;
        int curRow = points[start][1]-1;
        int endCol = points[end][0]-1;
        int endRow = points[end][1]-1;

        while (curCol != endCol || curRow != endRow) {
            // 행 맞추기 (행 우선)
            if (curCol < endCol) {
                int difference = endCol - curCol;
                for (int i = 0; i < difference; i++) {
                    String key = ++time + ":" + ++curCol + "," + curRow; // 시간,위치
                    visited.put(key, visited.getOrDefault(key, 0)+1);
                }

            } else if (curCol > endCol) {
                int difference =  curCol - endCol;
                for (int i = 0; i < difference; i++) {
                    String key = ++time + ":" + --curCol + "," + curRow; // 시간,위치
                    visited.put(key, visited.getOrDefault(key, 0)+1);
                }
            }
            // 열 맞추기
            if (curRow < endRow) {
                int difference = endRow - curRow;
                for (int i = 0; i < difference; i++) {
                    String key = ++time + ":" + curCol + "," + ++curRow; // 시간,위치
                    visited.put(key, visited.getOrDefault(key, 0)+1);
                }
            } else if (curRow > endRow) {
                int difference = curRow - endRow;
                for (int i = 0; i < difference; i++) {
                    String key = ++time + ":" + curCol + "," + --curRow; // 시간,위치
                    visited.put(key, visited.getOrDefault(key, 0)+1);
                }
            }
        }
        return time;
    }
}