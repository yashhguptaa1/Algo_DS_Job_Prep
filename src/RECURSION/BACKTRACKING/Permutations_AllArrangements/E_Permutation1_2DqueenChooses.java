package RECURSION.BACKTRACKING.Permutations_AllArrangements;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E_Permutation1_2DqueenChooses {

    public static void permutations(int qsf,int tq,int chess[][])
    {
        //Since number of queens is less than number of places to fill.
        if(qsf == tq)
        {
            for (int i=0;i<chess.length;i++)
            {
                for(int j=0;j<chess[0].length;j++) {

                    if(chess[i][j]==0)
                        System.out.print("-\t");

                    else
                        System.out.print("q" + chess[i][j] + "\t");
                }

            }
            System.out.println();
            return;
        }

        for(int i=0;i<chess.length;i++)
        {
            for(int j=0;j<chess[0].length;j++) {
                if (chess[i][j] == 0) {
                    chess[i][j] = (qsf+1);
                    permutations(qsf + 1, tq, chess);
                    chess[i][j] = 0;
                }
            }
        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int chess[][] = new int[n][n];
        permutations(0,n,chess);
    }
}
