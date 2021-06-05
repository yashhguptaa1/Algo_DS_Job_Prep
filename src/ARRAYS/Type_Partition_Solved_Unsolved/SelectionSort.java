package ARRAYS.Type_Partition_Solved_Unsolved;

public class SelectionSort {

    void selectionSort(int arr[], int n)
    {

        for(int lastIdx_SolvedSegment = 0; lastIdx_SolvedSegment < n-1; lastIdx_SolvedSegment++)
        {
            //Idx_SmallerELeThanLastSolved
            int minIdx = lastIdx_SolvedSegment;

            //j points to index of first Unsolved Segment
            int firstIdx_UnsolvedSegment = lastIdx_SolvedSegment+1;
            for(int j=firstIdx_UnsolvedSegment; j < n; j++)
            {
                if(arr [j] < arr[minIdx])
                    minIdx = j;
            }

            //Our left subarray is a sorted segment
            //From this sorted segment pick last ele which would be bigger than
            //all ele of sorted segment
            //if there is an ele in unsorted segment which is smaller than this last element
            // we swap so smaller ele becomes part of sorted subaarray
            swap( arr , lastIdx_SolvedSegment ,minIdx);
        }


    }
    // used for swapping ith and jth elements of array
    public void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
Given an unsorted array of size N, use selection sort to sort arr[] in increasing order.


Example 1:

Input:
N = 5
arr[] = {4, 1, 3, 9, 7}
Output:
1 3 4 7 9
Explanation:
Maintain sorted (in bold) and unsorted subarrays.
Select 1. Array becomes 1 4 3 9 7.
Select 3. Array becomes 1 3 4 9 7.
Select 4. Array becomes 1 3 4 9 7.
Select 7. Array becomes 1 3 4 7 9.
Select 9. Array becomes 1 3 4 7 9.
Example 2:

Input:
N = 10
arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
Output:
1 2 3 4 5 6 7 8 9 10
 */