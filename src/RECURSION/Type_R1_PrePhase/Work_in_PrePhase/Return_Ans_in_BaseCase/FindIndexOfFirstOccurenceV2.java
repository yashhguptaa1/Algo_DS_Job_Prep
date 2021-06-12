package RECURSION.Type_R1_PrePhase.Work_in_PrePhase.Return_Ans_in_BaseCase;

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
