package RECURSION.DivideAndConquer.BinarySearch.SortedArr;

public class J_L33_SearchInRotatedArr {

    public int search(int[] arr, int x) {

        int lo = 0;
        int hi=arr.length-1;

        while(lo <= hi)
        {
            int mid = (lo+hi)/2;

            if(arr[mid] == x)
            {
                return mid;
            }

            //Case1
            // lo ---- mid ---- pivot --- high
            //check lo se mid tak ka array sorted he kya
            else if(arr[lo] <= arr[mid])
            {
                //ab lo to mid part is sorted
                //Check if x (target) lies in this range
                if(x >= arr[lo] && arr[mid] > x)
                {

                    // lo -X-- mid ---- pivot --- high

                    hi = mid-1;
                }
                else{

                    // lo ---- mid --X-- pivot --- high

                    lo = mid +1;
                }


            }
            //Case2
            //lo --- pivot --- mid --- high

            //check mid  se hi tak ka array sorted he kya
            else if(arr[mid] <= arr[hi])
            {
                //ab mid to hi part is sorted
                //if target lies in range of second half
                if(x > arr[mid] && arr[hi] >= x)
                {
                    //lo --- pivot --- mid -X-- high

                    lo=mid+1;
                }
                else
                {
                    //lo --- pivot -X-- mid --- high

                    hi =mid-1;
                }
            }
        }
        return -1;
    }

}
