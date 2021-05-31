package RECURSION.Type_R2_POST;

import java.util.*;
public class PrintIncreasingOrder {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        POSTprintIncreasing(n);

    }

    public static void POSTprintIncreasing(int n){
        if(n==0)
            return;

        POSTprintIncreasing(n-1);
        System.out.println(n);
    }

}
