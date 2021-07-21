package RECURSION.BACKTRACKING.Type1_PlaceUnplace.F_nKnights_IsSafe_2Das1D;

import java.io.*;

public class PEP {

    static int xdir[]={-1,-2,-2,-1};
    static int ydir[]={-2,-1,1,2};

    public static boolean IsKnightSafe(boolean[][] chess, int row, int col) {

        for(int d=0;d<4;d++)
        {
            int r= row + xdir[d];
            int c= col +ydir[d];

            //valid box and knight is placed there
            if(r>=0 && r<chess.length && c>=0 && c<chess[0].length && chess[r][c] == true)
            {
                //not safe to place at curr pos
                return false;
            }
        }

        return true;
    }

    public static void nknights(int knightsPlacedSoFar, int totalKnights, boolean[][] chess, int lastVisCellNo) {

        //BC
        if(knightsPlacedSoFar == totalKnights)
        {
            for(int i=0;i<chess.length;i++)
            {
                for(int j=0;j<chess[0].length;j++)
                {
                    System.out.print(chess[i][j] ? "k\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        //OPTIONS
        for(int i =lastVisCellNo+1;i< chess.length * chess[0].length; i++)
        {
            //2d as 1d
            int row=i/chess.length;
            int col=i%chess[0].length;

            //isValidCell
            if(chess[row][col]==false && IsKnightSafe(chess,row,col))
            {
                //PLACE
                chess[row][col]=true;

                //LEVELS
                nknights(knightsPlacedSoFar+1,totalKnights,chess,i);

                //UNPLACE : when number of places to be filled is more than number of items then we have to do UNPLACE
                chess[row][col]=false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nknights(0, n, chess, -1);
    }

}
