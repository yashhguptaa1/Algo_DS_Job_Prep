package RECURSION.BACKTRACKING;

public class PEP_CoinChangeCombination1 {
    // coin change combination 1, amtsf-> amount so far, tamt-> total amount
    public static void coinChange1(int i, int[] coins, int amtsf, int tamt, String asf){
        if(amtsf == tamt) {
            System.out.println(asf + ".");
            return;
        }
        if(i == coins.length) {
            return;
        }
        // yes call
        if(coins[i] + amtsf <= tamt) {
            coinChange1(i + 1, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
        }
        // no call
        coinChange1(i + 1, coins, amtsf, tamt, asf);
    }

}
