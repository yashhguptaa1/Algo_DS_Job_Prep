package DYNAMIC_PROGRAMMING.B_ClimbStairs;

public class Climbstairs {

    /*
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. Return the count of total paths from nth stair to 0th stair
5. Since number of jumps are fixed(1,2,3) only we will get same number of paths
 whether we start from top and go to bottom OR start from bottom and go top

     */
    // ~~~~~~~~~~~~~~Climb Stairs~~~~~~~~~~~~~
    public static int climbStair_rec(int totalStairs) {

        //when i reach 0th stair
        //I found one valid path
        //increment total valid paths by 1
        if (totalStairs == 0) {
            return 1;
        }

        //DRY RUN CHECK why initialized here
        int countPaths = 0;
        for (int j = 1; j <= 3; j++) {
            if (totalStairs - j >= 0) {
                int PathsfromCurrNode = climbStair_rec(totalStairs - j);
                countPaths+=PathsfromCurrNode;
            }
        }
        return countPaths;
    }

    public static int climbStair_memo(int n, int[] dp) {
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

    /*
    1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you
     could jump to in a single move.
     You can of course jump fewer number of steps in the move.
4. Return the count of different paths via which you can climb to the top


     */

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
    5. Since number of jumps are variable we will get different number of paths
 if we start from top and go to bottom AND if we  start from bottom and go top

6. As reaching the top is goal our smallest problem is at last index
  Cauz each index stores the number of paths to reach Last Index
  To reach Last Index from last index we get answer as 1(smallest problem)
  So our direction of tabulation will be from last index to start index

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

    public static void climbStair() {
        int n = 4;
        int res = climbStair_rec(n);
//        int[] dp = new int[n + 1];
//        int res = climbStair_memo(n, dp);
        System.out.println(res);
    }

    public static void main(String[] args) {
        climbStair();
    }
}
