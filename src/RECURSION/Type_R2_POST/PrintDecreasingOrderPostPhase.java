package RECURSION.Type_R2_POST;

import java.util.*;
public class PrintDecreasingOrderPostPhase {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        POSTprintDecreasing(1,n);
    }


    public static void POSTprintDecreasing(int i,int n){

        if(i > n)
        {
            return;
        }

        POSTprintDecreasing(i+1,n);
        System.out.println(i);
    }
}
