package RECURSION.Type_R1_PrePhase.Work_in_PrePhase.Print_Ans_in_BaseCase;

import java.util.*;
public class PrintAllSubsequences {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String inp= sc.next();
        printSubs(inp,"");
    }

    public static void printSubs(String str,String pathSoFar)
    {
        if(str.length() == 0)
        {
            System.out.println(pathSoFar);
            return;
        }

        // Level
        char ch=str.charAt(0);

        //Options
        //opt1 - Append curr character to intermediate result
        printSubs(str.substring(1),pathSoFar+ch);
        //opt2 - Dont append curr character to intermediate result
        printSubs(str.substring(1),pathSoFar+"");
    }

}

/*
1. You are given a string str.
2. Complete the body of printSS function - without changing signature - to calculate and print all subsequences of str.
 */
