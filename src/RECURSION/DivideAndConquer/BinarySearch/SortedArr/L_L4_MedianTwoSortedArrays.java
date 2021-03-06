package RECURSION.DivideAndConquer.BinarySearch.SortedArr;

public class L_L4_MedianTwoSortedArrays {

    // TC : O(log(n+m))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int a[];
        int b[];

        // we are considering array b is bigger as binary search array a
        // pr chla rhe he but traverse b pr bhi krrhe he
        if (nums1.length > nums2.length) {
            b = nums1;
            a = nums2;
        } else {
            a = nums1;
            b = nums2;
        }

        // double ans = 0.0;
        int lo = 0;
        int hi = a.length;
        int te = a.length + b.length;

        while (lo <= hi) {
            int cut1 = (lo + hi) / 2;

            // taking care of odd number of elements by taking (te+1)
            int cut2 = (te + 1) / 2 - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
            int right1 = (cut1 == a.length) ? Integer.MAX_VALUE : a[cut1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];
            int right2 = (cut2 == b.length) ? Integer.MAX_VALUE : b[cut2];

            // valid segregation
            if (left1 <= right2 && left2 <= right1) {
                double median = 0.0;

                if (te % 2 == 0) {
                    int lmax = Math.max(left1, left2);
                    int rmin = Math.min(right1, right2);

                    median = (lmax + rmin) / 2.0;
                } else {
                    int lmax = Math.max(left1, left2);
                    median = lmax;
                }

                return median;
            } else if (left1 > right2) {
                // there are more elements to be picked in
                // left part 'b' array

                hi = cut1 - 1;

            } else if (left2 > right1) {
                // there are more element to be picked in left
                // part 'a' array

                lo = cut1 + 1;
            }
        }
        return 0.0;
    }
}

/*
 * Let m=5 and n = 7 Combined elements =12 Median will be average of (12/2 =
 * 6)th element and (12/2+1 = 7)th element
 * 
 * That is our goal to achieve a unique boundary such that we get the same
 * number of elements on either of boundary
 * 
 * that is for n =12 we want 6 smaller elements in increasing order on left and
 * 6 bigger elements on right
 * 
 * First approach : brute approach Merge Two Sorted Arrays Calculate their size
 * if odd return middle if even return average of (n/2) and (n/2)+1
 * 
 * Second Approach : Find appropriate point of segregation without merging since
 * arrays are sorted in order we can do it without merging a - > a0 a1 a2 | a3
 * a4 a5 --- b - > b0 b1 b2 b3 | b4 b5 b6 b7 Total elements= 6 + 8 =14 to check
 * if segregation boundary is ok mid = 7 we have to make sure The bunch of
 * elements from first 7{a0 - a2 and b0 - b3} are less than last 7{a3 - a5 and
 * b4 - b7}
 * 
 * //Check 1 1) a2 <= b4 AND 2) b3 <= a3
 * 
 * if(valid) median =(max(a2,b3) + min(a3,b4))/2 [even size] median = max(a2,b3)
 * [odd size]
 * 
 * if(not valid) move segregation boundary such that number of elements on
 * either side remain 7 1) if a2 > b4 now segregation will be The bunch of
 * elements from first 7{a0 - a1 and b0 - b4} are less than last 7{a2 - a5 and
 * b5 - b7} a - > a0 a1 | a2 a3 a4 a5 --------- b - > b0 b1 b2 b3 b4 | b5 b6 b7
 * 
 * 
 * 2) if b3 > a3 now segregation will be The bunch of elements from first 7{a0 -
 * a3 and b0 - b2} are less than last 7{a4 - a5 and b3 - b7} a - > a0 a1 a2 a3 |
 * a4 a5 --- b - > b0 b1 b2 | b3 b4 b5 b6 b7
 * 
 * 
 */