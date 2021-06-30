package B_ARRAYS.MATRIX;

import java.util.Scanner;

public class I_SearchIn2dSortedMatrix {


        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int matrix1[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    matrix1[i][j]=sc.nextInt();
                }
            }
            int data=sc.nextInt();
            searchIn2d(matrix1,data);
        }

        public boolean searchMatrix(int arr[][],int data) {

            int n = arr.length;

            //As we go up we get smaller values
            //rows are sorted in increasing order
            int rowDec=n-1;

            //as we go towards right we get
            //larger number as col is so
            int colInc=0;

            while (rowDec >=0 && colInc < n)
            {
                if(data > arr[rowDec][colInc])
                {
                    colInc++;
                }
                else if(data < arr[rowDec][colInc])
                {
                    rowDec--;
                }

                else
                    {
                        return true;
                    }
            }

            return false;

        }

        public static void searchIn2d(int arr[][],int data)
        {
            int n = arr.length;
            int rowDec=n-1;
            int colInc=0;

            while (rowDec >=0 && colInc < n)
            {
                if(arr[rowDec][colInc] == data)
                {
                    System.out.println(rowDec);
                    System.out.println(colInc);
                    return;
                }else if(data > arr[rowDec][colInc])
                {
                    colInc++;
                }
                else if(data < arr[rowDec][colInc])
                {
                    rowDec--;
                }
            }
            System.out.println("Not Found");
        }


}
/*
240. Search a 2D Matrix II
Medium

4945

93

Add to List

Share
Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.


Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false


class Solution {
       public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
 */