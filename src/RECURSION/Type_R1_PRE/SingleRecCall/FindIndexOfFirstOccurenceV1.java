package RECURSION.Type_R1_PRE.SingleRecCall;

public class FindIndexOfFirstOccurenceV1 {

     public static int findFirstv1(int arr[],int idx,int data)
     {
         if(idx == arr.length)
         {
             return -1;
         }

         if(data==arr[idx])
             return idx;

         return findFirstv1(arr,idx+1,data);

     }

}
