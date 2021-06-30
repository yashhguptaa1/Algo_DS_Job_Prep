package RECURSION.BACKTRACKING.Combinations_Selection;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_Combinations2_itemChoosesBox {

    public static void combinations(int currItem,boolean boxes[],int tItems,int lastBoxVis)
    {
        if(currItem > tItems)
        {
            for (int i=0;i<boxes.length;i++)
            {
                if(boxes[i]==true)
                    System.out.print(i);

                else
                    System.out.print("0");

            }
            System.out.println();
            return;
        }

        //To stop this code from behaving like permutation
        //we ensure the next item selects boxes remaining after last visited box

        //
        for(int i=lastBoxVis + 1; i<boxes.length;i++)
        {
            if(boxes[i] == false){
                boxes[i]=true;
                combinations(currItem+1,boxes,tItems,i);
                boxes[i]=false;
            }
        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(1,new boolean [nboxes],ritems,-1);
    }

}
