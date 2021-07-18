package DYNAMIC_PROGRAMMING.Pattern1.I_CoinChangePermutation;

public class CoinChangePermutation {

    // ~~~~~~~~~~~~~~~~~~~Coin Change~~~~~~~~~~~~~~

    // Same as countAllValid Paths principle used in
    //B_ClimbStairs.CountNumberOfPaths
    public static int coinChange_perm_rec(int[] coins, int target, String psf) {
        if(target == 0) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;//PRE
        for(int coin : coins) {
            if(target - coin >= 0)
                count= coinChange_perm_rec(coins, target - coin, psf + coin + " ");

        }
        return count;
    }

    public static int coinChange_perm_memo(int[] coins, int target, int[] dp) {
        if(target == 0) {
            return dp[target] = 1;
        }

        if(dp[target] != 0) return dp[target];

        int count = 0;
        for(int coin : coins) {
            if(target - coin >= 0)
                count += coinChange_perm_memo(coins, target - coin, dp);
        }
        return dp[target] = count;
    }

    public static int coinChange_tab2(int[] coins, int targ, Integer[][] dp) {
        for(int indx = coins.length; indx >= 0; indx--) {
            for(int target = 0; target <= targ; target++) {
                if(target == 0) {
                    dp[indx][target] = 1;
                    continue;
                }

                if(indx == coins.length) {
                    dp[indx][target] = 0;
                    continue;
                }

                int count = 0;
                if(target - coins[indx] >= 0) {
                    count += dp[indx][target - coins[indx]];
                }
                count += dp[indx + 1][target];
                dp[indx][target] = count;
            }
        }
        return dp[0][targ];
    }

    public static int coinChange_perm_tab1(int[] coins, int target, int[] dp) {
        dp[0] = 1;

        for(int i = 1; i <= target; i++) {
            for(int coin : coins) {
                if(i - coin >= 0)
                    dp[i] += dp[i - coin];
            }
        }
        return dp[target];
    }
}
/*
1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the number of permutations of the n coins using which the
     amount "amt" can be paid.

Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be
                  used for many installments in payment of "amt"
Note2 -> You are required to find the count of permutations and not combinations i.e.
                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same
                  combination. You should treat them as 3 and not 1.

Sample Input
4
2
3
5
6
7
Sample Output
5

 */