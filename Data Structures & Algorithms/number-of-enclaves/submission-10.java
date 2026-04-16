class Solution {
    int ROWS, COLS;
    boolean[][] visited;

    public int numEnclaves(int[][] grid) {
        this.ROWS = grid.length;
        this.COLS = grid[0].length;
        this.visited = new boolean[ROWS][COLS];
        
        int landCells = 0, borderCells = 0;
        
        for(int m = 0; m < ROWS; m++) {
            for(int n = 0; n < COLS; n++) {
                if(grid[m][n] == 0) continue;
                
                landCells += 1;
                if(m == 0 || m == ROWS - 1 || n == 0 || n == COLS - 1) {
                    borderCells += dfs(grid, m, n);      
                }
            }   
        }

        return landCells - borderCells;
    }

    private int dfs(int[][] grid, int m, int n) {

        if(m < 0 || n < 0 || m == ROWS || n == COLS || grid[m][n] == 0 || visited[m][n]) {
            return 0;
        }

        int reachable = 1;
        visited[m][n] = true;

        reachable += dfs(grid, m - 1, n);
        reachable += dfs(grid, m + 1, n);
        reachable += dfs(grid, m, n - 1);
        reachable += dfs(grid, m, n + 1);

        return reachable;
    }
}