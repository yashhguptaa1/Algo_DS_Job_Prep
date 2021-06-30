package B_ARRAYS.MATRIX;

import java.util.Scanner;

public class B_WaveTraversal {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int m1=sc.nextInt();

        int matrix1[][]=new int[n1][m1];
        for(int i=0;i<n1;i++)
        {
            for(int j=0;j<m1;j++)
            {
                matrix1[i][j]=sc.nextInt();
            }
        }
        wave(matrix1);
    }

    public static void wave(int matrix[][])
    {
        for(int col=0;col<matrix[0].length;col++)
        {
            if(col % 2 == 0)
            {
                for(int row=0;row< matrix.length;row++)
                {
                    System.out.println(matrix[row][col]);
                }
            }
            else {
                for (int row= matrix.length-1;row>=0;row--)
                {
                    System.out.println(matrix[row][col]);
                }
            }
        }
    }

}
/*
Sample Input
3
4
11
12
13
14
21
22
23
24
31
32
33
34
Sample Output
11
21
31
32
22
12
13
23
33
34
24
14

 */
