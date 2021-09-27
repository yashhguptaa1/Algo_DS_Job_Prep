package DYNAMIC_PROGRAMMING.Q_MaxSumNonAdjEle;

public class MaxSumNonAdjEle {

    // ~~~~~~~~~~~~~Max Sum Non Adjacent Elements~~~~~~~~~~~~
    public static int maxSumNonAdjacentEle_rec(int[] arr, int indx, int status) {
        if (indx == -1) {
            return 0;
        }
        int maxSum = (int) -1e9;
        if (status == 0) {
            // this is call of include
            maxSum = maxSumNonAdjacentEle_rec(arr, indx - 1, 1) + arr[indx];
        }
        // exclude call
        maxSum = Math.max(maxSum, maxSumNonAdjacentEle_rec(arr, indx - 1, 0));
        return maxSum;
    }

    public static int maxSumNonAdjacentEle_memo(int[] arr, int indx, int status, int[][] dp) {
        if (indx == -1) {
            return dp[status][indx + 1] = 0;
        }

        if (dp[status][indx + 1] != 0)
            return dp[status][indx + 1];

        int maxSum = (int) -1e9;
        if (status == 0) {
            // this is call of include
            maxSum = maxSumNonAdjacentEle_memo(arr, indx - 1, 1, dp) + arr[indx];
        }
        // exclude call
        maxSum = Math.max(maxSum, maxSumNonAdjacentEle_memo(arr, indx - 1, 0, dp));
        return dp[status][indx + 1] = maxSum;
    }

    public static int maxSumNonAdjacentEle_tab_optimise(int[] arr) {
        int include = 0;
        int exclude = 0;

        for (int i = 0; i < arr.length; i++) {
            int n_include = exclude + arr[i];
            int n_exclude = Math.max(include, exclude);

            include = n_include;
            exclude = n_exclude;
        }

        return Math.max(include, exclude);
    }

    public static void MaxSumNonAdjacentEle() {
        int[] arr = { 5, 10, 10, 100, 5, 6 };
        // int res = maxSumNonAdjacentEle_rec(arr, arr.length - 1, 0);
        int n = arr.length;
        int[][] dp = new int[2][n + 1];
        int res = maxSumNonAdjacentEle_memo(arr, n - 1, 0, dp);
        System.out.println(res);
    }

}
/*
 * 1. You are given a number n, representing the count of elements. 2. You are
 * given n numbers, representing n elements. 3. You are required to find the
 * maximum sum of a subsequence with no adjacent elements.
 * 
 * Sample Input 6 5 10 10 100 5 6 Sample Output 116
 */
