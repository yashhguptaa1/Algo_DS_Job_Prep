package RECURSION.BACKTRACKING.Type2_YesNoCall;

import java.io.*;

public class q17_permutations {

    public static void queensPermutations(int qpsf,int tq,int row,int col,String asf,boolean queens[])
    {
        //jo cheez level pr hoti he uske karan bc bnta he
        //BC
        if(row==tq)
        {
            if(qpsf == tq)
            {
                System.out.println(asf);
                System.out.println();
            }
            return;
        }


        int nr = 0;
        int nc = 0;
        char sep='\0';

        //Considering 2D matrix
        if(col == tq-1)
        {
            nr = row+1;
            nc=0;
            sep='\n';
        }
        else
        {
            nr=row;
            nc=col+1;
            sep='\t';
        }

        //YES
        //Queens as OPTIONS
        for(int i=0;i<queens.length;i++)
        {
            if(queens[i] == false)
            {
                //MARK
                queens[i]=true;

                //LEVEL
                queensPermutations(qpsf + 1,tq,nr,nc,asf + "q" +(i+1)+sep,queens);

                //UNMARK
                queens[i]=false;
            }
        }

        //NO
        queensPermutations(qpsf + 0,tq,nr,nc,asf + "-" +sep,queens);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}
