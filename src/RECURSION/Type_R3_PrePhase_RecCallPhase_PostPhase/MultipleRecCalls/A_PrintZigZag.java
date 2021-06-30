package RECURSION.Type_R3_PrePhase_RecCallPhase_PostPhase.MultipleRecCalls;

import java.util.Scanner;

public class A_PrintZigZag {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        pzz(n);
    }

    public static void pzz(int n)
    {
        if(n == 0)
            return;

        System.out.print(n + " ");
        pzz(n-1);
        System.out.print(n + " ");
        pzz(n-1);
        System.out.print(n + " ");
    }
}
