package DYNAMIC_PROGRAMMING.P_CountAiBjCk;

public class CountAiBjCk {
    // ~~~~~~~~~~~~~Count A^i B^j C^k ~~~~~~~~~~~~~~~
    public static int countAiBjCk(String str) {
        int a_count = 0;
        int b_count = 0;
        int c_count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'a') {
                a_count = 2 * a_count + 1;
            } else if (ch == 'b') {
                b_count = 2 * b_count + a_count;
            } else {
                c_count = 2 * b_count + c_count;
            }
        }

        return c_count;
    }
}
/*
 * 1. You are given a string str. 2. You are required to calculate and print the
 * count of subsequences of the nature a+b+c+. For abbc -> there are 3
 * subsequences. abc, abc, abbc For abcabc -> there are 7 subsequences. abc,
 * abc, abbc, aabc, abcc, abc, abc.
 * 
 * Sample Input abcabc Sample Output 7
 */