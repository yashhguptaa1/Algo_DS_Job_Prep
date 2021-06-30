package RECURSION.DivideAndConquer.BinarySearch.SortedArr;

public class D_IB_SmallerorEqualElements {
    public int solve(int[] arr, int x) {

        int low=0;
        int high=arr.length-1;
        int res=0;

        if(x<arr[0])
            return 0;

        if(x >= arr[high])
            return high+1;


        while(low<=high)
        {
            int mid=(low+high)/2;

            if(x>=arr[mid])
            {
                //Since we have to count duplicates also
                //The concept used here is from
                //Q) Find last occurence in given sorted duplicates array
                low=mid+1;
            }
            else if(x<arr[mid])
            {
                // The concept used here is from
                //Q) Find Ceil index
                res=mid;
                high=mid-1;
            }
        }

        return res;

    }

}
/*
Problem Description

Given an sorted array A of size N. Find number of elements which are less than or equal to B.

NOTE: Expected Time Complexity O(log N)



Problem Constraints
1 <= N <= 106

1 <= A[i], B <= 109



Input Format
First agument is an integer array A of size N.

Second argument is an integer B.



Output Format
Return an integer denoting the number of elements which are less than or equal to B.



Example Input
Input 1:

 A = [1, 3, 4, 4, 6]
 B = 4
Input 2:

 A = [1, 2, 5, 5]
 B = 3


Example Output
Output 1:

 4
Output 2:

 2
 */