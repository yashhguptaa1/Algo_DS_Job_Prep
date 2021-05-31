package RECURSION.UsingCombinationOfTypes.Combine_R1_PRE_R2_POST;

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
