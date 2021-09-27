package RECURSION.Type_R1_PrePhase.Print_Ans_in_PrePhase;

import java.util.*;

public class A_PrintDecreasingOrderPrePhase {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printDecreasing(n);
    }

    public static void printDecreasing(int n) {

        // BC
        if (n == 0)
            return;

        // PREPHASE
        // WORK on the way up(depthvise) : print
        System.out.println(n);

        // LEVEL : nth value

        // RECURSIVE CALL
        printDecreasing(n - 1);
    }
}
// 6:31 - 6:35
