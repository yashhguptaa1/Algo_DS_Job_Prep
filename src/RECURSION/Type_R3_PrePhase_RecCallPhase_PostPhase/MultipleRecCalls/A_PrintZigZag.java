package RECURSION.Type_R3_PrePhase_RecCallPhase_PostPhase.MultipleRecCalls;

import java.util.Scanner;

public class A_PrintZigZag {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pzz(n);
    }

    public static void pzz(int n) {
        if (n == 0)
            return;

        // PRE PHASE WORK
        System.out.print(n + " ");

        // Left Recursive Call
        pzz(n - 1);

        // IN PHASE WORK
        System.out.print(n + " ");

        // RIGHT RECURSIVE CALL
        pzz(n - 1);

        // POST PHASE WORK
        System.out.print(n + " ");
    }
}
