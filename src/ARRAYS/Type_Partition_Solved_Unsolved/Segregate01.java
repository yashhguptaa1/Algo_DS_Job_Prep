package ARRAYS.Type_Partition_Solved_Unsolved;

public class Segregate01 {

    static void binSort(int arr[], int N)
    {
        //Used to traverse whole arr
        int IdxFirstUnsolved = 0;

        //the part of array from index 0 to index firstOneOfSorted1s-1
        //is the SORTED SEGMENT OF array
        //rest is yet unsorted
        int firstOneOfSorted1s = 0;

        while (IdxFirstUnsolved < arr.length && firstOneOfSorted1s< arr.length)
        {
            if(arr[IdxFirstUnsolved] == 1)
            {
                IdxFirstUnsolved ++;
            }
            else
            {
                int temp=arr[IdxFirstUnsolved];
                arr[IdxFirstUnsolved]=arr[firstOneOfSorted1s];
                arr[firstOneOfSorted1s]=temp;

                IdxFirstUnsolved++ ;
                firstOneOfSorted1s++ ;
            }
        }
        return;

    }

}

/*
https://practice.geeksforgeeks.org/problems/binary-array-sorting-1587115620/1

Given a binary array A[] of size N. The task is to arrange the array in increasing order.
Note: The binary array contains only 0  and 1.


Example 1:

Input:
5
1 0 1 1 0

Output:
0 0 1 1 1

Explanation:
After arranging the elements in
increasing order, elements will be as
0 0 1 1 1.
 */