package B_ARRAYS.P1_TwoPtr_lo_hi;

public class validPalindrome2 {

    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo) == s.charAt(hi)) {
                lo++;
                hi--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;

        while (lo < hi) {
            if (s.charAt(lo) == s.charAt(hi)) {
                lo++;
                hi--;
            } else {
                // since we can delete at most one char
                // we have two choices
                // either delete one char from LHS
                // either delete one char from RHS
                return isPalindrome(s, lo + 1, hi) || isPalindrome(s, lo, hi - 1);
            }
        }
        return true;
    }
}
