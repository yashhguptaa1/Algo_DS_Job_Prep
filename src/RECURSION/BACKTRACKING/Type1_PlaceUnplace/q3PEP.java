package RECURSION.BACKTRACKING.Type1_PlaceUnplace;

import java.io.*;

public class q3PEP {

    public static void queensPermutations(int qpsf, int tq, int[][] chess){

        //BASECASE
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

        //OPTIONS
        for(int i=0;i<tq;i++)
        {
            for(int j=0;j<tq;j++)
            {
                //is empty to fill
                if(chess[i][j] == 0)
                {
                    //PLACE
                    chess[i][j] = qpsf+1;

                    //LEVELS
                    queensPermutations(qpsf+1,tq,chess);

                    //UNPLACE
                    chess[i][j]=0;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        queensPermutations(0, n, chess);
    }
}
