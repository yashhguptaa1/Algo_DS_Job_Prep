package RECURSION.Type_R3_Store_Use_Val.P1_Work_in_PrePhase.Print_in_BaseCase;

import java.util.Scanner;

public class PrintMazePaths {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m= sc.nextInt();

        printMazePaths(0,0,n-1,m-1,"");
    }

    public static void printMazePaths(int sr,int sc,int dr,int dc,String pathSoFar)
    {
        if(sr == dr && sc == dc)
        {
            System.out.println(pathSoFar);
            return;
        }

        //BEFORE MAKING RECURSIVE CALL WE CHECK IF THEY WILL BE VALID OR NOT
        if( sc + 1 <=dc)
        {
            printMazePaths(sr,sc+1,dr,dc,pathSoFar + 'h');
        }
        if(sr + 1 <= dr)
        {
            printMazePaths(sr+1,sc,dr,dc,pathSoFar + 'v');
        }

    }
}
