package DYNAMIC_PROGRAMMING.B_ClimbStairs;

public class CountNumberOfPaths {

    // ~~~~~~~~~~~~~~Climb Stairs~~~~~~~~~~~~~
    public static int climbStair_rec(int currStairNumber) {

        //when I reach 0th stair
        //I found one valid path
        //increment total valid paths by 1
        if (currStairNumber == 0) {
            return 1;
        }

        //During PREOERDER phase
        //At each Level , a count variable is assigned to Node
        int countPaths = 0;
        for (int j = 1; j <= 3; j++) { // ALL Possible Branches(options) from each node(rec call)
            if (currStairNumber - j >= 0) {//Use only valid branches

                // Draw Branches
                int PathsfromCurrNode = climbStair_rec(currStairNumber - j);

                //During PostOrder Phase
                //count variable initialized during PREOERDER phase at each level
                // is used to store count of all paths via that node
                countPaths+=PathsfromCurrNode;
            }
        }
        return countPaths;
    }

    public static int climbStair_memo(int n, int[] dp) {

        //DP's smallest problem solved by me
        if (n == 0) {
            return dp[0] = 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int count = 0;
        for (int j = 1; j <= 3; j++) {
            if (n - j >= 0) {
                count += climbStair_memo(n - j, dp);
            }
        }
        return dp[n] = count;
    }

    // purely tabulation
    public static int climbStair_tab1(int n, int[] dp) {
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i >= 3) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            } else if (i >= 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    // convert code from memoisation to tabulation
    public static int climbStair_tab2(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n == 0) {
                dp[0] = 1;
                continue;
            }

            int count = 0;
            for (int j = 1; j <= 3; j++) {
                if (n - j >= 0) {
                    count += dp[n - j]; // climbStair_memo(n - j, dp);
                }
            }
            dp[n] = count;
        }
        return dp[N];
    }
}

/*
QUESTION 1
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. You are required to print the number of different paths via which you can climb to the top.

 Since number of jumps are fixed(1,2,3) only we will get same number of paths
 whether we start from top and go to bottom OR start from bottom and go top

Sample Input
4
Sample Output
7
 */
