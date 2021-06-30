package B_ARRAYS.MATRIX;

import java.util.Scanner;

public class E_RotateBy90Degree {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int matrix[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=sc.nextInt();
            }
        }
        transpose(matrix);
        columnRearrange(matrix);
        display(matrix);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //First take transpose
    //Note not to traverse same indexes again
    //For that we ensure we traverse in upper triangle only
    public static void transpose(int arr[][])
    {
        for(int i=0;i<=arr.length-2;i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }

    //Swapping columns

    public static void columnRearrange(int arr[][])
    {
        int left = 0;
        int right = arr[0].length - 1;

        while (left < right)
        {
            for(int i=0;i< arr.length;i++)
            {
                int temp=arr[i][left];
                arr[i][left]=arr[i][right];
                arr[i][right]=temp;
            }
            left++;
            right--;
        }
    }

}
/*
48. Rotate Image
Medium

5359

355

Add to List

Share
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
Example 3:

Input: matrix = [[1]]
Output: [[1]]
Example 4:

Input: matrix = [[1,2],[3,4]]
Output: [[3,1],[4,2]]


Constraints:

matrix.length == n
matrix[i].length == n
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
 */