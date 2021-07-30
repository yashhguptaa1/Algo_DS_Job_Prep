package A_recursion.Type_R2_PostPhase.Work_ReturnAns_in_PostPhase.SingleRecCall;

import java.util.*;

public class Factorial {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(factorial(n));
    }
    //If Recursion is returning something either store it or use it
    public static int factorial(int n){
        if(n==0)
            return 1;

        int INTERMEDIATE_RESULT=factorial(n-1); // Faith
        int UPDATED_RESULT = n * INTERMEDIATE_RESULT;

        return UPDATED_RESULT;

        //SHORTHAND VERSION
//        return n * factorial(n-1);

    }
}
