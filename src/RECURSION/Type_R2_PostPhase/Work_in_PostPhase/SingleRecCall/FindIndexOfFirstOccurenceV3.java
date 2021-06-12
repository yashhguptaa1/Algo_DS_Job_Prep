package RECURSION.Type_R2_PostPhase.Work_in_PostPhase.SingleRecCall;

public class FindIndexOfFirstOccurenceV3 {

     public static int findFirst(int arr[],int idx,int data){

         if(idx== arr.length)
         {
             return -1;
         }

         int recIdx=findFirst(arr,idx+1,data);

         if(data == arr[idx])
         {
             recIdx = idx;
         }
         return recIdx;
     }
}
