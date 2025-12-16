package random;

/**
 * 한 문자: 지게차(외부 연결 필수O)
 * 두 문자 이상: 크레인(외부 연결 필수X)
 * 남은 컨테이너 수 return
**/

/** 조건
 * 컨테이너 크기: 최대 50x50
 * 출고 요청 크기: 최대 100
**/

/** 풀이 방법
 * 외부 노출 검증: 상하좌우 검증 -> 각 지점 BFS 탐색 (picked인 부분만 이동 가능) -> 끝 지점 도달 시 해당 컨테이너 외부 연결
 * 시간 복잡도: 250 * 
**/
import java.util.*;

class _388353_지게차와_크레인 {
    static String[][] containers;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int result = 0;
    public int solution(String[] storage, String[] requests) {
        
        containers = new String[storage.length][storage[0].length()];

        for (int i = 0; i < storage.length; i++) {
            String[] words = storage[i].split("");
            for (int j = 0; j < words.length; j++) {
                containers[i][j] = words[j];
            }
        }
        
        for (int i = 0; i < requests.length; i++) {
            if (requests[i].length() == 2) {
                String[] sp = requests[i].split("");
                crane(sp[0]);
                continue;
            }
            
            boolean[][] pick = new boolean[containers.length][containers[0].length];
            for (int j = 0; j < containers.length; j++) {
                for (int k = 0; k < containers[j].length; k++) {
                    if (containers[j][k].equals(requests[i])) {
                        if (bfs(requests[i], j, k)) {
                            pick[j][k] = true;
                        }
                    }
                }
            }
            for (int j = 0; j < pick.length; j++) {
                for (int k = 0; k < pick[j].length; k++) {
                    if (pick[j][k]) {
                        containers[j][k] = "picked";
                        result += 1;
                    }
                }   
            }
        }
        System.out.println(result);
        return (storage.length * storage[0].length()) - result;
    }
    
    public void crane(String target) {
        for (int i = 0; i < containers.length; i++) {
            for (int j = 0; j < containers[i].length; j++) {
                if (containers[i][j].equals(target)) {
                    containers[i][j] = "picked";
                    result += 1;
                }
            }
        }
    }
    
    public boolean bfs(String target, int x, int y) {
        boolean[][] visited = new boolean[containers.length][containers[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        
        
        while (!q.isEmpty()) {
            
            // 현재 위치
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];
            
            // 상하좌우 탐색 -> 길 있는지 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 0 || nx >= containers.length || ny < 0 || ny >= containers[0].length) {
                    return true;
                }
                
                if (containers[nx][ny].equals("picked") && !visited[nx][ny]) {
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return false;
    }
}