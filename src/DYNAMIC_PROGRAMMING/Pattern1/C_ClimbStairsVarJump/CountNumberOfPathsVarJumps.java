package DYNAMIC_PROGRAMMING.Pattern1.C_ClimbStairsVarJump;

public class CountNumberOfPathsVarJumps {

    // i-> current stair, n-> total stair, jumps[] -> jumps allowed at ith stair
    public static int climbStair_VarJumps_rec(int i, int n, int[] jumps) {
        if (i == n) {
            return 1;
        }
        int count = 0;
        for (int jump = 1; jump <= jumps[i] && jump + i <= n; jump++) {
            count += climbStair_VarJumps_rec(i + jump, n, jumps);
        }
        return count;
    }

    public static int climbStair_VarJumps_memo(int i, int n, int[] jumps, int[] dp) {
        if (i == n) {
            return dp[i] = 1;
        }

        if (dp[i] != 0) {
            return dp[i];
        }

        int count = 0;
        for (int jump = 1; jump <= jumps[i] && jump + i <= n; jump++) {
            count += climbStair_VarJumps_memo(i + jump, n, jumps, dp);
        }
        return dp[i] = count;
    }

    /*
     * 5. Since number of jumps are variable we will get different number of paths
     * if we start from top and go to bottom AND if we start from bottom and go top
     * 
     * 6. As reaching the top is goal our smallest problem is at last index Cauz
     * each index stores the number of paths to reach Last Index To reach Last Index
     * from last index we get answer as 1(smallest problem) So our direction of
     * tabulation will be from last index to start index
     * 
     */
    public static int climbStair_VarJumps_tab(int i, int n, int[] dp, int[] jumps) {
        for (i = n; i >= 0; i--) {
            if (i == n) {
                dp[i] = 1;
                continue;
            }

            int count = 0;
            for (int jump = 1; jump <= jumps[i] && jump + i <= n; jump++) {
                count += dp[i + jump]; // climbStair_VarJumps_memo(i + jump, n, jumps, dp);
            }
            dp[i] = count;
        }
        return dp[0];
    }
}
/*
 * 1. You are given a number n, representing the number of stairs in a
 * staircase. 2. You are on the 0th step and are required to climb to the top.
 * 3. You are given n numbers, where ith element's value represents - till how
 * far from the step you could jump to in a single move. You can of course jump
 * fewer number of steps in the move. 4. You are required to print the number of
 * different paths via which you can climb to the top.
 * 
 * Sample Input 10 3 3 0 2 1 2 4 2 0 0 Sample Output 5
 */
