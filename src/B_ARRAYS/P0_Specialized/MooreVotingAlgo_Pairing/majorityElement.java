package B_ARRAYS.P0_Specialized.MooreVotingAlgo_Pairing;

public class majorityElement {

    public int majorityEle(int[] nums) {
        int val = nums[0];
        int count = 1;

        int i = 1;
        while (i < nums.length) {
            if (val == nums[i]) {
                // increase the count of same element
                count++;
            } else {
                if (count > 0) {
                    // pair up distinct elements
                    count--;
                } else {
                    // all distinct elements have been paired up till now
                    // start pairing with curr element
                    val = nums[i];
                    count = 1;
                }
            }
            i++;
        }
        // majority always exist, so val is result
        return val;
    }
}
