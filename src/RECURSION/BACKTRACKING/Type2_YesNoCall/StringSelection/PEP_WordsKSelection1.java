package RECURSION.BACKTRACKING.Type2_YesNoCall.StringSelection;

import java.util.*;

public class PEP_WordsKSelection1 {

    public static void generateSelection(int i,String ustr,int ssf,int ts,String asf)
    {
        //LEVEL : character {current index from string}
        //BC
        if(i == ustr.length())
        {
            //particular selection
            if(ssf == ts)
            {
                System.out.println(asf);
            }
            return;
        }

        char ch = ustr.charAt(i);

        //OPTIONS
        //YES
        generateSelection(i+1,ustr,ssf+1,ts,asf+ch);

        //NO
        generateSelection(i+1,ustr,ssf+0,ts,asf+"");
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

        generateSelection(0, ustr, 0, k, "");
        scn.close();
    }

}
