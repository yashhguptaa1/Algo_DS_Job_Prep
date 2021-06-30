package RECURSION.BACKTRACKING.Permutations_AllArrangements;

import java.io.*;

public class A_Permutation1_itemChoosesBox {

//    (n boxes) and number of non-identical items (ritems)
//
//    Each Level corresponds to each respective item
//    Mtlb as we go Depthvise, at each level , for a particular item
//    we decide which box should it be placed in

//      The number of boxes denote the number of options we have
//      It is denoted Breadthvise

//       ANS = nboxes P ritems

    public static void permutations(int currItem,int boxes[],int tItems)
    {
        //Since Number of items denote number of levels
        //and base cases are written to exit from level
        //exit when all items taken care of
        if(currItem > tItems)
        {
            for (int i=0;i<boxes.length;i++)
            {
                System.out.print(boxes[i] +" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<boxes.length;i++)
        {
            if(boxes[i] == 0){

                //current Item has choosen box at ith place
                //no other item can select that box
                boxes[i]=currItem;

                //Remaining Items have option of choosing from unmarked boxes
                permutations(currItem+1,boxes,tItems);

                //In next iteration curr item plans to choose some other box
                //different from box it already chose
                //if we dont do this then there will be two boxes with same item
                boxes[i]=0;
            }
        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(1,new int [nboxes],ritems);
    }

}
/*
1. You are give a number of boxes (n boxes) and number of non-identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are numbered from 1 to ritems.

Sample Input
4
2
Sample Output

 */