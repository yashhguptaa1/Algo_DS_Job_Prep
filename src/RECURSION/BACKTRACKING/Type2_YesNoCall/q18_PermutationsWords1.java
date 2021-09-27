package RECURSION.BACKTRACKING.Type2_YesNoCall;

import java.io.*;
import java.util.*;

public class q18_PermutationsWords1 {

    public static void generateWords(int cs, int ts, HashMap<Character,Integer>fmap,String asf)
    {
        //BC
        if(cs>ts)
        {
            System.out.println(asf);
        }

        //OPTIONS
        for(char ch:fmap.keySet())
        {
            if(fmap.get(ch) > 0)
            {
                //MARK
                fmap.put(ch,fmap.get(ch) - 1);

                //LEVELS
                generateWords(cs + 1,ts,fmap,asf+ch);

                //UNMARK
                fmap.put(ch,fmap.get(ch) + 1);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashMap<Character, Integer> fmap = new HashMap<>();
        for(char ch: str.toCharArray()){
            if(fmap.containsKey(ch)){
                fmap.put(ch, fmap.get(ch) + 1);
            } else {
                fmap.put(ch, 1);
            }
        }

        generateWords(1, str.length(), fmap, "");
    }

}
