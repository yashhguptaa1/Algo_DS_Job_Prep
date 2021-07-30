package A_recursion.BACKTRACKING.Type1_PlaceUnplace.D_QueenCombinations2D;

import java.io.*;

public class PEP {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){

        //BC
        if(qpsf == tq) {
            for(int r = 0; r < chess.length; r++) {
                for(int c = 0; c < chess[0].length; c++) {
                    if(chess[r][c] == true) {
                        System.out.print("q\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        //OPTIONS
        //PART1
        //initially i = row = 0 ,  j = col = -1
        for(int col = j+1;col<chess[0].length;col++)
        {
            //PLACE
            chess[i][col]=true;

            //LEVELS
            queensCombinations(qpsf+1,tq,chess,i,col);

            //UNPLACE
            chess[i][col]=false;
        }

        //PART2
        //initially row = 1 , col = 0
        for(int row=i+1; row<chess.length;row++)
        {
            for(int col = 0;col<chess[0].length;col++)
            {
                //PLACE
                chess[row][col]=true;

                //LEVELS
                queensCombinations(qpsf+1,tq,chess,row,col);

                //UNPLACE
                chess[row][col]=false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, 0, -1);
    }
}
