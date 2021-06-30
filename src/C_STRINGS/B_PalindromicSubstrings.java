package C_STRINGS;

import java.util.*;

public class B_PalindromicSubstrings {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printAllSubstrings(str);
    }

    public static boolean isPalindrome(String str,int left,int right)
    {
        while (left < right){
            if(str.charAt(left) != str.charAt(right))
                return false;

            left++;
            right--;
        }
        return true;
    }

    public static void printAllSubstrings(String str)
    {
        int n=str.length();
        for (int sp=0;sp<n;sp++)
        {
            for (int ep=sp;ep<n;ep++)
            {
                if(isPalindrome(str,sp,ep))
                    System.out.println(str.substring(sp,ep+1));
            }
        }
    }
}
