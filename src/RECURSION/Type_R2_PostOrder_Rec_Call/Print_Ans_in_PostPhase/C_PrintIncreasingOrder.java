package RECURSION.Type_R2_PostOrder_Rec_Call.Print_Ans_in_PostPhase;

import java.util.*;

public class C_PrintIncreasingOrder {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printIncreasing(n);

    }

    public static void printIncreasing(int n) {
        // BC
        if (n == 0)
            return;

        // LEVEL : nth value
        printIncreasing(n - 1);

        // POSTPHASE
        // WORK on the way down : print
        System.out.println(n);
    }
}
