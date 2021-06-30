package RECURSION.BACKTRACKING.Permutations_AllArrangements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class D_PermuteString_charChoosesBox {

    public static void generatePermutations(int cc, String str, Character[] spots,HashMap<Character,Integer> lastOcc)
    {
        if(cc == str.length())
        {
            for (int i=0;i<spots.length;i++)
            {
                System.out.print(spots[i]);
            }
            System.out.println();
            return;
        }

        char ch = str.charAt(cc);
        int lo=lastOcc.get(ch);

        for(int i = lo +1 ;i<spots.length;i++)
        {
            if(spots[i] == null)
            {
                spots[i]=ch;
                lastOcc.put(ch,i);
                generatePermutations(cc+1,str,spots,lastOcc);
                lastOcc.put(ch,lo);
                spots[i]=null;
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();

        Character[] spots =new Character[str.length()];
        HashMap<Character,Integer>lastOccurence = new HashMap<>();

        for(char ch : str.toCharArray())
        {
            lastOccurence.put(ch,-1);
        }

        generatePermutations(0,str,spots,lastOccurence);
    }


}
