package RECURSION.BACKTRACKING.Type1_PlaceUnplace.Combination2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//1. Make Base case from LEVEL :depthvise
//2. Make Loop from OPTIONS :breadthvise
public class B_Combinations2_itemChoosesBox {

    public static void combinations(int currItem,boolean boxes[],int tItems,int lastBoxVis)
    {
        if(currItem > tItems)
        {
            for (int i=0;i<boxes.length;i++)
            {
                if(boxes[i]==true)
                    System.out.print("i");

                else
                    System.out.print("-");

            }
            System.out.println();
            return;
        }

        //To stop this code from behaving like permutation
        //we ensure the next item selects boxes remaining after last visited box
        //vrna 1 2 - -
        // ka  2 1 - - bhi chl jayega
        //BASICALLY HUM IS CODE ME BACKTRACK KRTE HUE YEH ENSURE KRTE HE KI
        //FIRSE SAME INDEX PR NA JAAYEIN
        for(int b=lastBoxVis + 1; b<boxes.length;b++)
        {
            //since i already know by using lastBoxVis+1
            //i ensure i always go to empty box
            //so no need to check if box is empty or not
            //it works perfectly without this if condition
            //if(boxes[b] == false){
                boxes[b]=true;
                combinations(currItem+1,boxes,tItems,b);
                boxes[b]=false;
            //}
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(1,new boolean [nboxes],ritems,-1);
    }

}
/*
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