package RECURSION.Type_R2_PostOrder_Rec_Call.Print_Ans_in_PostPhase;

import java.util.*;

public class B_PrintDecreasingOrderPostPhase {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printDecreasing(1, n);
    }

    public static void printDecreasing(int i, int n) {
        // BC
        if (i > n) {
            return;
        }

        // LEVEL : nth value denoted using i index
        printDecreasing(i + 1, n);

        // POSTPHASE
        // WORK on the way down : print
        System.out.println(i);
    }
}
