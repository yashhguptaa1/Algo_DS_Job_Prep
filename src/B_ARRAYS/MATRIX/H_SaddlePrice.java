package B_ARRAYS.MATRIX;

import java.util.Scanner;

public class H_SaddlePrice {

        public static void main(String[] args) throws Exception {
            // write your code here
            Scanner scn=new Scanner(System.in);
            int n=scn.nextInt();
            int matrix[][]=new int [n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    matrix[i][j]=scn.nextInt();
                }
            }

            for(int i=0;i<n;i++)
            {
                //find min in every row
                int min=matrix[i][0];
                int colno=0;
                for(int c=0;c<n;c++)
                {
                    if(matrix[i][c]<min)
                    {
                        min=matrix[i][c];
                        colno=c;
                    }
                }

                //Now the min obtained search in its col
                //verify in that particular col
                boolean vc=true;
                for(int row=0;row<n;row++)
                {
                    if(matrix[row][colno]>min)
                    {
                        vc=false;
                        break;
                    }
                }

                if(vc==true)
                {
                    System.out.println(min);
                    return;
                }
            }

            System.out.println("Invalid input");
        }


    }
/*
1. You are given a square matrix of size 'n'. You are given n*n elements of the square matrix.
2. You are required to find the saddle price of the given matrix and print the saddle price.
3. The saddle price is defined as the least price in the row but the maximum price in the column of the matrix.
 */