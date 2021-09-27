package RECURSION.DivideAndConquer.BinarySearch.Unsorted;

public class B_IB_SearchBitonicArr {

    public int solve(int[] arr, int x) {

        int n = arr.length;

        int bitonicPivot = findPeak(arr, x, 0, n - 1, n);
        int leftCheck = bsAsc(arr, x, 0, bitonicPivot);
        int rightCheck = bsDesc(arr, x, bitonicPivot, n - 1);

        if (leftCheck != -1)
            return leftCheck;

        return rightCheck;
    }

    public int findPeak(int nums[], int x, int low, int high, int n) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == n - 1 || nums[mid + 1] < nums[mid])) {
                return mid;

            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;

            } else
                low = mid + 1;
        }

        return -1;
    }

    public int bsAsc(int arr[], int x, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (x == arr[mid])
                return mid;

            else if (x > arr[mid])
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }

    public int bsDesc(int arr[], int x, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (x == arr[mid])
                return mid;

            else if (x < arr[mid])
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }
}
