package RECURSION.BACKTRACKING.Type1_PlaceUnplace.A_Permutation1;
import java.io.*;

public class PEP {

    public static void permutations(int[] boxes, int ci, int ti){

        //BC
        if(ci>ti)
        {
            for(int i=0;i<boxes.length;i++)
            {
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }

        //Options
        for(int b=0;b<boxes.length;b++)
        {
            //is box valid to place
            if(boxes[b] == 0)
            {
                //place
                boxes[b]=ci;

                //Level
                permutations(boxes,ci+1,ti);

                //unplace
                boxes[b]=0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(new int[nboxes], 1, ritems);
    }
}
