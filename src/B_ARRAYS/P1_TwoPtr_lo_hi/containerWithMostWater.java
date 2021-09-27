package B_ARRAYS.P1_TwoPtr_lo_hi;

public class containerWithMostWater {

    public int maxArea(int[] height) {
        // initialize

        // result variable
        int maxWater = 0;
        // low ptr
        int lo = 0;
        // high ptr
        int hi = height.length - 1;

        // Loop untill the two ptrs converge
        while (lo < hi) {

            // Update vars, solve problem
            int length = hi - lo;
            int minHeight = Math.min(height[lo], height[hi]);
            int water = length * minHeight;
            maxWater = Math.max(maxWater, water);

            // Conditions when to move which pointer
            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        return maxWater;
    }
}
