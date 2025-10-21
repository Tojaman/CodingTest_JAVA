import java.util.*;

/* 문제 요약
이동한 거리 구하기 (중복X)
좌표 평면(+-5, +-5) 밖으로 가는 명령은 무시
*/

/* 풀이 방법
- 방문 표시
    - (5, 5) 영역이므로 2차원 배열 공간은 [11][11]로 해야 한다.
    - 상, 하, 좌, 우 방향에서 오는 간선은 방문처리 해야 하므로 3차원 배열로 설정한다.

- 로직
    - 시작지과 목적지 사이 방문 여부를 확인한다.
    - 만약 방문하지 않았다면 양방향 방문 처리를 한다. <- 핵심(양방향)
참고로 (5, 5)를 넘어가면 안되기 때문에 그것도 검증해야 됨
*/

class Solution {
    // 0  ~ 11, (5, 5)에서 시작
    boolean[][][] visited = new boolean[11][11][5]; // 4는 방향
    int x = 5;
    int y = 5;
    int answer = 0;
    
    public int solution(String dirs) {
        for (char direction : dirs.toCharArray()) {
            switch(direction) {
                case 'U':
                    move(0, 1, 1, 2);
                    break;
                case 'D':
                    move(0, -1, 2, 1);
                    break;
                case 'L':
                    move(-1, 0, 3, 4);
                    break;
                case 'R':
                    move(1, 0, 4, 3);
                    break;
            }
        }
        return answer;
    }
    
    public void move(int mx, int my, int dr1, int dr2) {
        int nextX = x + mx;
        int nextY = y + my;
        
        // 시작점, 도착점 모두 방문 이력이 없어야 됨
        if (nextX >= 0 && nextX < 11 && nextY >= 0 && nextY < 11) {
            if (!visited[nextX][nextY][dr1]) {
                // 양방향 방문 처리
                visited[nextX][nextY][dr1] = true;
                visited[x][y][dr2] = true;
                answer++;
            }
            x = nextX;
            y = nextY;
        }     
    }
}

/*입력값 쪼갤 때 이렇게 했는데 이건 String 객체가 새로 생겨서 비효율적임 */
// String[] directions = dirs.split("");
// for (String direction : directions) {
//     switch(direction) {
//         case "U":
//             move(0, 1, 1, 2);
//             break;
//         case "D":
//             move(0, -1, 2, 1);
//             break;
//         case "L":
//             move(-1, 0, 3, 4);
//             break;
//         case "R":
//             move(1, 0, 4, 3);
//             break;
//     }
// }