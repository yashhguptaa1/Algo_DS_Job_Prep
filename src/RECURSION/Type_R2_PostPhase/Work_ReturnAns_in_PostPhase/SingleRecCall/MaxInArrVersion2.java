package RECURSION.Type_R2_PostPhase.Work_ReturnAns_in_PostPhase.SingleRecCall;

import java.util.Scanner;

public class MaxInArrVersion2 {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        System.out.println(MaxInArr(arr,0));
    }

    public static int MaxInArr(int arr[],int idx)
    {
        if(idx == arr.length)
            return Integer.MIN_VALUE;

        int maxFromRecursiveCalls=MaxInArr(arr,idx+1);

        int myWork=Math.max(maxFromRecursiveCalls,arr[idx]);

        return myWork;
    }
}
