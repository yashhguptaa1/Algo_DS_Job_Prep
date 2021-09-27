package RECURSION.BACKTRACKING.Type2_YesNoCall;

import java.util.*;

public class printAllAbbrevations {

    // print abbreviations
    public static void solution(String str, String asf, int count, int indx) {
        if (indx == str.length()) {
            // base case
            String res = asf + (count != 0 ? count : "");
            System.out.println(res);
            return;
        }

        char ch = str.charAt(indx);
        // yes call -> answer so far + count(if != 0) + yes of char
        solution(str, asf + (count != 0 ? count : "") + ch, 0, indx + 1);
        // no call
        solution(str, asf, count + 1, indx + 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "", 0, 0);
        scn.close();
    }
}
