package RECURSION.Type_R2_PostOrder_Rec_Call.Work_ReturnAns_in_PostPhase.SingleRecCall;

import java.util.*;

public class Factorial {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }

    // If Recursion is returning something either store it or use it
    public static int factorial(int n) {

        // BC
        if (n == 0)
            return 1;

        // PRE RECURSIVE CALL
        int INTERMEDIATE_RESULT = factorial(n - 1); // Faith

        // POSTPHASE
        // WORK : update result
        int UPDATED_RESULT = n * INTERMEDIATE_RESULT;// Merging

        return UPDATED_RESULT;

        // SHORTHAND VERSION
        // return n * factorial(n-1);
    }
}
