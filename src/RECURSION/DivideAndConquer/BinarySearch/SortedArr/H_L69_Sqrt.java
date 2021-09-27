package RECURSION.DivideAndConquer.BinarySearch.SortedArr;

public class H_L69_Sqrt {
    public int mySqrt(int x) {

        /*
         * Let n be square root of we want to find largest integer n such that n^2 <=x
         * TO do so we can binary search the interval 1 to n
         */
        int lo = 1;
        int hi = x;
        int ans = 0; // For A= 0 ,ans =0

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid <= (long) x) {
                // Store our best answer so far
                // This concept is from
                // Q)C_Finding Floor of given number in sorted arr
                ans = (int) mid;
                lo = (int) mid + 1;
            } else {
                // mid^2 > n , so we need to look at smaller numbers
                hi = (int) mid - 1;
            }
        }
        return ans;
    }
}
