package ExhaustiveSearch;
class _87946_피로도 {
    public static int maxcnt = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        // maxcnt = 0;
        dfs(dungeons, visited, k, 0);
        return maxcnt;
    }
    
    public static int dfs(int[][] dungeons, boolean[] visited, int k, int cnt) {
        if (cnt > maxcnt)
                maxcnt = cnt;
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                maxcnt = dfs(dungeons, visited, k - dungeons[i][1], cnt+1);
                visited[i] = false; // 탐색 끝나면 visited 배열 복구(다른 경우의 수에서 사용하기 위함)
            }
        }
        
        return maxcnt;
    }
}