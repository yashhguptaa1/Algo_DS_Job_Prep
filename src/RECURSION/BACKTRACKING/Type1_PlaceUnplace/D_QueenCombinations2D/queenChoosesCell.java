package RECURSION.BACKTRACKING.Type1_PlaceUnplace.D_QueenCombinations2D;

public class queenChoosesCell {
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
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

        // travel in remaining columns in current row
        for(int c = j + 1; c < chess[0].length; c++) {
            int r = i;
            // place
            chess[r][c] = true;
            queensCombinations(qpsf + 1, tq, chess, r, c);
            // unplace
            chess[r][c] = false;
        }

        // travel in remaining rows and columns
        for(int r = i + 1; r < chess.length; r++) {
            for(int c = 0; c < chess[0].length; c++) {
                // place
                chess[r][c] = true;
                queensCombinations(qpsf + 1, tq, chess, r, c);
                // unplace
                chess[r][c] = false;
            }
        }
    }
}
