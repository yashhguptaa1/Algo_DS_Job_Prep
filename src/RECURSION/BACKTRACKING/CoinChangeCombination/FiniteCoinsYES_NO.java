package RECURSION.BACKTRACKING.CoinChangeCombination;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FiniteCoinsYES_NO {

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
            combinations(amtrsf - coins[si],si+1,asf + coins[si] +"-",coins);
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
/*
AT EACH LEVEL
I give two choices to each COIN
since in combinations repeatetion and duplicates not allowed
I use a var si:start index to start from a new option in each rec call

BOX CHOOSES IEM
PLACEMENT CHOOSES which COIN to select

FOR
Sample Input
5
2
3
5
6
7
12

I WANT
Sample Output
2-3-7-.
5-7-.

explanation for first output
BOX 0 says i will select COIN 2
BOX 1 says i will select COIN 3

From COIN 3
I give choice to BOX 3
Select/Reject COIN 5
Select/Reject COIN 6
Select/Reject COIN 7

BOX 2:
Reject COIN 5
Reject COIN 6
Select COIN 7

i get valid answer
print this answer
 */