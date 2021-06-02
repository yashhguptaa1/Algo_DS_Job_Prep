package ARRAYS.Type_Partition_Solved_Unsolved;

public class InsertionSort {

    public void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int firstIdx_UnsolvedSegment = 1; firstIdx_UnsolvedSegment < n; firstIdx_UnsolvedSegment ++) {
            int currElementToBeSorted = arr[firstIdx_UnsolvedSegment];

            //Initialize Pointer j from last index of Sorted/Solved Segment
            int lasIdx_SolvedSegment= firstIdx_UnsolvedSegment - 1;
            int j = lasIdx_SolvedSegment;

			/* Move elements of arr[0..i-1], that are
			greater than currElementToBeSorted, to one position ahead
			of their current position */
            while (j >= 0 && arr[j] > currElementToBeSorted) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            //when we break out of loop above
            //at index j we have element which is smaller(or equal) to currElementToBeSorted
            arr[j + 1] = currElementToBeSorted;
        }
    }
}

// THINK RECURSIVELY ALSO

/*
The task is to complete the insert() function which is used to implement Insertion Sort.


Example 1:

Input:
N = 5
arr[] = { 4, 1, 3, 9, 7}
Output:
1 3 4 7 9
Example 2:

Input:
N = 10
arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
Output:
1 2 3 4 5 6 7 8 9 10
 */