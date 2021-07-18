package DYNAMIC_PROGRAMMING.Pattern1.A_FibonacciSeries;

public class A_Fibonacci {


    // ~~~~~~~~~~~~~~~Fibbonacci~~~~~~~~~~~~
//package RECURSION.Type_R2_PostPhase.Work_ReturnAns_in_PostPhase.MultipleRecCall;
    public static int fib(int n) {

        if (n == 0 || n == 1)
            return n;

        int fibnm1 = fib(n - 1);
        int fibnm2 = fib(n - 2);

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

        if(n==0)
            return 0;

        if(n==1)
            return 1;

        // 1. figure out repitition -> repitition on N
        // 2. make a storage of size -> n + 1
        //since we need a single parameter (n) to compare two nodes
        //if they are same (repeating)
        //we build 1D dpArray
        int dp[]=new int[n+1];

        // 5. pre requisite -> base case
        //My Work to do
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

/*

1. You are given a number n.
2. You are required to print the nth element of fibonnaci sequence.

Note -> Notice precisely how we have defined the fibonnaci sequence
0th element -> 0
1st element -> 1
2nd element -> 1
3rd element -> 2
4th element -> 3
5th element -> 5
6th element -> 8

Sample Input
10
Sample Output
55
 */