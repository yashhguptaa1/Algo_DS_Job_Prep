package RECURSION.BACKTRACKING;

import java.util.*;

public class B_NqueensReturnList {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>>res=new ArrayList<>();

        //Creating an empty chess board
        List<List<String>> chessBoard=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            List<String> temp=new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                temp.add(".");
            }
            chessBoard.add(new ArrayList<>(temp));
        }

        printNqueen(chessBoard,res,n,0);
        return res;
    }

    public static void printNqueen(List<List<String>>chessBoard,List<List<String>>res,int n,int row)
    {
        if(row == n)
        {
            List<String>temp=new ArrayList<>();

            for(int i=0;i<n;i++)
            {
                StringBuffer str=new StringBuffer("");

                for(int j=0;j<n;j++)
                {
                    str.append(chessBoard.get(i).get(j));
                }
                temp.add(str.toString());
            }

            res.add(new ArrayList<>(temp));

            // System.out.println(chessBoard);
            return;
        }

        for(int col=0;col<n;col++)
        {
            if(isItSafeToPlaceQueen(chessBoard,row,col))
            {
                List<String>currRow=chessBoard.get(row);
                currRow.set(col,"Q");

                printNqueen(chessBoard,res,n,row+1);

                currRow.set(col,".");
            }
        }
    }

    public static boolean isItSafeToPlaceQueen(List<List<String>>chess,int row,int col)
    {
        //top
        for(int i=row-1,j=col; i>=0;i--)
        {
            if(chess.get(i).get(j) == "Q")
                return false;
        }

        //northwest
        for(int i=row-1,j=col-1; i>=0 && j>=0;i--,j--)
        {
            if(chess.get(i).get(j) == "Q")
                return false;
        }
        //northeast
        for(int i=row-1,j=col+1; i>=0 && j<chess.get(0).size();i--,j++)
        {
            if(chess.get(i).get(j) == "Q")
                return false;
        }

        return true;
    }

     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int n = scn.nextInt();
         List<List<String>> res = solveNQueens(n);
         System.out.println(res);
     }

}

/*
51. N-Queens
Hard

3424

113

Add to List

Share
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */
