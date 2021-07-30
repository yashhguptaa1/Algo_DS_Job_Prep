package A_recursion.DivideAndConquer.BinarySearch.SortedArr;

import java.util.*;
public class E_IB_SortedInsertPosition {

//find ceil index if element not found
    //since there are no duplicates return the index if element found

    public int searchInsert(ArrayList<Integer> a, int b) {

        int low=0;
        int high=a.size()-1;
        int ceilIdx=0;

        if(b<a.get(0))
            return 0;
        if(b>a.get(high))
            return high+1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(b==a.get(mid))
                return mid;

            else if(b<a.get(mid))
            {
                /*
                 A = [1, 3, 5, 6]
                 B = 2

                 Note we would insert 2 at index 1
                 Index 1 is the ceil index for given element 2

                 ceil index is updated as we are going towards left
                 when we find element at mid is greater than current element
                 */
                ceilIdx=mid;
                high=mid-1;

            }
            else
            {
                low=mid+1;
            }
        }

        return ceilIdx;

    }
}
