package A_recursion.Type_R1_PrePhase.Print_Ans_in_PrePhase;

import java.util.*;

public class A_PrintDecreasingOrderPrePhase {
    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PREprintDecreasing(n);
    }


    public static void PREprintDecreasing(int n){
        //This base case denotes that pop from stack when we reach n=0
        if(n==0)
            return;

        System.out.println(n);
        PREprintDecreasing(n-1);
    }


}
