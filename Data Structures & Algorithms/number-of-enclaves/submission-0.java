class Solution {

    private int landCells = 0;
    private int visited = 0;

    public int numEnclaves(int[][] grid) {
        for(int m = 0; m < grid.length; m++) {
            for(int n = 0; n < grid[m].length; n++) {
                if (grid[m][n] == 1) {
                    landCells++;
                }
            }
        }
        System.out.println("land cells = " + landCells);

        for(int m = 0; m < grid.length; m++) {
            if (m == 0 || m == grid.length - 1) {
                for(int n = 0; n < grid[m].length; n++) {
                    visited += dfs(grid, m, n);
                }
            } else {
                visited += dfs(grid, m, 0);
                visited += dfs(grid, m, grid[m].length - 1);
            }
        }

        System.out.println("Visited " + visited);
        return landCells - visited;
    }

    private int dfs(int[][] grid, int m, int n) {

        if(grid[m][n] == 0) {
            return 0;
        }

        int visited = 0;
        System.out.println("Visited node [%s, %s]".formatted(m, n));
        visited++;
        grid[m][n] = 0;

        if(m - 1 >= 0 && grid[m - 1][n] == 1) {
            System.out.println("Move above");
            visited += dfs(grid, m - 1, n);
        }

        if(m + 1 <= grid.length - 1 && grid[m + 1][n] == 1) {
            System.out.println("Move below");
            visited += dfs(grid, m + 1, n);
        }

        if(n - 1 >= 0 && grid[m][n - 1] == 1) {
            System.out.println("Move left");
            visited += dfs(grid, m, n - 1);
        }

        if(n + 1 <= grid[m].length - 1 && grid[m][n + 1] == 1) {
            System.out.println("Move right");
            visited += dfs(grid, m, n + 1);
        }

        return visited;
    }
}