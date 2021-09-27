package RECURSION.BACKTRACKING.Type1_PlaceUnplace;

import java.io.*;
import java.util.*;

public class q13PEP_WordsKlength4 {

    // Words - K Length Words - 4, cs-> current slots, ts -> total slots
    public static void permutations(String ustr, int cs, int ts, String asf, HashMap<Character, Integer> fmap) {
        if(cs == ts) {
            System.out.println(asf);
            return;
        }

        for(int i = 0; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);
            int freq = fmap.get(ch);
            if(freq > 0) {
                // freq reduce
                fmap.put(ch, freq - 1);

                permutations(ustr, cs + 1, ts, asf + ch, fmap);

                // freq regain
                fmap.put(ch, freq);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        String ustr ="";
        HashMap<Character ,Integer>fmap=new HashMap<>();

        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(!fmap.containsKey(ch))
            {
                fmap.put(ch,1);
                ustr+=ch;
            }
            else
            {
                fmap.put(ch,fmap.get(ch)+1);
            }
        }

        permutations(ustr,0,k,"",fmap);
    }
}
