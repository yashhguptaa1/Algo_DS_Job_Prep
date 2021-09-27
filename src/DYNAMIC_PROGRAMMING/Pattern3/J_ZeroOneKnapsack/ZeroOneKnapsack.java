package DYNAMIC_PROGRAMMING.Pattern3.J_ZeroOneKnapsack;

public class ZeroOneKnapsack {
    public int knapsack(int n, int values[], int wts[], int capSoFar) {
        if (n == -1) {
            return 0;
        }
        // 2 options =2 rec calls
        int profitIncludingCurrItem = 0;
        if (capSoFar - wts[n] >= 0) {
            profitIncludingCurrItem = knapsack(n - 1, values, wts, capSoFar - wts[n]) + values[n];
        }
        int profitExcludingCurrItem = knapsack(n - 1, values, wts, capSoFar);
        int MaxProfit = Math.max(profitIncludingCurrItem, profitExcludingCurrItem);
        return MaxProfit;
    }

    public static int knapsack01_rec(int[] wts, int[] vals, int indx, int cap) {
        if (indx == -1) {
            return 0;
        }
        int v1 = 0;
        // yes call
        if (cap - wts[indx] >= 0) {
            v1 = knapsack01_rec(wts, vals, indx - 1, cap - wts[indx]) + vals[indx];
        }
        // no call
        int v2 = knapsack01_rec(wts, vals, indx - 1, cap);
        return Math.max(v1, v2);
    }

    public static int knapsack01_memo(int[] wts, int[] vals, int indx, int cap, int[][] dp) {
        if (indx == -1) {
            return dp[indx + 1][cap] = 0;
        }
        if (dp[indx + 1][cap] != 0) {
            return dp[indx + 1][cap];
        }
        int v1 = 0;
        // yes call
        if (cap - wts[indx] >= 0) {
            v1 = knapsack01_memo(wts, vals, indx - 1, cap - wts[indx], dp) + vals[indx];
        }
        // no call
        int v2 = knapsack01_memo(wts, vals, indx - 1, cap, dp);
        return dp[indx + 1][cap] = Math.max(v1, v2);
    }

    public static int knapsack01_tab(int[] wts, int[] vals, int indx, int Cap, int[][] dp) {
        for (indx = 1; indx <= vals.length; indx++) {
            for (int cap = 1; cap <= Cap; cap++) {
                if (cap < wts[indx - 1]) {
                    dp[indx][cap] = dp[indx - 1][cap];
                } else {
                    // yes call
                    int v1 = dp[indx - 1][cap - wts[indx - 1]] + vals[indx - 1];
                    // no call
                    int v2 = dp[indx - 1][cap];
                    dp[indx][cap] = Math.max(v1, v2);
                }
            }
        }
        return dp[wts.length][Cap];
    }
}