package A_recursion.BACKTRACKING.Type1_PlaceUnplace.B_QueenPermutations2D;

public class codeHint {
    //Given tq x tq board
    //place tq queens in this board
    //all queens are distinct
    public static void queensPermutations(int qpsf, int tq, int[][] chess){
        if(qpsf == tq) {
            // print result
            for(int i = 0; i < chess.length; i++) {
                for(int j = 0; j < chess[0].length; j++) {
                    if(chess[i][j] != 0) {
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

        //BASICALLY HUM IS CODE ME BACKTRACK KRTE HUE YEH ENSURE KRTE HE KI
        //FIRSE SAME INDEX PR JAAYEIN

        for(int i = 0; i < chess.length; i++) {
            for(int j = 0; j < chess[0].length; j++) {
                if(chess[i][j] == 0) {
                    // place queen
                    chess[i][j] = qpsf + 1;

                    queensPermutations(qpsf + 1, tq, chess);

                    // unplace queen
                    //since mere pass number of boxes jyada he number of items se
                    //toh agr current box khali bhi rehgya toh i still have boxes to be filled
                    chess[i][j] = 0;
                }
            }
        }
    }
}
