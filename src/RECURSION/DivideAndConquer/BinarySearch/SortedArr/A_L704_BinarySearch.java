package A_recursion.DivideAndConquer.BinarySearch.SortedArr;


public class A_L704_BinarySearch {

    //RECURSIVE SOLUTION
    //RETURN TYPE BOOLEAN
    public static boolean binarySearchRec(int[] arr, int lo, int hi, int data) {

        //BASE CASE
        if(lo > hi) {
            return false;
        }

        //DIVING FACTOR
        int mid = lo + (hi - lo) / 2;

        //ANSWER VARIABLE
        boolean res = false;

        //CONQUER SINGLE ELEMENT
        if(arr[mid] == data) {
            res = true;
        }

        //DISCARD LEFT HALF OF SEARCH SPACE
        else if(arr[mid] < data) {
            res = binarySearchRec(arr, mid + 1, hi, data);
        }

        //DISCARD RIGHT HALF OF SEARCH SPACE
        else {
            res = binarySearchRec(arr, lo, mid - 1, data);
        }

        //RETURN RESULT SO FAR
        return res;
    }

    //RECURSIVE SOLUTION
    //RETURN TYPE INT
    public static int binarySearchRecIndx(int[] arr, int lo, int hi, int data) {

        //BASE CASE
        if(lo > hi) {
            return -1;
        }

        //DIVIDING FACTOR
        int mid = lo + (hi - lo) / 2;

        //ANSWER VARIABLE
        int res = -1;

        //CONQUER SINGLE ELEMENT
        if(arr[mid] == data) {
            res = mid;
        }

        //DISCARD LEFT HALF OF SEARCH SPACE
        else if(arr[mid] < data) {
            res = binarySearchRecIndx(arr, mid + 1, hi, data);
        }

        //DISCARD RIGHT HALF OF SEARCH SPACE
        else {
            res = binarySearchRecIndx(arr, lo, mid - 1, data);
        }

        //RETURN RESULT SO FAR
        return res;
    }

    // Driver method to test above
    public static void main(String args[])
    {
        A_L704_BinarySearch ob = new A_L704_BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = binarySearchRecIndx(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}

/*
704. Binary Search
Easy

1443

64

Add to List

Share
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.

Binary Search me hum dimag me yeh baat rkhte he ki konsa part of search space hum discard kr skte he
Sorted array word he toh 99% BS lgta he
BS can be used for non sorted array too
 */