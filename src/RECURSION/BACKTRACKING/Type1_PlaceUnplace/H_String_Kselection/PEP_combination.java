package RECURSION.BACKTRACKING.Type1_PlaceUnplace.H_String_Kselection;

import java.util.*;

public class PEP_combination {
    public static void wordsKselection(String uniqueStr,int stringLenSoFar,int totalSelection,String asf,int lastCharIdx)
    {
        //BC
        if(stringLenSoFar == totalSelection)
        {
            System.out.println(asf);
            return;
        }

        //OPTIONS
        for(int i=lastCharIdx+1;i<uniqueStr.length();i++)
        {
            char ch =uniqueStr.charAt(i);

            //LEVELS
            wordsKselection(uniqueStr,stringLenSoFar+1,totalSelection,asf+ch,i);
        }


    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int k = scn.nextInt();

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        //Note lastcharidx should be -1
        //i used 0 before
        //it didnt select "a" in any selection
        wordsKselection( ustr, 0, k, "",-1);
    }

}
