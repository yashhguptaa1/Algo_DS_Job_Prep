package RECURSION.Type_R3_Store_Use_Val.P1_Work_in_PrePhase.Return_in_BaseCase;

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
