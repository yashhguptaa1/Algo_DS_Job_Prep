package RECURSION.BACKTRACKING.Type2_YesNoCall.D_QueenCombinations2D;

import java.io.*;

public class PEP {

    public static void queenCombinations(int qpsf,int tq,int row,int col,String asf)
    {
        //reaches all the condition of 4c1 , 4c2 ,4c3 ,4c4
        if(row == tq)
        {
            //i want to print answer only when i get 4c2
            if(qpsf == tq)
            {
                System.out.println(asf);
            }
            return;
        }

        int newRow=0;
        int newCol=0;
        String yasf ="";//yes answer so far
        String nasf= "";//no answer so far

        if(col == tq -1)
        {
            newRow=row+1;
            newCol=0;
            yasf = asf + "q\n";
            nasf = asf + "-\n";
        }
        else
        {
            newRow = row;
            newCol = col+1;
            yasf = asf + "q";
            nasf = asf + "-";
        }

        //YES
        queenCombinations(qpsf+1,tq,newRow,newCol,yasf);

        //NO
        queenCombinations(qpsf+0,tq,newRow,newCol,nasf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queenCombinations(0, n, 0, 0, "");
    }
}
