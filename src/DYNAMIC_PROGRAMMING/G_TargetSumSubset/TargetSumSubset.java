package DYNAMIC_PROGRAMMING.G_TargetSumSubset;

public class TargetSumSubset {

    // ~~~~~~~~~~~~~~~~Target Sum Subset~~~~~~~~~~
    public static boolean targetSumSubset_rec(int[] arr, int indx, int target) {
        if(target == 0) return true;
        if(indx == arr.length) {
            return false;
        }
        boolean res = false;

        // no call
        res = targetSumSubset_rec(arr, indx + 1, target);

        // yes call
        if(target - arr[indx] >= 0) {
            res = res || targetSumSubset_rec(arr, indx + 1, target - arr[indx]);
        }

        return res;
    }

    //Humne dp Boolean ka bnaya he instead of boolean ka
    //cauz hum null check kr ske agr curr subproblem abhitak solve nhi hui

    //boolean arr[] stores false as default value
    //but false toh humare answer ka part he
    //Remember the default value being considered for dp[][] should never be
    //part of ans

    //me currIndex ko use krke abhitak ka target bna paya ki nhi
    public static boolean targetSumSubset_memo(int[] arr, int indx, int target, Boolean[][] dp) {
        if(target == 0) return dp[indx][target] = true;
        if(indx == arr.length) {
            return dp[indx][target] = false;
        }

        if(dp[indx][target] != null) {
            return dp[indx][target];
        }

        boolean res = false;
        // yes call
        if(target - arr[indx] >= 0) {
            res = targetSumSubset_rec(arr, indx + 1, target - arr[indx]);
        }
        // no call
        res = res || targetSumSubset_rec(arr, indx + 1, target);
        return dp[indx][target] = res;
    }

    public static boolean targetSumSubset_tab1(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];

        for(int indx = 0; indx < dp.length; indx++) {
            for(int targ = 0; targ < dp[0].length; targ++) {
                if(targ == 0) {
                    dp[indx][targ] = true;
                } else if(indx == 0) {
                    dp[indx][targ] = false;
                } else {
                    int val = arr[indx - 1];
                    if(targ < val) {
                        // only no call
                        dp[indx][targ] = dp[indx - 1][targ];
                    } else {
                        // no call OR(||) yes call
                        dp[indx][targ] = dp[indx - 1][targ] || dp[indx - 1][targ - val];
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static boolean targetSumSubset_tab2(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        for(int indx = arr.length; indx >= 0; indx--) {
            for(int targ = 0; targ <= target; targ++) {
                if(targ == 0) {
                    dp[indx][targ] = true;
                    continue;
                }

                if(indx == arr.length) {
                    dp[indx][targ] = false;
                    continue;
                }

                boolean res = false;
                // yes call
                if(targ - arr[indx] >= 0) {
                    res = dp[indx + 1][targ - arr[indx]];
                }
                // no call
                res = res || dp[indx + 1][targ];
                dp[indx][targ] = res;
            }
        }
        return dp[0][target];
    }


}
/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add
     up to "tar" or not.

Sample Input
5
4
2
7
1
3
10
Sample Output
true
 */
