package C_STRINGS;

import java.util.Scanner;

public class C_StringCompression {

    public static String compression1(String str){
        // write your code here

        int n=str.length();
        if(n == 0)
            return "";

        StringBuilder res=new StringBuilder();
        res.append(str.charAt(0));
        int currChar=1;

        //first loop to traverse whole question string
        while ( currChar < n)
        {
            //second loop to traverse  consecutive duplicates of characters
            while (currChar < n && res.charAt(res.length() -1) == str.charAt(currChar))
            {
                currChar ++;
            }
            if(currChar < n)
                res.append(str.charAt(currChar++));
        }
        return res.toString();
    }

    public static String compression2(String str){
        // write your code here
        int n=str.length();
        if(n == 0)
            return "";

        StringBuilder res=new StringBuilder();
        res.append(str.charAt(0));
        int currChar=1;

        //first loop to traverse whole question string
        while ( currChar < n)
        {
            int countDuplicates = 1;
            //second loop to traverse  consecutive duplicates of characters
            while (currChar < n && res.charAt(res.length() -1) == str.charAt(currChar))
            {
                currChar ++;
                countDuplicates++;
            }
            if(countDuplicates > 1)
                res.append(countDuplicates);

            if(currChar < n) {
                res.append(str.charAt(currChar));//add the last character from group of duplicates
                currChar++;//Now move on to next set of duplicates
            }
        }
        return res.toString();

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }
}
/*
String Compression
Easy  Prev   Next
1. You are given a string.
2. You have to compress the given string in the following two ways -
   First compression -> The string should be compressed such that consecutive duplicates of characters are replaced with a single character.
   For "aaabbccdee", the compressed string will be "abcde".
   Second compression -> The string should be compressed such that consecutive duplicates of characters are replaced with the character and followed by the number of consecutive duplicates.
   For "aaabbccdee", the compressed string will be "a3b2c2de2".

Sample Input
wwwwaaadexxxxxx
Sample Output
wadex
w4a3dex6
 */