package RECURSION.Type_R1_PrePhase.Work_in_PrePhase.Print_Ans_in_BaseCase;

import java.util.*;

public class PrintPermutations {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String inp = sc.next();
        printPermutations(inp, "");
    }

    public static void printPermutations(String str, String resSoFar) {

        if (str.length() == 0) {
            System.out.println(resSoFar);
            return;
        }
        int allPossibleOptions = str.length();

        for (int i = 0; i < allPossibleOptions; i++) {
            char option = str.charAt(i);
            String rest = str.substring(0, i) + str.substring(i + 1);

            printPermutations(rest, resSoFar + option);
        }
    }
}
