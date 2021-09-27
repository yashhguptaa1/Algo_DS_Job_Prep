package RECURSION.DivideAndConquer.Sorting;

public class MergeSortArrays {



    public static int[] mergeSort(int[] arr, int lo, int hi) {

        //CONQUER
        // base case
        //Solve it Directly
        if(lo == hi) {
            int[] bres = new int[1];
            bres[0] = arr[lo];
            return bres;
        }

        //Find Dividing factor
        int mid = lo + (hi - lo) / 2;

        //DIVIDE main problem into subproblem
        int[] arr1 = mergeSort(arr, lo, mid);
        int[] arr2 = mergeSort(arr, mid + 1, hi);

        //COMBINE
        int[] res = mergeTwoSortedArrays(arr1, arr2);

        return res;
    }


    //CONQUER
    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        int s1 = arr1.length;
        int s2 = arr2.length;

        int[] res = new int[s1 + s2];

        int i = 0; // itr for arr1
        int j = 0; // itr for arr2
        int k = 0; // help to fill the res

        while(i < s1 || j < s2) {
            int ival = i < s1 ? arr1[i] : Integer.MAX_VALUE;
            int jval = j < s2 ? arr2[j] : Integer.MAX_VALUE;

            if(ival > jval) {
                res[k] = jval;
                j++;
            } else {
                res[k] = ival;
                i++;
            }
            k++;
        }

        return res;
    }

}
