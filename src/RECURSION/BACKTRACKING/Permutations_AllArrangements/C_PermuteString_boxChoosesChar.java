package RECURSION.BACKTRACKING.Permutations_AllArrangements;

import java.io.*;
import java.util.HashMap;

public class C_PermuteString_boxChoosesChar {

    public static void generatePermutations(int cs,int ts,HashMap<Character,Integer>fmap,String asf)
    {
        if(cs > ts)
        {
            System.out.println(asf);
            return;
        }

        for(char ch : fmap.keySet())
        {
            if(fmap.get(ch) > 0)
            {
                fmap.put(ch,fmap.get(ch) - 1);
                generatePermutations(cs +1,ts,fmap,asf+ch);
                fmap.put(ch,fmap.get(ch)+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();

        HashMap<Character,Integer>fmap =new HashMap<>();

        for(char ch : str.toCharArray())
        {
            if(fmap.containsKey(ch))
            {
                fmap.put(ch,fmap.get(ch)+1);
            }
            else
            {
                fmap.put(ch,1);
            }
        }

        generatePermutations(1,str.length(),fmap,"");
    }


}
