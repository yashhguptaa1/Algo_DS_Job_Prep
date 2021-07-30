package A_recursion.BACKTRACKING.Type2_YesNoCall.StringSelection;

import java.io.*;
import java.util.*;

public class PEP_WordsKSelection3 {

    //ustr: uniqueString obtained by picking distinct chars from INPUT String
    //cc: denotes index of current character we picked from ustr and working on
    //fmap: stores the frequency of occurence of each char in INPUT string
    //asf: answerSoFar
    //k:selection
    public static void combination(String ustr, int cc, HashMap<Character, Integer> fmap, String asf, int k) {
        int asfLen = asf.length();

        if(asfLen == k) {
            System.out.println(asf);
            return;
        }

        //LEVEL: character
        //BC: to stop recursion
        if(cc == ustr.length()) return;

        char ch = ustr.charAt(cc);
        int freq = fmap.get(ch);

        // yes call
        for(int i = freq; i > 0; i--) {
            if(i + asfLen <= k) {

                String str = "";
                for(int j = 0; j < i; j++) {
                    str += ch;
                }
                combination(ustr, cc + 1, fmap, asf + str, k);
            }
        }
        // no call
        combination(ustr, cc + 1, fmap, asf, k);
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

        combination(ustr,0,unique,"",k);

    }
}
