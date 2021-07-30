package A_recursion.DivideAndConquer.BinarySearch.Unsorted;

public class A_L162_PeakElement {

    public int findPeakElement(int[] nums) {

        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            //GIVEN You may imagine that nums[-1] = nums[n] = -∞.
            //Combining 4 Edge cases in one
            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == n - 1 || nums[mid + 1] < nums[mid])) {
                return mid;

            }

            //Left Neighbor is greater than X
            //We can find peak element on left of X
            else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;

            }

            //Right Neighbor is greater than X
            //We can find peak element on right of X
            else
                low=mid+1;
        }

        return -1;
    }

}
