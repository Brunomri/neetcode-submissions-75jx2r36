class Solution {
    int ROWS, COLS;
    boolean[][] visited;

    public int numEnclaves(int[][] grid) {
        /*for(int m = 0; m < grid.length; m++) {
            for(int n = 0; n < grid[m].length; n++) {
                if (grid[m][n] == 1) {
                    landCells++;
                }
            }
        }*/
        this.ROWS = grid.length;
        this.COLS = grid[0].length;
        this.visited = new boolean[ROWS][COLS];
        
        int landCells = 0, borderCells = 0;
        
        for(int m = 0; m < grid.length; m++) {
            for(int n = 0; n < grid[m].length; n++) {
                landCells += grid[m][n];
                
                if (m == 0 || m == grid.length - 1 || n == 0 || n == grid[m].length - 1) {
                    borderCells += dfs(grid, m, n);      
                }
            }   
        }

        System.out.println("land cells = " + landCells);
        return landCells - borderCells;
    }

    private int dfs(int[][] grid, int m, int n) {

        if(grid[m][n] == 0 || visited[m][n]) {
            return 0;
        }

        int reachable = 1;
        System.out.println("Visited node [%s, %s]".formatted(m, n));
        visited[m][n] = true;

        if(m - 1 >= 0 && grid[m - 1][n] == 1) {
            System.out.println("Move above");
            reachable += dfs(grid, m - 1, n);
        }

        if(m + 1 <= grid.length - 1 && grid[m + 1][n] == 1) {
            System.out.println("Move below");
            reachable += dfs(grid, m + 1, n);
        }

        if(n - 1 >= 0 && grid[m][n - 1] == 1) {
            System.out.println("Move left");
            reachable += dfs(grid, m, n - 1);
        }

        if(n + 1 <= grid[m].length - 1 && grid[m][n + 1] == 1) {
            System.out.println("Move right");
            reachable += dfs(grid, m, n + 1);
        }

        return reachable;
    }
}