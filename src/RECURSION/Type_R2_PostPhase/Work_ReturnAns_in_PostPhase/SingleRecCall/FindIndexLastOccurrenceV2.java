package A_recursion.Type_R2_PostPhase.Work_ReturnAns_in_PostPhase.SingleRecCall;

public class FindIndexLastOccurrenceV2 {
    public static int lastIndex(int[] arr, int idx, int x){

        if(idx == arr.length)
            return -1;

        int recIdx=lastIndex(arr,idx+1,x);

        if(recIdx == -1)
        {
            if(arr[idx] == x)
                recIdx = idx;
        }

        return recIdx;
    }

}
