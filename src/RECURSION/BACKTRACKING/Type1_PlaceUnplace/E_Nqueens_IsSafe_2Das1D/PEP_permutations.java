package RECURSION.BACKTRACKING.Type1_PlaceUnplace.E_Nqueens_IsSafe_2Das1D;

import java.io.*;

public class PEP_permutations {
                        //W, NW, N, NE, E, SE, S, SW
    static int[] rdir = { 0, -1, -1, -1, 0, 1, 1, 1 };
    static int[] cdir = { -1, -1, 0, 1, 1, 1, 0, -1 };

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {

        //Since its a Square matrix
        for(int rad=1;rad<chess.length;rad++)
        {
            for(int d=0;d<8;d++)
            {
                int r = row + rdir[d]*rad;
                int c = col + cdir[d]*rad;

                if(r>=0 && r<chess.length && c>=0 && c<chess[0].length && chess[r][c]!=0)
                {
                    return false;
                }
            }
        }
        return true;
    }


    public static void nqueens(int qpsf, int tq, int[][] chess) {

        //BC
        if (qpsf == tq) {
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[0].length; j++) {
                    if (chess[i][j] != 0) {
                        System.out.print("q" + chess[i][j] + "\t");
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
        for(int b=0;b<chess.length*chess[0].length;b++)
        {
            //2d as 1d
            int r= b/chess.length;
            int c= b%chess[0].length;

            //isValidCell
            if(chess[r][c] == 0 && IsQueenSafe(chess,r,c))
            {
                //PLACE
                chess[r][c] = qpsf+1;

                //LEVELS
                nqueens(qpsf+1,tq,chess);

                //UNPLACE
                chess[r][c]=0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
