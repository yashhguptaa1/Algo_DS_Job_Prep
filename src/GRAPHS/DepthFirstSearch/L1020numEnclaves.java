package GRAPHS.DepthFirstSearch;

public class L1020numEnclaves {

    static int[] xdir = { -1, 0, 1, 0 };
    static int[] ydir = { 0, -1, 0, 1 };

    private static void numEnclave_dfs(int[][] graph, int x, int y) {
        graph[x][y] = 0;
        for (int d = 0; d < 4; d++) {
            int r = x + xdir[d];
            int c = y + ydir[d];
            if (r >= 0 && r < graph.length && c >= 0 && c < graph[0].length && graph[r][c] != 0) {
                numEnclave_dfs(graph, r, c);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        // for 0th row
        for (int c = 0; c < grid[0].length; c++) {
            if (grid[0][c] == 1) {
                numEnclave_dfs(grid, 0, c);
            }
        }
        // for last row
        for (int c = 0; c < grid[0].length; c++) {
            if (grid[grid.length - 1][c] == 1) {
                numEnclave_dfs(grid, grid.length - 1, c);
            }
        }
        // for 0th col
        for (int r = 0; r < grid.length; r++) {
            if (grid[r][0] == 1) {
                numEnclave_dfs(grid, r, 0);
            }
        }
        // for last col
        for (int r = 0; r < grid.length; r++) {
            if (grid[r][grid[0].length - 1] == 1) {
                numEnclave_dfs(grid, r, grid[0].length - 1);
            }
        }
        // count remaining one
        int one = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1)
                    one++;
            }
        }
        return one;
    }

}
