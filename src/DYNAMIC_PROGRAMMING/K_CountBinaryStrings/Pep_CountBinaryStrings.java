package DYNAMIC_PROGRAMMING.K_CountBinaryStrings;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-binary-strings-official/ojquestion
public class Pep_CountBinaryStrings {

    // ~~~~~~~~~~~~~~~~~~~Count Binary Strings~~~~~~~~~~
    public static int countBinaryStrings_rec(int n, int lastEleAppended, String asf) {
        if(n == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        // check is to prevent repition of consecutive zero's
        if(lastEleAppended == 1) {
            count += countBinaryStrings_rec(n - 1, 0, asf + " 0");
            count += countBinaryStrings_rec(n - 1, 1, asf + " 1");

        }
        else if(lastEleAppended == 0)
            count += countBinaryStrings_rec(n - 1, 1, asf + " 1");

        return count;
    }

    public static int countBinaryStrings_memo(int n, int lastEleAppended, int[][] dp) {

        //"0" = 1
        //"1" = 1
        if(n == 0) {
            return dp[n][lastEleAppended] = 1;
        }

        if(dp[n][lastEleAppended] != 0) return dp[n][lastEleAppended];

        int countAtCurrLvl = 0;
        // check is to prevent repition of consecutive zero's
        if(lastEleAppended == 1) {
            int countOfLvlsAbove = countBinaryStrings_memo(n - 1, 0, dp);
            countAtCurrLvl+=countOfLvlsAbove;
        }

        int countOfLvlsAbove = countBinaryStrings_memo(n - 1, 1, dp);
        countAtCurrLvl+=countOfLvlsAbove;

        return dp[n][lastEleAppended] = countAtCurrLvl;
    }

    public static int countBinaryString_tab(int N) {
        int[][] dp = new int[2][N];

        dp[0][0] = 1;
        dp[1][0] = 1;

        for(int n = 1; n < N; n++){
            dp[n][0] = dp[n - 1][1];
            dp[n][1] = dp[n - 1][0] + dp[n - 1][1];
        }

        return dp[N - 1][0] + dp[N - 1][1];
    }

    public static int countBinaryString_optimise(int n) {
        int zero = 1;
        int one = 1;

        for(int i = 2; i <= n; i++) {
            int n_zero = one;
            int n_one = one + zero;

            zero = n_zero;
            one = n_one;
        }
        return one + zero;
    }



}
/*
1. You are given a number n.
2. You are required to print the number of binary strings of length n with no
consecutive 0's.
Sample Input
6
Sample Output
21
 */
