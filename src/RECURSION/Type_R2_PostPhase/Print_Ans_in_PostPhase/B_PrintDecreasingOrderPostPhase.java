package A_recursion.Type_R2_PostPhase.Print_Ans_in_PostPhase;

import java.util.*;
public class B_PrintDecreasingOrderPostPhase {

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
