package RECURSION.DivideAndConquer.BinarySearch.PivotSortedRotated;

public class PivotInSortedRotatedArray {


    public static int pivotInSortedRotated(int[] arr, int lo, int hi) {
        if(lo == hi) {
            return arr[lo];
        }
        int mid = lo + (hi - lo) / 2;
        int res = 0;
        if(arr[mid] < arr[hi]) {
            // left side -> including mid
            res = pivotInSortedRotated(arr, lo, mid);
        } else {
            // right side
            res = pivotInSortedRotated(arr, mid + 1, hi);
        }
        return res;
    }

    // find pivot in iterative way
    public static int findPivot(int[] arr) {
        // write your code here
        int lo = 0;
        int hi = arr.length - 1;

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] < arr[hi]) {
                // left side -> including mid
                hi = mid;
            } else {
                // right side
                lo = mid + 1;
            }
        }
        return arr[lo];
    }

    
}
