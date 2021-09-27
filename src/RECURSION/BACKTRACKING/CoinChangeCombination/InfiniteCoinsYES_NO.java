package RECURSION.BACKTRACKING.CoinChangeCombination;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InfiniteCoinsYES_NO {
    //amtrsf = amount remaining so far
    //si = start index for options
    //asf = answer So far
    //tamt = total amount to be made
    //coins = given array of coin denomination : finite

    //LEVEL : amtsf
    //OPTIONS 1: YES= I will choose current coin
    //OPTION 2: NO= I will not choose current coin

    // coin change combination 1, amtsf-> amount so far, tamt-> total amount
    public static void combinations(int amtrsf,int si,String asf,int coins[]){
        if(amtrsf == 0) {
            System.out.println(asf + ".");
            return;
        }
        if(si == coins.length) {
            return;
        }
        // yes call
        if(amtrsf - coins[si] >= 0) {
            combinations(amtrsf - coins[si],si,asf + coins[si] +"-",coins);
        }
        // no call
        combinations(amtrsf ,si+1,asf,coins);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());

        combinations(amt,0,"",coins);
    }
}
