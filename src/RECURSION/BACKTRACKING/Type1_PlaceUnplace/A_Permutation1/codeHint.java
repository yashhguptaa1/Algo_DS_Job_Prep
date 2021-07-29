package RECURSION.BACKTRACKING.Type1_PlaceUnplace.A_Permutation1;

public class codeHint {

    //    (n boxes) and number of non-identical items (ritems)
//
//    Each Level corresponds to each respective item
//    Mtlb as we go Depthvise, at each level , for a particular item
//    ITEM CHOOSES which BOX should it be placed in

//      The number of boxes denote the number of options ITEM has ,to go in
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