package RECURSION.BACKTRACKING.Permutations_AllArrangements;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class F_Permutations2_BoxChoosesQueen {

    public static void permutations(int qsf,boolean queens[],int row,int col,String answerSoFar,int tq)
    {
        //we decide base case on the basis of levels in recursion

        int nr = 0;
        int nc = 0;

        if(col == tq-1){
            nr =row+1;
            nc=0;
        }
        else
        {
            nr=row;
            nc=col+1;
        }
//        if(currBox > tBoxes)
//        {
//            if(selectionSoFar == tSelection)
//            {
//                System.out.println(answerSoFar);
//            }
//            return;
//        }
//
//        for(int i=0;i<tSelection;i++)
//        {
//            if(items[i]==false)
//            {
//                items[i]=true;
//                //YES
//                permutations(currBox+1,items,selectionSoFar+1,answerSoFar+(i+1),tBoxes,tSelection);
//                items[i]=false;
//            }
//
//        }
//
//        //NO
//        permutations(currBox+1,items,selectionSoFar,answerSoFar + 0,tBoxes,tSelection);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
//        permutations(1,new boolean [ritems],0,"" , nboxes,ritems);
    }

}
