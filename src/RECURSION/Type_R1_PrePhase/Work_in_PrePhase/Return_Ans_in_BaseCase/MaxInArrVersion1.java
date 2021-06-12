package RECURSION.Type_R1_PrePhase.Work_in_PrePhase.Return_Ans_in_BaseCase;

import java.util.Scanner;

public class MaxInArrVersion1 {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        System.out.println(MaxInArr(arr,0,-1));
    }

    //My way
    //Changing function signature

    public static int MaxInArr(int arr[],int idx,int maxSoFar)
    {
        if(idx == arr.length)
            return maxSoFar;

        if(arr[idx]>maxSoFar)
        {
            maxSoFar=arr[idx];
        }

        return MaxInArr(arr,idx+1,maxSoFar);
    }


}
