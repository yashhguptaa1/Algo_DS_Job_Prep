package RECURSION.BACKTRACKING.Type1_PlaceUnplace.A_Permutation1;

import java.io.*;
import java.util.*;

public class Pep_Permutation1itemChoosesBox {

    //    (n boxes) and number of non-identical items (ritems)
//
//    Each Level corresponds to each respective item
//    Mtlb as we go Depthvise, at each level , for a particular item
//    we decide which box should item be placed in

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
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }

        //OPTIONS : BREADTHVISE
        for(int i=0;i<boxes.length;i++)
        {
            //box[i] = 0 denotes empty box
            //any item can occupy current box
            if(boxes[i] == 0){

                //current Item has choosen box at ith place
                //no other item can select ith box

                //PLACE ITEM
                boxes[i]=currItem;

                //Remaining Items have option of choosing from unmarked boxes
                permutations(currItem+1,boxes,tItems);// LEVEL : DEPTHVISE

                //In next iteration curr item plans to choose some other box
                //different from box it already chose
                //if we dont do this then there will be two boxes with same item
                //also some other item will try to occupy current box in some other
                //permutation
                //box[i] = 0 denotes empty box

                //UNPLACE ITEM
                boxes[i]=0;
            }
        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());

        int placesToFill[]=new int[nboxes];
        Arrays.fill(placesToFill,0);

        permutations(1,placesToFill,ritems);
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
10230
10203
13020
10320
10023
13002
10302
10032
21300
21030
21003
31200
01230
01203
31020
01320
01023
31002
01302
01032
23100
20130
20103
32100
02130
02103
30120
03120
00123
30102
03102
00132
23010
20310
20013
32010
02310
02013
30210
03210
00213
30012
03012
00312
23001
20301
20031
32001
02301
02031
30201
03201
00231
30021
03021
00321
 */