package RECURSION.BACKTRACKING.Type1_PlaceUnplace.H_String_Kselection;


import javax.net.ssl.SSLContext;
import java.io.*;
import java.util.*;

public class PEP_permutation {

    public static void generateWords(int currSlot, int totalSlotsToBeFilled, String ustr, HashSet<Character>vis,String asf)
    {
        //BC
        if(currSlot > totalSlotsToBeFilled)
        {
            System.out.println(asf);
            return;
        }

        //OPTIONS
        for(int i=0;i<ustr.length();i++)
        {
            char ch=ustr.charAt(i);

            //is VALID
            if(vis.contains(ch) == false)
            {
                //PLACE
                vis.add(ch);

                //LEVELS
                generateWords(currSlot+1,totalSlotsToBeFilled,ustr,vis,asf+ch);

                //UNPLACE
                vis.remove(ch);
            }
        }
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

        generateWords(1,k,ustr,new HashSet<>(),"");
    }
}
