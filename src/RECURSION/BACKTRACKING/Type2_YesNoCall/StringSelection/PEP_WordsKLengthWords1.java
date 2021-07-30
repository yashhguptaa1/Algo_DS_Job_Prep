package A_recursion.BACKTRACKING.Type2_YesNoCall.StringSelection;

import java.io.*;
import java.util.*;

public class PEP_WordsKLengthWords1 {

    public static void generateWords(int cc,String ustr,int ssf,int ts,Character []slots)
    {
        //BC
        if(cc == ustr.length())
        {
            if(ssf == slots.length)
            {
                for(char c:slots)
                    System.out.print(c);

                System.out.println();
            }
            return;
        }

        char ch = ustr.charAt(cc);

        //YES
        //places to be filled acts as OPTIONS
        for(int i=0;i<slots.length;i++)
        {
            if(slots[i] == null)
            {
                //MARK
                slots[i]=ch;

                //LEVELS
                generateWords(cc+1,ustr,ssf+1,ts,slots);

                //UNMARK
                slots[i] = null;
            }
        }

        generateWords(cc+1,ustr,ssf+0,ts,slots);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }
        Character spots[]=new Character[k];
        generateWords(0,ustr,0,k,spots);
    }
}
