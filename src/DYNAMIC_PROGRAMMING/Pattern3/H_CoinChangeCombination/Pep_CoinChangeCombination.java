package DYNAMIC_PROGRAMMING.Pattern3.H_CoinChangeCombination;

import java.util.*;

public class Pep_CoinChangeCombination {
    public static HashMap<String, Integer> map = null;

    // Yes , //No call style
    // to determine repetition
    public static int coinChange_comb_rec_SubseqStyle(int[] coins, int indx, int target, String psf, Integer[][] dp) {
        // System.out.println(indx + " " + target);
        if (target == 0) {
            // System.out.println(psf);
            return dp[indx][target] = 1;
        }

        if (indx == coins.length) {
            return dp[indx][target] = 0;
        }

        if (dp[indx][target] != null)
            return dp[indx][target];

        String str = "" + indx + " " + target;
        if (map.containsKey(str) == true) {
            map.put(str, map.get(str) + 1);
        } else {
            map.put(str, 1);
        }

        int count = 0;
        if (target - coins[indx] >= 0) {
            count += coinChange_comb_rec_SubseqStyle(coins, indx, target - coins[indx], psf + coins[indx] + " ", dp);
        }
        count += coinChange_comb_rec_SubseqStyle(coins, indx + 1, target, psf, dp);
        return dp[indx][target] = count;
    }

    public static int coinChange_comb_tab(int[] coins, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                if (i - coin >= 0)
                    dp[i] += dp[i - coin];
            }
        }
        return dp[target];
    }

    public static int coinChange_tab2(int[] coins, int targ, Integer[][] dp) {
        for (int indx = coins.length; indx >= 0; indx--) {
            for (int target = 0; target <= targ; target++) {
                if (target == 0) {
                    dp[indx][target] = 1;
                    continue;
                }

                if (indx == coins.length) {
                    dp[indx][target] = 0;
                    continue;
                }

                int count = 0;
                if (target - coins[indx] >= 0) {
                    count += dp[indx][target - coins[indx]];
                }
                count += dp[indx + 1][target];
                dp[indx][target] = count;
            }
        }
        return dp[0][targ];
    }

    public static void coinChange() {
        map = new HashMap<>();
        int[] coins = { 2, 3, 5, 6, 10 };
        int target = 90;

        Integer[][] dp = new Integer[coins.length + 1][target + 1];
        // int[] dp = new int[target + 1];
        // int res = coinChange_perm_memo(coins, target, dp);
        // System.out.println(res);

        coinChange_comb_rec_SubseqStyle(coins, 0, target, "", dp);

        for (String key : map.keySet()) {
            // if(map.get(key) > 1)
            System.out.println(key + " -> " + map.get(key));
        }

    }
}

/*
 * 1. You are given a number n, representing the count of coins. 2. You are
 * given n numbers, representing the denominations of n coins. 3. You are given
 * a number "amt". 4. You are required to calculate and print the number of
 * combinations of the n coins using which the amount "amt" can be paid.
 * 
 * Note1 -> You have an infinite supply of each coin denomination i.e. same coin
 * denomination can be used for many installments in payment of "amt" Note2 ->
 * You are required to find the count of combinations and not permutations i.e.
 * 2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations
 * of same combination. You should treat them as 1 and not 3.
 * 
 * Sample Input 4 2 3 5 6 7 Sample Output 2
 */