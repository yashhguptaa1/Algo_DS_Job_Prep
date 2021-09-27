package RECURSION.DivideAndConquer.BinarySearch.SortedArr;

public class B_L34_FindFirstLastOcc {

    public int[] searchRange(int[] nums, int target) {

        int res[] = new int[2];

        // firstIndex
        res[0] = findFirstLastOccItr(nums, target, true);

        // lastIndex
        res[1] = findFirstLastOccItr(nums, target, false);

        return res;

    }

    public int IB_CountElementOccurence(final int[] arr, int x) {

        int firstIndex = findFirstLastOccItr(arr, x, true);
        int lastIndex = findFirstLastOccItr(arr, x, false);

        // Element not found
        if (firstIndex == -1)
            return 0;

        return (lastIndex - firstIndex) + 1;
    }

    public int findFirstLastOccItr(int arr[], int x, boolean searchFirst) {
        int low = 0;
        int high = arr.length - 1;
        int resIdx = -1;

        // forgot to use equalto sign
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                resIdx = mid;
                if (searchFirst)
                    high = mid - 1;
                else
                    low = mid + 1;
            }

            else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return resIdx;
    }

    // NOTE YOU ARE WORKING ON THE WAY UP
    // So It will be similar to
    // RECURSION.Type_R1_PrePhase.Work_in_PrePhase.Return_Ans_in_BaseCase;
    public static int findFirstLastOccRec(int arr[], int x, int low, int high, boolean searchFirst, int resIdx) {
        // BASE CASE
        if (high < low)
            return resIdx;

        // DIVING FACTOR
        int mid = (low + high) / 2;

        // CONQUER SINGLE ELEMENT
        if (arr[mid] == x) {
            resIdx = mid;

            // DISCARD RIGHT HALF OF SEARCH SPACE
            if (searchFirst)
                resIdx = findFirstLastOccRec(arr, x, low, mid - 1, searchFirst, resIdx);

            // DISCARD LEFT HALF OF SEARCH SPACE
            else
                resIdx = findFirstLastOccRec(arr, x, mid + 1, high, searchFirst, resIdx);
        }

        else if (arr[mid] < x) {
            // DISCARD LEFT HALF OF SEARCH SPACE
            resIdx = findFirstLastOccRec(arr, x, mid + 1, high, searchFirst, resIdx);
        } else if (arr[mid] > x) {
            // DISCARD RIGHT HALF OF SEARCH SPACE
            resIdx = findFirstLastOccRec(arr, x, low, mid - 1, searchFirst, resIdx);
        }

        return resIdx;
    }

    public static int[] searchRangeRec(int[] nums, int target) {

        int n = nums.length;

        int res[] = new int[2];

        // firstIndex
        res[0] = findFirstLastOccRec(nums, target, 0, n - 1, true, -1);

        // lastIndex
        res[1] = findFirstLastOccRec(nums, target, 0, n - 1, false, -1);

        return res;

    }

    // Driver method to test above
    public static void main(String args[]) {

        int arr[] = { 5, 7, 7, 8, 8, 10 };
        int n = arr.length;
        int x = 8;
        int result[] = searchRangeRec(arr, x);

        System.out.println("Element first " + result[0]);
        System.out.println("Element found at index " + result[1]);

    }
}

/*
 * 34. Find First and Last Position of Element in Sorted Array Medium Given an
 * array of integers nums sorted in ascending order, find the starting and
 * ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1] Example 3:
 * 
 * Input: nums = [], target = 0 Output: [-1,-1]
 */