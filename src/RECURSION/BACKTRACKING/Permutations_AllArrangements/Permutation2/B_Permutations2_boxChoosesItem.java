package RECURSION.BACKTRACKING.Permutations_AllArrangements.Permutation2;

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

        //Agr dhyan se dekhen toh yeh graph ki call ki tarah lg rhi he
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
/*
Sample Input
5
3
Sample Output
12300
12030
12003
13200
13020
13002
10230
10203
10320
10302
10023
10032
21300
21030
21003
23100
23010
23001
20130
20103
20310
20301
20013
20031
31200
31020
31002
32100
32010
32001
30120
30102
30210
30201
30012
30021
01230
01203
01320
01302
01023
01032
02130
02103
02310
02301
02013
02031
03120
03102
03210
03201
03012
03021
00123
00132
00213
00231
00312
00321

 */