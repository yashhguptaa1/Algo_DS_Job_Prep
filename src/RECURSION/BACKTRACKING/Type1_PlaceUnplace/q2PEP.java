package RECURSION.BACKTRACKING.Type1_PlaceUnplace;

import java.io.*;

public class q2PEP {
    public static void combinations(int[] boxes, int ci, int ti, int lb){

        //BC
        if(ci > ti)
        {
            for(int i=0;i<boxes.length;i++)
            {
                if(boxes[i] == 0)
                    System.out.print("-");

                else
                    System.out.print("i");
            }
            System.out.println();
            return;
        }

        //Option
        for(int b=lb+1;b<boxes.length;b++)
        {
            //if(boxes[b] == 0)
            //{
                //Place
                boxes[b]=ci;

                //Level
                combinations(boxes,ci+1,ti,b);

                //Unplace
                boxes[b]=0;

            //}
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(new int[nboxes], 1, ritems, -1);
    }
}
