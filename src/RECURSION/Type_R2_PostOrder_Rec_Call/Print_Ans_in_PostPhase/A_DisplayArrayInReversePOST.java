package RECURSION.Type_R2_PostOrder_Rec_Call.Print_Ans_in_PostPhase;

import java.util.Scanner;

public class A_DisplayArrayInReversePOST {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        POSTprintDisplayArr(arr,0);
    }

    public static void POSTprintDisplayArr(int[] arr, int idx){

        if(idx == arr.length)
            return;

        POSTprintDisplayArr(arr,idx+1);
        System.out.println(arr[idx]);

    }
}
