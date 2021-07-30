package A_recursion.BACKTRACKING.CoinChangePermutations;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InfiniteCoinsPLACE_UNPLACE {

    //No need of visited in this case
    public static void permutations(int amtrsf, String asf, int n, int coins[]){

        //place this base case before
        //othervise answer not printing
        if(amtrsf == 0)
        {
            System.out.println(asf + ".");
            return;
        }

        for(int i=0;i<n;i++)
        {

                if (amtrsf - coins[i] >= 0) {
                    //PLACE
                    permutations(amtrsf - coins[i], asf + coins[i] + "-", n, coins);
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

        permutations(amt,"",n,coins);
    }
}
