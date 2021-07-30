package A_recursion.BACKTRACKING.Z_25July;

import java.util.Scanner;

public class PEP_LexicographicalNumbers {

    // Lexicographical Numbers
    public static void lexicography(int val, int n) {
        // base case
        if (val > n)
            return;
        // self printing
        System.out.println(val);
        // family printing
        for (int i = 0; i < 10; i++) {
            lexicography(10 * val + i, n);
        }
    }

        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();

            for(int i=1; i<10;i++)
            {
                lexicography(i,n);
            }
            //write your code here
        }

}
