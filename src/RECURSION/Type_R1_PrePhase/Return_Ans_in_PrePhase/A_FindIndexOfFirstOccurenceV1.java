package A_recursion.Type_R1_PrePhase.Return_Ans_in_PrePhase;

public class A_FindIndexOfFirstOccurenceV1 {

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
