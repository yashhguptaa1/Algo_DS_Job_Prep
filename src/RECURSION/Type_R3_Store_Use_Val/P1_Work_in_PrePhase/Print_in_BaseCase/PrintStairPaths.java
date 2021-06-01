package RECURSION.Type_R3_Store_Use_Val.P1_Work_in_PrePhase.Print_in_BaseCase;

import java.util.Scanner;

public class PrintStairPaths {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int inp= sc.nextInt();
        printStairs(inp,"");
    }

    public static void printStairs(int topStair,String pathSoFar)
    {
        if(topStair < 0)
        {
            return;
        }
        if(topStair == 0)
        {
            System.out.println(pathSoFar);
            return;
        }

        // Options
        //All Possible jumps
        //USING FOR LOOP TO RECURSE THROUGH MORE THAN TWO OPTIONS
        for(int i=1;i<=3;i++)
        {
            printStairs(topStair - i ,pathSoFar + i);
        }
    }

}
