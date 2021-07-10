package DYNAMIC_PROGRAMMING.F_GoldMine;

public class Goldmine {

    // ~~~~~~~~~~~~~~~Goldmine~~~~~~~~~~~~~~
    public static int goldmineHelper_rec(int[][] mine, int x, int y) {
        if(y == mine[0].length - 1) {
            return mine[x][y];
        }

        int cost = 0;
        // top-right
        if(x - 1 >= 0) {
            cost = Math.max(cost, goldmineHelper_rec(mine, x - 1, y + 1));
        }
        // right -> no need for check of y
        cost = Math.max(cost, goldmineHelper_rec(mine, x, y + 1));
        // down-right
        if(x + 1 < mine.length) {
            cost = Math.max(cost, goldmineHelper_rec(mine, x + 1, y + 1));
        }
        return cost + mine[x][y];
    }
    public static int goldmineHelper_memo(int[][] mine, int x, int y, Integer[][] dp) {
        if(y == mine[0].length - 1) {
            return dp[x][y] = mine[x][y];
        }

        if(dp[x][y] != null) {
            return dp[x][y];
        }

        int cost = 0;
        // top-right
        if(x - 1 >= 0) {
            cost = Math.max(cost, goldmineHelper_memo(mine, x - 1, y + 1, dp));
        }
        // right -> no need for check of y
        cost = Math.max(cost, goldmineHelper_memo(mine, x, y + 1, dp));
        // down-right
        if(x + 1 < mine.length) {
            cost = Math.max(cost, goldmineHelper_memo(mine, x + 1, y + 1, dp));
        }
        return dp[x][y] = cost + mine[x][y];
    }

    public static int goldmine_rec(int[][] mine) {
        int profit = 0;

        Integer[][] dp = new Integer[mine.length][mine[0].length];
        for(int x = 0; x < mine.length; x++) {
            profit = Math.max(profit, goldmineHelper_memo(mine, x, 0, dp));
        }
        return profit;
    }

    public static int goldmine_tab1(int[][] mine, int x, int y, int[][] dp) {
        int res = 0;
        for(y = mine[0].length - 1; y >= 0; y--) {
            for(x = 0; x < mine.length; x++) {
                if(y == mine[0].length - 1) {
                    dp[x][y] = mine[x][y];
                } else if(x == 0){
                    dp[x][y] = Math.max(dp[x][y + 1], dp[x + 1][y + 1]) + mine[x][y];
                } else if(x == mine.length - 1) {
                    dp[x][y] = Math.max(dp[x][y + 1], dp[x - 1][y + 1]) + mine[x][y];
                } else {
                    dp[x][y] = Math.max(dp[x - 1][ y + 1], Math.max(dp[x][y + 1], dp[x + 1][y + 1])) + mine[x][y];
                }
                res = Math.max(res, dp[x][y]);
            }
        }
        return res;
    }

}
/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from
     any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).

goldmine

6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.

Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
Sample Output
33
 */