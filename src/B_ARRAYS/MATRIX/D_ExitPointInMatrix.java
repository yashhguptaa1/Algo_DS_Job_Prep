package B_ARRAYS.MATRIX;

import java.util.Scanner;

public class D_ExitPointInMatrix {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int matrix[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                matrix[i][j]=sc.nextInt();
            }
        }

        exitCoord(matrix);
    }

    public static void exitCoord(int matrix[][])
    {
        int dirn=0; //0:east, 1:south ,2:west, 3:north
        int row=0;
        int col=0;

        while (row>=0 && row<matrix.length && col>=0 && col<matrix[0].length)
        {
            dirn=(dirn + matrix[row][col]) % 4;
            //east ~ right
            if(dirn ==0)
            {
                col++;
            }
            //bottom ~ south
            else if(dirn == 1)
            {
                row++;
            }
            //west ~ left
            else if(dirn ==2)
            {
                col--;
            }
            //north ~ top
            else
            {
                row--;
            }
        }

        //Now we will exit from above while loop at some point when we are exiting matrix
        //to know which direction we exit from
        //we get ccordinates just before exiting
        if(dirn ==0)
        {
            col--;
        }
        //bottom ~ south
        else if(dirn == 1)
        {
            row--;
        }
        //west ~ left
        else if(dirn ==2)
        {
            col++;
        }
        //north ~ top
        else
        {
            row++;
        }

        System.out.println(row);
        System.out.println(col);
    }


}
/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers (1's and 0's), representing elements of 2d array a.
4. Consider this array a maze and a player enters from top-left corner in east direction.
5. The player moves in the same direction as long as he meets '0'. On seeing a 1, he takes a 90 deg right turn.
6. You are required to print the indices in (row, col) format of the point from where you exit the matrix.
 */