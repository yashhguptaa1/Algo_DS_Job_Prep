package A_recursion.Type_R3_PrePhase_RecCallPhase_PostPhase.SingleRecCall.OnlyPrint_ReturnVoid;

import java.util.Scanner;



public class PrintDecreasingIncreasing {

    public static void main(String[] args) throws Exception {
        // write your code here
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        pdi(n);
    }

    public static void pdi(int n){
        if(n==0)
            return;

        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }
}
