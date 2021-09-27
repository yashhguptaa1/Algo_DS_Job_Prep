package RECURSION.DivideAndConquer;

import java.util.*;
public class G_QuickSelect_KthLargest {

    // TO find kth largest
    //pass n-k in below code
    //This code helps in finding kth smallest number


//we dont need BASE CASE as we will definitely find Kth index
//even before reaching BASE CASE
//BC is needed to stop recursion but we are getting k
//we can check for invalid k before hand

    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        int pivot = arr[hi];
        int pi = partitionIndex(arr, lo, hi, pivot);

        int ans = 0;
        if(pi == k) {
            // found
            ans = pivot;
        } else if(pi > k) {
            // answer is on left side
            ans = quickSelect(arr, lo, pi - 1, k);
        } else {
            // answer is on right side
            ans = quickSelect(arr, pi + 1, hi, k);
        }
        return ans;
    }

    // It returns index of pivot element after placing it at correct Index
    //thus, it also rearranges the array

    public static int partitionIndex(int[] arr,int lo,int hi, int pivot){
        //write your code here
        int IdxFirst_Unsolved=lo;
        int IdxFirst_SolvedGreater =lo;

        while (IdxFirst_Unsolved <= hi)
        {
            //cases
            if(arr[IdxFirst_Unsolved] <= pivot)
            {
                swap(arr,IdxFirst_Unsolved,IdxFirst_SolvedGreater);
                IdxFirst_Unsolved++;
                IdxFirst_SolvedGreater++;

            }
            else if(arr[IdxFirst_Unsolved] > pivot)
            {
                IdxFirst_Unsolved++;
            }
        }
        return IdxFirst_SolvedGreater - 1;
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //TC : O(NlogK)
//SC: O(logK)

    class Solution {
        public int findKthLargest(int[] nums, int k) {

            //TopMost element will be smallest in whole heap
            //but we are storing k largest elements in heap
            //it means kth element ,which is element at top of heap
            //will kth largest
            PriorityQueue<Integer>minHeap=new PriorityQueue<>();

            for(int i=0;i<nums.length;i++)
            {
                if(i<k)
                    minHeap.add(nums[i]);

                else{
                    if(nums[i] > minHeap.peek())
                    {
                        minHeap.remove();
                        minHeap.add(nums[i]);
                    }
                }
            }

            return minHeap.peek();
        }
    }

}
