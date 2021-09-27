package B_ARRAYS.P0_Specialized.Segregate_Mark_ArrIndex;

public class firstMissingPositive {

    public int firstMissingPos(int[] nums) {
        int n = nums.length;
        // step 1. find occurence of one and mark out of range element
        boolean one = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                one = true;

            if (nums[i] < 1 || n < nums[i]) {
                nums[i] = 1;
            }
        }
        if (one == false)
            return 1;
        // step 2. mark element in array
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            int indx = val - 1;
            nums[indx] = -Math.abs(nums[indx]);
        }

        // step 3. check first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
