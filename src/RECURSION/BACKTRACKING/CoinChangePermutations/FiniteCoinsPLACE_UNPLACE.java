package A_recursion.BACKTRACKING.CoinChangePermutations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class FiniteCoinsPLACE_UNPLACE {

    //amtrsf = amount remaining so far
    //si = start index for options
    //asf = answer So far
    //tamt = total amount to be made
    //coins = given array of coin denomination : finite

    //LEVEL : amtsf
    //OPTIONS : coins
    public static void permutations(int amtrsf, String asf, HashSet<Integer>visited, int n, int coins[]){

        //place this base case before
        //othervise answer not printing
        if(amtrsf == 0)
        {
            System.out.println(asf + ".");
            return;
        }

        //instead of using currIdx
        //our visited takes care of ending the LEVEL at base case
        //Although this is a redundant step
        //code runs perfectly without this also
        if(visited.size() == n)
            return;

        for(int i=0;i<n;i++)
        {
            if(!visited.contains(coins[i])) {
                if (amtrsf - coins[i] >= 0) {

                    //MARK
                    visited.add(coins[i]);

                    //PLACE
                    permutations(amtrsf - coins[i], asf + coins[i] + "-",visited, n, coins);
                    //UNPLACE

                    //UNMARK
                    visited.remove(coins[i]);
                }
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

        permutations(amt,"",new HashSet<>(),n,coins);
    }
}
/*
Sample Input
5
2
3
5
6
7
12
 */