package B_ARRAYS.P2_Store_left_right;

public class partitionDisjoint {

    public int partitionDisjoint1(int[] nums) {
        int n = nums.length;

        // 1. right min creation
        int[] rightmin = new int[n];
        rightmin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmin[i] = Math.min(nums[i], rightmin[i + 1]);
        }

        // 2. travel and solve, also maintaion left max simultaneously
        int leftmax = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            leftmax = Math.max(leftmax, nums[i]);
            if (leftmax <= rightmin[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans + 1;
    }

    // method 2 -> with O(1) space
    public int partitionDisjoint2(int[] nums) {
        int leftmax = nums[0];
        int maxInRun = nums[0];
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxInRun) {
                maxInRun = nums[i];
            } else if (nums[i] < leftmax) {
                ans = i;
                leftmax = maxInRun;
            }
        }
        return ans + 1;
    }
}
