package B_ARRAYS.P0_Specialized.Segregate_Mark_ArrIndex;

public class sortArrayParity {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0; // first unsolved
        int j = 0; // first odd

        while (i < nums.length) {
            if (nums[i] % 2 == 0) {
                // even
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j++;
            } else {
                // odd
                i++;
            }
        }
        return nums;
    }

}
