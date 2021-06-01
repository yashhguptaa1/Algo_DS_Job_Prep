package RECURSION.Type_R1_PrePhase.Return_in_PrePhase;

public class FindIndexOfLastOccurenceV1 {

    public static int lastIndexv1(int[] arr, int idx, int x){

        if(idx < 0 )
            return -1;

        if(arr[idx] == x)
            return idx;

        return lastIndexv1(arr,idx-1,x);
    }
}
