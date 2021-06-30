package RECURSION.BACKTRACKING.Permutations_AllArrangements;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_Permutations2_boxChoosesItem {

    //    (n boxes) and number of non-identical items (ritems)
//
//    Each Level corresponds to each respective box available
//    Mtlb as we go Depthvise, at each level , for a particular box
//    it decides which itemNumber should it be placed in it

//      The number of items denote the number of options we have
    // if number of items are less we consider casse when boxes might be empty
//      It is denoted Breadthvise

    //    ANS = (nboxes C ritems)  * ritmes!

    //items array only act to mark visited or not
    //currBox acts on levels
    public static void permutations(int currBox,boolean items[],int selectionSoFar,String answerSoFar,int tBoxes,int tSelection)
    {
        if(currBox > tBoxes)
        {
            if(selectionSoFar == tSelection)
            {
                System.out.println(answerSoFar);
            }
            return;
        }

        //Items placing are options
        for(int i=0;i<tSelection;i++)
        {
            if(items[i]==false)
            {
                items[i]=true;
                //YES
                //i+1 cauz are first itemnumber is 1
                //indexing is from 0
                permutations(currBox+1,items,selectionSoFar+1,answerSoFar+(i+1),tBoxes,tSelection);
                items[i]=false;
            }

        }

        //NO
        //as number of boxes greater than total items
        permutations(currBox+1,items,selectionSoFar,answerSoFar + 0,tBoxes,tSelection);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(1,new boolean [ritems],0,"" , nboxes,ritems);
    }

}
