package A_recursion.BACKTRACKING.Type1_PlaceUnplace.H_String_Kselection;

import java.io.*;
import java.util.*;

public class PEP_WordsKSelection4 {

    //li: last rec call ,character used index
    //ts : total selection = k
    //
    public static void combination(String ustr, HashMap<Character, Integer> fmap, int li, String asf, int ssf, int ts) {
        if(ssf == ts) {
            System.out.println(asf);
            return;
        }

        for(int i = li; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);
            int freq = fmap.get(ch);
            if(freq > 0) {
                fmap.put(ch, freq - 1);
                combination(ustr, fmap, i, asf + ch, ssf + 1, ts);
                fmap.put(ch, freq);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }

        combination(ustr,unique,0,"",0,k);

    }
}
