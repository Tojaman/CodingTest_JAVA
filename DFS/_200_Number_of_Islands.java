package DFS;

/*
- 문제 유형: 길찾기(군집 개수)
- 시간 복잡도: O(nm)
- 풀이 방법
    이 문제는 길찾기(군집 개수) 유형이다.
    모든 경로를 전부 탐색해야 하므로 공간 복잡도(메모리 사용량)이 적은 DFS 사용
- 풀이 시간: 20분
*/
public class _200_Number_of_Islands {
    static int[] cx = {1, 0, -1, 0};
    static int[] cy = {0, -1, 0, 1};
    static boolean[][] visited;

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        
        int result = 0;
        // O(nm)
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
        
    }

    public void dfs(char[][] grid, int x, int y) {
        
        visited[x][y] = true;

        // O(4) == O(1)
        for (int i = 0; i < 4; i++) {
            int nx = x + cx[i];
            int ny = y + cy[i];

            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                if (!visited[nx][ny] && grid[nx][ny] == '1') {
                    dfs(grid, nx, ny);
                }
            }
        }
    }
}