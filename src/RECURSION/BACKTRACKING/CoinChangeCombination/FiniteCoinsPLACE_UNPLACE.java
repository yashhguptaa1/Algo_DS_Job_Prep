package A_recursion.BACKTRACKING.CoinChangeCombination;

import java.io.*;

public class FiniteCoinsPLACE_UNPLACE {

    //amtrsf = amount remaining so far
    //si = start index for options
    //asf = answer So far
    //tamt = total amount to be made
    //coins = given array of coin denomination : finite

    //LEVEL : amtsf
    //OPTIONS : coins
    public static void combinations(int amtrsf,int si,String asf,int n,int coins[]){

        //place this base case before
        //othervise answer not printing
        if(amtrsf == 0)
        {
            System.out.println(asf + ".");
            return;
        }

        if(si == n)
            return;

        for(int i=si;i<n;i++)
        {
            if(amtrsf - coins[i] >= 0)
            {
                //PLACE
                //recursive call takes care of appending and removing from answer so far
                //PASS i for infinite coins
                combinations(amtrsf-coins[i],i+1,asf + coins[i] +"-",n,coins);
                //UNPLACE
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());

        combinations(amt,0,"",n,coins);
    }
}
/*
AT EACH LEVEL for each COIN
I am traversing through all the options possible
since i am going through all the options and in combinations repeatetion and duplicates
not allowed
I use a var si:start index to start from a new option in each rec call

ITEM CHOOSES BOX
COIN CHOOSES PLACEMENT

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
COIN 2 says i will go in BOX 0
COIN 3 says i will go in BOX 1

From COIN 3 {using loop over coin array}
I make calls to
COIN 5
COIN 6
COIN 7

when BOX 2: filled with 7
i get valid answer
print this answer
 */