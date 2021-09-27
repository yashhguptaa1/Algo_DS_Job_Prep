package RECURSION.BACKTRACKING.Type2_YesNoCall;

import java.io.*;
import java.util.HashMap;

public class q22_WordsKLengthWords3 {

    //cci - current character index
    // Words - K Length Words - 3, cci-> current character index
    //map to store last occurence of char
    //it is done to avoid repeatetion in aswer as we have duplicates and looping
    //to generate permutations
    //by storing loc we aim to achieve making calls in sorted order on slots
    public static void permutations(String str, int cci, int ssf,
                                    int ts, Character[] slots, HashMap<Character, Integer> map) {
        if(cci == str.length()) {
            if(ssf == ts) {
                for(char ch : slots) {
                    System.out.print(ch);
                }
                System.out.println();
            }
            return;
        }

        char ch = str.charAt(cci); // ch-> current character
        int loc = map.get(ch); // loc-> last occurrence of character

        // yes call
        for(int i = loc + 1; i < slots.length; i++) {
            if(slots[i] == null) {
                // change last occurrence of character
                map.put(ch, i);
                // place
                slots[i] = ch;

                permutations(str, cci + 1, ssf + 1, ts, slots, map);

                // unplace
                slots[i] = null;
                // reset last occurrence of character
                map.put(ch, loc);
            }
        }

        //humme ek yes call ke bad no call nhi lgani to avoid repeatetion
        //loc = -1 mtlb abhi tk ek baar bhi yes call nhi lgi
        if(loc == -1) {
            // no call
            permutations(str, cci + 1, ssf, ts, slots, map);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            map.put(str.charAt(i),-1);
        }

        Character slots[]=new Character[k];
        permutations(str,0,0,k,slots,map);
    }

}
