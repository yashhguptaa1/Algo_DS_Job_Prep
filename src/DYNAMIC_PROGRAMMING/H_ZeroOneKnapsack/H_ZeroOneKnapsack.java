package DYNAMIC_PROGRAMMING.H_ZeroOneKnapsack;


public class H_ZeroOneKnapsack {

    public int knapsack(int n,int values[],int wts[],int capSoFar)
    {
        if(n == -1)
        {
            return 0;
        }

        //2 options =2 rec calls
        int profitIncludingCurrItem=0;

        if(capSoFar - wts[n]>=0)
            {
                profitIncludingCurrItem=knapsack(n-1,values,wts,capSoFar-wts[n]) + values[n];
            }
            int profitExcludingCurrItem=knapsack(n-1,values,wts,capSoFar);

        int MaxProfit=Math.max(profitIncludingCurrItem,profitExcludingCurrItem);


        return MaxProfit;

    }

    // ~~~~~~~~~~~~~~~~~~~~~~Knapsack~~~~~~~~~~~~~~~
    public static int knapsack01_rec(int[] wts, int[] vals, int indx, int cap) {
        if(indx == -1) {
            return 0;
        }

        int v1 = 0;
        // yes call
        if(cap - wts[indx] >= 0) {
            v1 = knapsack01_rec(wts, vals, indx - 1, cap - wts[indx]) + vals[indx];
        }
        // no call
        int v2 = knapsack01_rec(wts, vals, indx - 1, cap);
        return Math.max(v1, v2);
    }

    public static int knapsack01_memo(int[] wts, int[] vals, int indx, int cap, int[][] dp) {
        if(indx == -1) {
            return dp[indx + 1][cap] = 0;
        }

        if(dp[indx + 1][cap] != 0) {
            return dp[indx + 1][cap];
        }

        int v1 = 0;
        // yes call
        if(cap - wts[indx] >= 0) {
            v1 = knapsack01_memo(wts, vals, indx - 1, cap - wts[indx], dp) + vals[indx];
        }
        // no call
        int v2 = knapsack01_memo(wts, vals, indx - 1, cap, dp);
        return dp[indx + 1][cap] = Math.max(v1, v2);
    }

    public static int knapsack01_tab(int[] wts, int[] vals, int indx, int Cap, int[][] dp) {

        for(indx = 1; indx <= vals.length; indx++) {
            for(int cap = 1; cap <= Cap; cap++) {
                if(cap < wts[indx - 1]) {
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

/*
Ques
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without
     overflowing it's capacity.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item
               again and again.


Sample Input
5
15 14 10 45 30
2 5 1 3 4
7
Sample Output
75

*/