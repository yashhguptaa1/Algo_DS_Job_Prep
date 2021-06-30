package B_ARRAYS.Type_Partition_Solved_Unsolved;

import java.util.Scanner;

public class PartitionIndexArray {

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

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = scn.nextInt();
        System.out.println(partitionIndex(arr,0, arr.length-1,pivot));
        print(arr);
    }

}
