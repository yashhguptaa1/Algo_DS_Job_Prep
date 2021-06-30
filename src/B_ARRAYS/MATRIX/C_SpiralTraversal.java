package B_ARRAYS.MATRIX;

import java.util.Scanner;

public class C_SpiralTraversal {

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
        spiralDisplay(matrix1);
    }


    /*

    To identify outer Shell of matrix we need two coordinates

    ( rmin , cmin)  AND ( rmax , cmax)


    //Now For every shell we run 4 loops

    left wall
    fix -> min column
    vary -> Row(minRow - maxRow)
    Print
    tera khaam khtm: minColumn ++

    bottom wall
    fix -> max Row
    vary -> Column(minCol - maxCol)
    Print
    tera khaam khtm: maxRow --

    right wall
    fix ->maxCol
    vary -> Row (maxRow - minRow )
    Print
    tera khaam khtm: maxColumn --

    top wall
    fix ->min Row
    vary -> column (maxCol - minCol)
    Print
    tera khaam khtm: minRow++
     */

    //SPIRAL TRAVERSAL ANTI CLOCKVISE
    public static void spiralDisplay(int arr[][])
    {
        int n= arr.length;
        int m= arr[0].length;
        int rmin=0;
        int rmax= n-1;
        int cmin=0;
        int cmax= m-1;

        int totalEle = n*m;
        while(totalEle > 0)
        {
            //left wall
            for(int r=rmin; r<= rmax  && totalEle>0;r++)
            {
                System.out.println(arr[r][cmin]);
                totalEle--;
            }
            cmin++;

            //bottom wall
            for(int c=cmin;c<=cmax && totalEle>0;c++)
            {
                System.out.println(arr[rmax][c]);
                totalEle--;
            }
            rmax--;

            //right wall
            for(int r=rmax;r>=rmin && totalEle>0;r--)
            {
                System.out.println(arr[r][cmax]);
                totalEle--;
            }
            cmax--;

            //top wall
            for(int c=cmax;c>=cmin && totalEle>0;c--)
            {
                System.out.println(arr[rmin][c]);
                totalEle--;
            }
            rmin++;
        }

    }

}
/*
54. Spiral Matrix
Medium

4086

683

Add to List

Share
Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

class Solution {

    //SPIRAL TRAVERSAL CLOCKVISE
    public List<Integer> spiralOrder(int[][] matrix) {

        int n = matrix.length;
        int m=matrix[0].length;

        List<Integer>res=new ArrayList<>();

        int rmin = 0;
        int cmin = 0;

        int rmax=n-1;
        int cmax=m-1;

        int totalEle = n*m;


        while(totalEle > 0)
        {

            //top boundary
            //rmin fixed
            for(int c=cmin;c<=cmax && totalEle>0;c++ )
            {
                res.add(matrix[rmin][c]);
                totalEle--;


            }
            //increment rmin
            rmin++;

            //right boundary
            //cmax fixed
            for(int r=rmin;r<=rmax && totalEle>0 ;r++)
            {
                res.add(matrix[r][cmax]);
                totalEle--;
            }
            //decrement cmax
            cmax--;

            //bottom boundary
            //rmax fixed
            for(int c=cmax;c>=cmin && totalEle>0 ;c--)
            {
                res.add(matrix[rmax][c]);
                totalEle--;

            }
            //decrement rmax
            rmax--;

            //left boundary
            //cmin fixed
            for(int r=rmax;r>=rmin && totalEle>0 ;r-- )
            {
                res.add(matrix[r][cmin]);
                totalEle--;

            }
            cmin++;
        }

        return res;
    }
}
 */