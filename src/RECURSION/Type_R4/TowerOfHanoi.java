package RECURSION.Type_R4;

import java.util.Scanner;

public class TowerOfHanoi {

    public static void toh(int n, int src, int dst, int hlp) {
        if(n == 0) return;

        toh(n - 1, src, hlp, dst);
        System.out.println(n + "[" + src + " -> " + dst +"]");
        toh(n - 1, hlp, dst, src);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int towerA=sc.nextInt();
        int towerB=sc.nextInt();
        int towerC=sc.nextInt();
        toh(n, towerA, towerB, towerC);
    }
}
