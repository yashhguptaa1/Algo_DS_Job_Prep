package DYNAMIC_PROGRAMMING.A_FibonacciSeries;

public class Fibonacci {


    // ~~~~~~~~~~~~~~~Fibbonacci~~~~~~~~~~~~
//package RECURSION.Type_R2_PostPhase.Work_ReturnAns_in_PostPhase.MultipleRecCall;
    public static int fib_rec(int n) {

        if (n == 0 || n == 1)
            return n;

        int fibnm1 = fib_rec(n - 1);
        int fibnm2 = fib_rec(n - 2);

        //Values returned by calls will be stored in array
        int fibn = fibnm1 + fibnm2;

        return fibn;
    }

    public static int fib_memo(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return dp[n] = n;
        }

        //IN PREORDER PHASE
        //before traversing the next subtree
        // 1. if Problem is already solved, then return the answer
        if (dp[n] != 0) {
            return dp[n];
        }

        int fibnm1 = fib_memo(n - 1, dp);
        int fibnm2 = fib_memo(n - 2, dp);

        int fibn = fibnm1 + fibnm2;
        // 2. If not solved, then solve the problem and store it in the dp
        return dp[n] = fibn;
    }

    public static int fib_tab(int n) {

        // 1. figure out repitition -> repitition on N
        // 2. make a storage of size -> n + 1
        //since we need a single parameter (n) to compare two nodes
        //if they are same (repeating)
        //we build 1D dpArray
        int dp[]=new int[n+1];

        // 5. pre requisite -> base case
        dp[0] = 0;
        dp[1] = 1;

        // 4. Figure out the direction of smallest problem(at n = 0)
        //    to largest problem
        for (int i = 2; i <= n; i++) {

            // 3. assign meaning to cell -> dp[i] = fib[i] = fib[i - 1] + fib[i - 2]
            //From recursion tree diag
            //2 branches = 2 rec calls = 2options
            //option1: dp[i-1]
            //option2: dp[i-2]
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int fib_btr(int n) {
        int a = 0;
        int b = 1;

        while (n-- > 0) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void fib() {
        int n = 10;
        // int res = fib_rec(n);
        int[] dp = new int[n + 1];
        // int res = fib_memo(n, dp);
        // int res = fib_tab(n, dp);
        int res = fib_btr(n);
        System.out.println(res);
    }
}
