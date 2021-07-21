package RECURSION.BACKTRACKING.Type1_PlaceUnplace.E_Nqueens_IsSafe_2Das1D;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PEP_combinations {

    public static boolean isQueenSafe(boolean[][] chess,int row,int col)
    {
        //dirn 0 : West - currPos to left : same row
        for(int r = row,c=col;c>=0;c--)
        {
            if(chess[r][c] == true)
                return false;
        }

        //dirn 1 : NorthWest - currPos to topleft
        for(int r=row,c=col;r>=0 && c>=0;r--,c--)
        {
            if(chess[r][c] == true)
                return false;
        }

        //dirn 2 : North - currPos to top : same col
        for(int r=row,c=col ; r>=0;r--)
        {
            if(chess[r][c] == true)
                return false;
        }

        //dirn 3 : NorthEast - currPos to topright
        for(int r=row,c=col; r>=0 && c<chess[0].length ; r--,c++)
        {
            if(chess[r][c] == true)
                return false;
        }

        //we can place new queen in current position
        //as it doesnot kill any other queen
        return true;
    }
    public static void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
        //BC
        if(qpsf == tq) {
            for(int i = 0; i < chess.length; i++) {
                for(int j = 0; j < chess[0].length; j++) {
                    if(chess[i][j] == true) {
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

        for(int b = lcno + 1; b < chess.length * chess[0].length; b++) {

            //conversion to 1D
            int r = b / chess.length;
            int c = b % chess[0].length;

            //Current cell is Valid and empty
            if (chess[r][c] == false && isQueenSafe(chess, r, c)) {

                // place
                chess[r][c] = true;

                //LEVELS
                nqueens(qpsf + 1, tq, chess, b);

                // unplace
                chess[r][c] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nqueens(0, n, chess, -1);
    }
}
