package RECURSION.BACKTRACKING.Type1_PlaceUnplace.D_QueenCombinations2D;

public class PEP_2Das1D {

    // lcno -> last cell number
    //2D as 1D
    //2D : 4 x 4
    //1D : 1 - 16
    //using lcno to denote last visited cell as traversing on 1D
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
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
            int r = b / chess.length;
            int c = b % chess[0].length;
            // place
            chess[r][c] = true;
            queensCombinations(qpsf + 1, tq, chess, b);
            // unplace
            chess[r][c] = false;
        }
    }
}
