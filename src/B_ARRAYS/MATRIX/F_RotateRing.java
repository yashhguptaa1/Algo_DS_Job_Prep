package B_ARRAYS.MATRIX;

import java.util.Scanner;

public class F_RotateRing {

    public static void main(String[] args) throws Exception {
        // write your code here
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
        int shellNo=sc.nextInt();
        int rotateBy=sc.nextInt();
        ringRotate(matrix,shellNo,rotateBy);
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

    public static void ringRotate(int arr[][],int shellNo,int r)
    {
        //Step1
        int shell[]=fill1Dfrom2D(arr,shellNo);
        //Step2
        rotate1D(shell,r);
        //Step3
        fill2Dfrom1D(arr,shell,shellNo);
    }

    public static int[] fill1Dfrom2D(int arr[][],int shellNo)
    {
        //COORDINATES FOR SHELL
        //rmin,cmin (0,0)....(s-1,s-1)                        //rmin,cmax
        //rmax,cmax (n-1,m-1)...(n-s,m-s)                    //rmax,cmax

        //Total ele in left and right boundary
        //2* (rmax -rmin + 1)
        //Total ele in top and bottom boundary
        //2* (cmax-cmin + 1)
        // now we subtract 4 from total as corner elements come twice in total

        int rmin=shellNo-1;
        int cmin=shellNo-1;
        int rmax= arr.length - shellNo;
        int cmax=arr[0].length - shellNo;
        int size= 2 * (rmax - rmin + cmax - cmin);

        int temp[]=new int[size];
        int currIdx=0;

        //left boundary
        for(int row=rmin; row<=rmax;row++)
        {
            temp[currIdx]=arr[row][cmin];
            currIdx++;
        }
        cmin++;

        //bottom boundary
        for(int col=cmin;col<=cmax;col++)
        {
            temp[currIdx]=arr[rmax][col];
            currIdx++;
        }
        rmax--;

        //right boundary
        for(int row=rmax;row>=rmin;row-- )
        {
            temp[currIdx]=arr[row][cmax];
            currIdx++;
        }
        cmax--;

        //top boundary
        for(int col=cmax;col>=cmin;col--)
        {
            temp[currIdx]=arr[rmin][col];
            currIdx++;
        }
        return temp;
    }

    public static void rotate1D(int arr[],int rotateBy)
    {
        int n =arr.length;
        rotateBy = rotateBy % n;

        if(rotateBy < 0)
            rotateBy += n;

        reverse(arr,0,n-1);
        reverse(arr,0,rotateBy-1);
        reverse(arr,rotateBy,n-1);



    }
    public static void fill2Dfrom1D(int arr[][],int shell[],int shellNo)
    {
        int rmin=shellNo-1;
        int cmin=shellNo-1;
        int rmax= arr.length - shellNo;
        int cmax=arr[0].length - shellNo;

        int currIdx=0;

        //left boundary
        for(int row=rmin; row<=rmax;row++)
        {
            arr[row][cmin]=shell[currIdx];
            currIdx++;
        }
        cmin++;

        //bottom boundary
        for(int col=cmin;col<=cmax;col++)
        {
            arr[rmax][col]=shell[currIdx];
            currIdx++;
        }
        rmax--;

        //right boundary
        for(int row=rmax;row>=rmin;row-- )
        {
            arr[row][cmax]=shell[currIdx];
            currIdx++;
        }
        cmax--;

        //top boundary
        for(int col=cmax;col>=cmin;col--)
        {
            arr[rmin][col]=shell[currIdx];
            currIdx++;
        }

    }

    public static void reverse(int arr[],int left,int right)
    {
        while(left < right)
        {
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
}
/*
You will be given a number 'r' representing number of rotations in an anti-clockwise manner of the specified ring.
You are required to rotate the 's'th ring by 'r' rotations and display the rotated matrix.
 */