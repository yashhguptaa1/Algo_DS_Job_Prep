package B_ARRAYS.MATRIX;

import java.util.Scanner;

public class A_MatrixMultiplication {

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

        int n2=sc.nextInt();
        int m2=sc.nextInt();

        int matrix2[][]=new int[n2][m2];
        for(int i=0;i<n2;i++)
        {
            for(int j=0;j<m2;j++)
            {
                matrix2[i][j]=sc.nextInt();
            }
        }
        matrixMultiplication(matrix1,n1,m1,matrix2,n2,m2);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void matrixMultiplication(int matrix1[][],int r1,int c1,int matrix2[][],int r2,int c2)
    {
        int res[][]=new int[r1][c2];

        //if two matrix cant be multiplied
        if(c1 != r2)
        {
            System.out.println("Invalid input");
            return;
        }

//        for(int i=0;i< res.length;i++)
//        {
//            for(int j=0;j<res[0].length;j++)
//            {
//                int mul=0;
//                for(int k=0;k<c1;k++)
//                {
//                    mul += matrix1[i][k]*matrix2[k][j];
//                }
//                res[i][j] = mul;
//            }
//        }

        for(int r=0;r< matrix1.length;r++)
        {
            for(int c=0;c<matrix2[0].length;c++)
            {
                int mul=0;
                for(int k=0;k<c1;k++)
                {
                    mul += matrix1[r][k]*matrix2[k][c];
                }
                res[r][c] = mul;
            }
        }

        display(res);
    }
}
