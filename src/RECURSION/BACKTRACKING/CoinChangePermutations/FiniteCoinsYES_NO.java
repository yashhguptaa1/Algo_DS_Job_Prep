package A_recursion.BACKTRACKING.CoinChangePermutations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class FiniteCoinsYES_NO {

    //amtrsf = amount remaining so far
    //si = start index for options
    //asf = answer So far
    //tamt = total amount to be made
    //coins = given array of coin denomination : finite

    //LEVEL : amtsf
    //OPTIONS 1: YES= I will choose current coin
    //OPTION 2: NO= I will not choose current coin

    public static void permutations(int currBox, HashSet<Integer> itemsVis, int amtrsf, String answerSoFar,int coins[])
    {
        //BC
        if(amtrsf == 0)
        {
            System.out.println(answerSoFar+".");
            return;
        }
        if(currBox >= coins.length)
        {
//            if(amtrsf == 0)
//            {
//                System.out.println(answerSoFar+".");
//            }
            return;
        }

        //Agr dhyan se dekhen toh yeh graph ki call ki tarah lg rhi he

        //YES
        //Items placing are OPTIONS
        for(int i=0;i<coins.length;i++)
        {
            //is Unmarked
            if(!itemsVis.contains(coins[i]) && amtrsf - coins[i] >= 0)
            {
                //MARK
                itemsVis.add(coins[i]);
                //i+1 cauz are first itemnumber is 1
                //indexing is from 0

                //LEVELS
                permutations(currBox+1,itemsVis,amtrsf - coins[i],answerSoFar+coins[i]+"-",coins);

                //UNMARK
                itemsVis.remove(coins[i]);

                permutations(currBox+1,itemsVis,amtrsf,answerSoFar,coins);

            }
        }

        //as number of boxes greater than total itemsVis

        //NO
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        permutations(0,new HashSet<>(),amt,"" , coins);
    }
}
