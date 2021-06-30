package B_ARRAYS.MATRIX;

import java.util.Scanner;

public class G_DiagonalTraversal {public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();

    int matrix[][]=new int[n][n];

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            matrix[i][j]=scn.nextInt();
        }
    }


    for(int numOfDiag=0; numOfDiag<n ;numOfDiag++)
    {
        for(int i=0,j=numOfDiag;i<n && j<n;i++,j++)
        {
            System.out.println(matrix[i][j]);
        }
    }
}

}
/*
To Tackle Traversal questions from
Spiral Matrix to Diagonal Traversal
First In rough /Dry run

Write all coordinates that you will visit in each iteration seperately
Now try to find pattern which will fit in your loop
 */

/*
The monuments are named as:
1    2    3    4
5    6    7    8
9   10  11  12
13 14  15  16
The path followed by the visitor is: 1->6->11->16->2->7->12->3->8->4
 */