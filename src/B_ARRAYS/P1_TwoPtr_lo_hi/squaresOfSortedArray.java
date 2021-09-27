package B_ARRAYS.P1_TwoPtr_lo_hi;

public class squaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {

        // res : new array that stores final result in sorted manner
        int[] res = new int[nums.length];

        // Given : nums array is sorted from -ve to +ve
        // Maximum squared value can be achieved by squaring
        // the least negative value
        int lo = 0;
        // the highest positive value
        int hi = nums.length - 1;

        // since squaring numbers at index i or j will result in max value
        // start filling res from the last index which denotes highest value
        for (int k = nums.length - 1; k >= 0; k--) {
            int val1 = nums[lo] * nums[lo];
            int val2 = nums[hi] * nums[hi];

            if (val1 > val2) {
                res[k] = val1;
                lo++;
            } else {
                res[k] = val2;
                hi--;
            }
        }
        return res;
    }
}
