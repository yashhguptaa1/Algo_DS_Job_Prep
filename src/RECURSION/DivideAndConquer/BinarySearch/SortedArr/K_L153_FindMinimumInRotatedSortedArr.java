package A_recursion.DivideAndConquer.BinarySearch.SortedArr;

public class K_L153_FindMinimumInRotatedSortedArr {
    public int findMin(int[] a) {

        int n=a.length;

        int lo =0 ;
        int hi = n-1;

        //Zero Rotation
        if(a[lo]<=a[hi])
            return a[lo];

        while(lo <= hi)
        {
            int mid =(lo+hi)/2;

            //lo --- 7  0  --- high
            //          MID
            if(mid>0 && a[mid] < a[mid-1] )
            {
                return a[mid];
            }
            //lo --- 8   0 --- high
            //       MID
            else if(mid<n && a[mid] > a[mid+1])
            {
                return a[mid+1];
            }

            //Note
            //we find pivot in the unsorted part of array

            //lo --- pivot --- mid --- high
            //check mid  se hi tak ka array sorted he kya
            else if(a[mid] <= a[hi])
            {
                hi = mid-1;
            }
            // lo ---- mid ---- pivot --- high
            //check lo se mid tak ka array sorted he kya
            else if(a[lo] <= a[mid])
            {
                lo=mid+1;
            }

        }
        return -1;

    }
}
