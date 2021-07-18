package RECURSION.BACKTRACKING.Type2_YesNoCall.Combination1;

import java.io.*;

public class A_Combination1_boxChoosesItem {

//    (n boxes) and number of identical items (ritems)
//
//    Each Level corresponds to each respective Box
//    Mtlb as we go Depthvise, at each level , for a particular box
//    we decide whether we select that box to place an item or not
//
//    Each box has only two options
//    Either the box selects the item (YES)
//    Or Box doesnt select any item (NO)
//    It is denoted Breadthvise
//
//    ANS = nboxes C ritems

    public static void combinations(int currBox,int selectionSoFar,String answerSoFar,int tBoxes,int tSelection)
    {
        if(currBox > tBoxes)
        {
            if(selectionSoFar == tSelection)
            {
                System.out.println(answerSoFar);
            }
            return;
        }

        //YES
        if(selectionSoFar +1 <= tSelection)
            combinations(currBox+1,selectionSoFar+1,answerSoFar + "i",tBoxes,tSelection);

        //No
        combinations(currBox+1,selectionSoFar,answerSoFar + "-",tBoxes,tSelection);


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(1,0  , "",nboxes,ritems);
    }


}

/*
1. You are give a number of boxes (nboxes) and number of identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are identical and all of them are named 'i'.

Sample Input
5
3
Sample Output
iii--
ii-i-
ii--i
i-ii-
i-i-i
i--ii
-iii-
-ii-i
-i-ii
--iii

 */