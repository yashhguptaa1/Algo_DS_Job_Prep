package RECURSION.Type_R3.P1_PRE.SingleRecCall;

public class FindIndexOfFirstOccurenceV2 {

    public static int firstIndex(int[] arr, int idx, int data,int res){

        if(idx < 0)
        {
            return res;
        }
        if(data == arr[idx])
        {
            res = idx;
        }
        return firstIndex(arr,idx-1,data,res);
    }
}
