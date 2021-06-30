package DYNAMIC_PROGRAMMING.M_CountEncodings;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-encodings-official/ojquestion
public class Pep_CountEncodings {

    // ~~~~~~~~~~~~~Count Encoding~~~~~~~~~~~
    public static int countEncoding_rec(String str, int indx) {

        //if reached end of string must have got a valid ans
        if(indx == str.length()) {
            return 1;
        }
        if(str.charAt(indx) == '0') {
            return 0;
        }

        int count = 0;
        int n1 = str.charAt(indx) - '0';
        count += countEncoding_rec(str, indx + 1);
        if(indx + 1 < str.length()) {
            int n = str.charAt(indx + 1) - '0';
            int n2 = n1 * 10 + n;
            if(n2 <= 26) {
                count += countEncoding_rec(str, indx + 2);
            }
        }
        return count;
    }

    public static int countEncoding_memo(String str, int indx, int[] dp) {
        if(indx == str.length()) {
            return dp[indx] = 1;
        }
        if(str.charAt(indx) == '0') {
            return dp[indx] = 0;
        }

        if(dp[indx] != 0) {
            return dp[indx];
        }

        int count = 0;
        int n1 = str.charAt(indx) - '0';
        count += countEncoding_memo(str, indx + 1, dp);
        if(indx + 1 < str.length()) {
            int n = str.charAt(indx + 1) - '0';
            int n2 = n1 * 10 + n;
            if(n2 <= 26) {
                count += countEncoding_memo(str, indx + 2, dp);
            }
        }
        return dp[indx] = count;
    }

    public static int countEncoding_tab1(String str) {
        int[] dp = new int[str.length() + 1];
        for(int indx = str.length(); indx >= 0; indx--) {
            if(indx == str.length()) {
                dp[indx] = 1;
                continue;
            }
            if(str.charAt(indx) == '0') {
                dp[indx] = 0;
                continue;
            }

            int count = 0;
            int n1 = str.charAt(indx) - '0';
            count += dp[indx + 1]; // countEncoding_memo(str, indx + 1, dp);
            if(indx + 1 < str.length()) {
                int n = str.charAt(indx + 1) - '0';
                int n2 = n1 * 10 + n;
                if(n2 <= 26) {
                    count += dp[indx + 2]; // countEncoding_memo(str, indx + 2, dp);
                }
            }
            dp[indx] = count;
        }
        return dp[0];
    }



}
/*
1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. You are required to calculate and print the count of encodings for the string str.

     For 123 -> there are 3 encodings. abc, aw, lc
     For 993 -> there is 1 encoding. iic

Sample Input
123
Sample Output
3
 */