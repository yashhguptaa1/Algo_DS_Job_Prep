package DYNAMIC_PROGRAMMING.Pattern2.D_ClimbStairsMinJumps;

public class CountMinJumpsRequiredToReachDest {

    public static int climbStair_minJumps_rec(int i, int n, int[] jumps) {
        if (i == n) {
            return 0;
        }

        int minJumps = (int) 1e9;

        for (int jump = 1; jump <= jumps[i] && jump + i <= n; jump++) {
            minJumps = Math.min(minJumps, climbStair_minJumps_rec(i + jump, n, jumps));
        }

        return minJumps == 1e9 ? minJumps : minJumps + 1;
    }

    public static int climbStair_minJumps_memo(int i, int n, int[] jumps, int[] dp) {

        // Mjhe dest se dest pr jump lgana he
        // Me koi bhi jump naa lun
        // store 0 as we want min jumps possible
        if (i == n) {
            return dp[i] = 0;
        }

        if (dp[i] != 0)
            return dp[i];

        int minJumps = (int) 1e9;

        for (int jump = 1; jump <= jumps[i] && jump + i <= n; jump++) {
            minJumps = Math.min(minJumps, climbStair_minJumps_memo(i + jump, n, jumps, dp));
        }

        return minJumps == 1e9 ? (dp[i] = minJumps) : (dp[i] = minJumps + 1);
    }

    public static int climbStair_minJumps_tab(int i, int n, int[] jumps, int[] dp) {
        for (i = n; i >= 0; i--) {
            if (i == n) {
                dp[i] = 0;
                continue;
            }

            int minJumps = (int) 1e9;

            for (int jump = 1; jump <= jumps[i] && jump + i <= n; jump++) {
                minJumps = Math.min(minJumps, dp[i + jump]); // climbStair_minJumps_memo(i + jump, n, jumps, dp));
            }

            if (minJumps == 1e9) {
                dp[i] = (int) 1e9;
            } else {
                dp[i] = minJumps + 1;
            }
        }
        return dp[0];
    }

}
/*
 * 
 * 1. You are given a number n, representing the number of stairs in a
 * staircase. 2. You are on the 0th step and are required to climb to the top.
 * 3. You are given n numbers, where ith element's value represents - till how
 * far from the step you could jump to in a single move. You can of-course fewer
 * number of steps in the move. 4. You are required to print the number of
 * minimum moves in which you can reach the top of staircase. Note -> If there
 * is no path through the staircase print null. Sample Input 10 3 3 0 2 1 2 4 2
 * 0 0 Sample Output 4
 */