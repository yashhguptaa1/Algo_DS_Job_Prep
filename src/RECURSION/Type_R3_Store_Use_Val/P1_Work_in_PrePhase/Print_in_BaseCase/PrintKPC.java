package RECURSION.Type_R3_Store_Use_Val.P1_Work_in_PrePhase.Print_in_BaseCase;

import java.util.Scanner;

public class PrintKPC {

    static String codes[]={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String inp= sc.next();
        printkpc(inp,"");
    }

    public static void printkpc(String str,String pathSoFar)
    {
        if(str.length() == 0)
        {
            System.out.println(pathSoFar);
            return;
        }


        int indx= str.charAt(0) - '0';
        String allPossibleOptions=codes[indx];

        //USING FOR LOOP TO RECURSE THROUGH MORE THAN TWO OPTIONS
        for(int i=0;i<allPossibleOptions.length();i++)
        {
            char currOption=allPossibleOptions.charAt(i);
            printkpc(str.substring(1),pathSoFar + currOption);
        }

    }



}

/*
1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
2. The following list is the key to characters map
    0 -> .;
   1 -> abc
   2 -> def
   3 -> ghi
   4 -> jkl
   5 -> mno
   6 -> pqrs
   7 -> tu
   8 -> vwx
   9 -> yz
3. Complete the body of printKPC function - without changing signature - to print the list of all words that could be produced by the keys in str.
 */