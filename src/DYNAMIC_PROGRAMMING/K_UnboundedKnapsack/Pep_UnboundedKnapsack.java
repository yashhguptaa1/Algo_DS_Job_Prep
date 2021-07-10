package DYNAMIC_PROGRAMMING.K_UnboundedKnapsack;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/unbounded-knapsack-official/ojquestion
public class Pep_UnboundedKnapsack {

    public static int unboundedKnapsack_rec(int[] wts, int[] vals, int indx, int cap) {
        if(cap == 0 || indx == -1) {
            return 0;
        }

        int v1 = 0;
        // yes call
        if(cap - wts[indx] >= 0) {
            v1 = unboundedKnapsack_rec(wts, vals, indx, cap - wts[indx]) + vals[indx];
        }
        // no call
        int v2 = unboundedKnapsack_rec(wts, vals, indx - 1, cap);

        return Math.max(v1, v2);
    }

    public static int unboundedKnapsack_memo(int[] wts, int[] vals, int indx, int cap, int[][] dp) {
        if(cap == 0 || indx == -1) {
            return dp[indx + 1][cap] = 0;
        }

        if(dp[indx + 1][cap] != 0) return dp[indx + 1][cap];

        int v1 = 0;
        // yes call
        if(cap - wts[indx] >= 0) {
            v1 = unboundedKnapsack_memo(wts, vals, indx, cap - wts[indx], dp) + vals[indx];
        }
        // no call
        int v2 = unboundedKnapsack_memo(wts, vals, indx - 1, cap, dp);

        return dp[indx + 1][cap] = Math.max(v1, v2);
    }

    public static int unoundedKnapsack_tab(int[] wts, int[] vals, int cap) {
        int[] dp = new int[cap + 1];

        // outer loop for box
        // inner loop for cap
        for(int i = 0; i < wts.length; i++) {
            for(int c = wts[i]; c <= cap; c++) {
                // no call
                int v1 = dp[c];
                // yes call
                int v2 = dp[c - wts[i]] + vals[i];

                dp[c] = Math.max(v1, v2);
            }
        }
        return dp[cap];
    }


}
/*
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without
    overflowing it's capacity.
Note -> Each item can be taken any number of times. You are allowed to put the same item again
                  and again.
 Sample Input
5
15 14 10 45 30
2 5 1 3 4
7
Sample Output
100
 */