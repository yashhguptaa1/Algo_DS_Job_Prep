package RECURSION.Type_R3_PrePhase_RecCallPhase_PostPhase.SingleRecCall.OnlyPrint_ReturnVoid;

import java.util.Scanner;

public class PrintDecreasingIncreasing {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pdi(n);
    }

    public static void pdi(int n) {

        // BC
        if (n == 0)
            return;

        // PREPHASE
        // WORK on the way up(depthvise) : print
        System.out.println(n);

        // LEVEL : nth value
        pdi(n - 1);

        // POSTPHASE
        // WORK on the way down : print
        System.out.println(n);
    }
}
