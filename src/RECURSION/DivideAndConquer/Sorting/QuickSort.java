package RECURSION.DivideAndConquer.Sorting;

public class QuickSort {

    public static void quickSort(int[] arr, int lo, int hi) {
        if(lo > hi) return;

        //Dividing factor
        int pivot = arr[hi];
        int pi = partitionIndex(arr, lo, hi, pivot);

        //DIVIDE and COMBINE
        quickSort(arr, lo, pi - 1);
        quickSort(arr, pi + 1, hi);
    }

    //CONQUER
    public static int partitionIndex(int[] arr, int lo, int hi, int pivot) {
        int i = lo;
        int j = lo;

        while(i <= hi) {
            if(arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j - 1;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
