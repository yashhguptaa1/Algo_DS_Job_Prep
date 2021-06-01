package RECURSION.Type_R3.P2_POST;

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
