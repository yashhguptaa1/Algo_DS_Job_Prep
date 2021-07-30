package A_recursion.BACKTRACKING.Z_25July;

import java.util.*;

public class PEP_GoldMine2 {

    // Goldmine - 2
    static int max = 0;
    static int[] xdir1 = { -1, 0, 1, 0 };
    static int[] ydir1 = { 0, -1, 0, 1 };

    public static int dfs(int[][] arr, int i, int j) {
        // mark
        int gold = arr[i][j];
        arr[i][j] *= -1;
        // visit in neighbours
        for (int d = 0; d < xdir1.length; d++) {
            int r = i + xdir1[d];
            int c = j + ydir1[d];
            if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && arr[r][c] > 0) {
                gold += dfs(arr, r, c);
            }
        }
        return gold;
    }

    public static void getMaxGold(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                //to mark visited in same array we multiply cell value with -1
                //we cannot go to cell with 0 blockage
                if (arr[i][j] > 0) {
                    int res = dfs(arr, i, j);
                    max = Math.max(max, res);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0 ; j  < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        getMaxGold(arr);
        System.out.println(max);
    }

}
