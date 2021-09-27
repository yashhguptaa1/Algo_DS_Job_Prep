package DYNAMIC_PROGRAMMING.Pattern2.E_MinCostPathInMatrix;

public class MinCostPath {

    // ~~~~~~~~~~~~~~~~Min Cost Path~~~~~~~~~~~
    public static int minCostPath_rec(int[][] maze, int x, int y) {

        if (x == maze.length - 1 && y == maze[0].length - 1) {
            return maze[x][y];
        }

        int minCost = (int) 1e9;
        // right call
        if (y + 1 < maze[0].length) {
            minCost = Math.min(minCost, minCostPath_rec(maze, x, y + 1));
        }
        // down call
        if (x + 1 < maze.length) {
            minCost = Math.min(minCost, minCostPath_rec(maze, x + 1, y));
        }

        return minCost + maze[x][y];
    }

    public static int minCostPath_memo(int[][] maze, int x, int y, int[][] dp) {
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            return dp[x][y] = maze[x][y];
        }

        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        int minCost = (int) 1e9;
        // right call
        if (y + 1 < maze[0].length) {
            minCost = Math.min(minCost, minCostPath_memo(maze, x, y + 1, dp));
        }
        // down call
        if (x + 1 < maze.length) {
            minCost = Math.min(minCost, minCostPath_memo(maze, x + 1, y, dp));
        }

        return dp[x][y] = minCost + maze[x][y];
    }

    // 4. You are standing in top-left cell
    // and are required to move to bottom-right cell.
    // 6. Each cell has a value that will have to be paid to enter that
    // cell (even for the top-left and bottom-right cell).
    // 7. You are required to traverse through the matrix and print the cost of path
    // which is least costly.
    // Since we have to reach bottomost right cell, the problem in matrix
    // at bottomost right cell is the smallest.
    public static int minCostPath_tab1(int[][] maze, int x, int y, int[][] dp) {
        for (x = maze.length - 1; x >= 0; x--) {
            for (y = maze[0].length - 1; y >= 0; y--) {
                if (x == maze.length - 1 && y == maze[0].length - 1) {
                    // bottom right corner
                    dp[x][y] = maze[x][y];
                } else if (x == maze.length - 1) {
                    // last row
                    dp[x][y] = maze[x][y] + dp[x][y + 1];
                } else if (y == maze[0].length - 1) {
                    // last col
                    dp[x][y] = maze[x][y] + dp[x + 1][y];
                } else {
                    // middle section
                    dp[x][y] = maze[x][y] + Math.min(dp[x][y + 1], dp[x + 1][y]);
                }
            }
        }
        return dp[0][0];
    }

    public static int minCostPath_tab2(int[][] maze, int x, int y, int[][] dp) {
        for (x = maze.length - 1; x >= 0; x--) {
            for (y = maze[0].length - 1; y >= 0; y--) {
                if (x == maze.length - 1 && y == maze[0].length - 1) {
                    dp[x][y] = maze[x][y];
                    continue;
                }

                int minCost = (int) 1e9;
                // right call
                if (y + 1 < maze[0].length) {
                    minCost = Math.min(minCost, dp[x][y + 1]);
                }
                // down call
                if (x + 1 < maze.length) {
                    minCost = Math.min(minCost, dp[x + 1][y]);
                }

                dp[x][y] = minCost + maze[x][y];
            }
        }
        return dp[0][0];
    }

    public static void minCostPath(int[][] dp, int x, int y, String psf) {
        if (x == dp.length - 1 && y == dp[0].length - 1) {
            System.out.println(psf);
        } else if (x == dp.length - 1) {
            minCostPath(dp, x, y + 1, psf + "R ");
        } else if (y == dp[0].length - 1) {
            minCostPath(dp, x + 1, y, psf + "D ");
        } else {
            if (dp[x][y + 1] == dp[x + 1][y]) {
                // both side
                minCostPath(dp, x + 1, y, psf + "D ");
                minCostPath(dp, x, y + 1, psf + "R ");
            } else if (dp[x][y + 1] < dp[x + 1][y]) {
                // right side
                minCostPath(dp, x, y + 1, psf + "R ");
            } else {
                // down side
                minCostPath(dp, x + 1, y, psf + "D ");
            }
        }
    }

    public static void mazePath() {
        int[][] maze = { { 0, 1, 4, 2, 8, 2 }, { 4, 3, 6, 5, 0, 4 }, { 1, 2, 4, 1, 4, 6 }, { 2, 0, 7, 3, 2, 2 },
                { 3, 1, 5, 9, 2, 4 }, { 2, 7, 0, 8, 5, 1 } };

        int[][] dp = new int[6][6];
        minCostPath_tab1(maze, 0, 0, dp);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        minCostPath(dp, 0, 0, "");
    }

}
/*
 * 1. You are given a number n, representing the number of rows. 2. You are
 * given a number m, representing the number of columns. 3. You are given n*m
 * numbers, representing elements of 2d array a, which represents a maze. 4. You
 * are standing in top-left cell and are required to move to bottom-right cell.
 * 5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1
 * motion. 6. Each cell has a value that will have to be paid to enter that cell
 * (even for the top-left and bottom- right cell). 7. You are required to
 * traverse through the matrix and print the cost of path which is least costly.
 * 
 * Sample Input 6 6 0 1 4 2 8 2 4 3 6 5 0 4 1 2 4 1 4 6 2 0 7 3 2 2 3 1 5 9 2 4
 * 2 7 0 8 5 1 Sample Output 23
 */
