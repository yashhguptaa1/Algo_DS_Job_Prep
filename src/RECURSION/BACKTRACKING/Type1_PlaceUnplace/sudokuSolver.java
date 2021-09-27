package RECURSION.BACKTRACKING.Type1_PlaceUnplace;

import java.util.*;

public class sudokuSolver {

    // solve sudoku
    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafeToPlaceNum(int[][] board, int row, int col, int num) {
        // check in row
        for (int c = 0; c < board[0].length; c++) {
            if (board[row][c] == num)
                return false;
        }
        // check in column
        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == num)
                return false;
        }
        // check in submatrix
        // rr and cc is starting point of submatrix
        int rr = row - (row % 3);
        int cc = col - (col % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + rr][j + cc] == num)
                    return false;
            }
        }
        return true;
    }

    public static void solveSudoku(int[][] board, int i, int j) {
        if (i == board.length) {
            display(board);
            return;
        }

        if (board[i][j] == 0) {
            for (int num = 1; num < 10; num++) {
                if (isSafeToPlaceNum(board, i, j, num)) {
                    // place
                    board[i][j] = num;
                    if (j == board[0].length - 1) {
                        solveSudoku(board, i + 1, 0);
                    } else {
                        solveSudoku(board, i, j + 1);
                    }
                    // unplace
                    board[i][j] = 0;
                }
            }
        } else {
            if (j == board[0].length - 1) {
                solveSudoku(board, i + 1, 0);
            } else {
                solveSudoku(board, i, j + 1);
            }
        }
    }

    // sudoku from 1D using box number
    public static void solveSudoku1D(int[][] board, ArrayList<Integer> list, int indx) {
        if (indx == list.size()) {
            display(board);
            return;
        }

        int bno = list.get(indx);
        int r = bno / board.length;
        int c = bno % board.length;

        for (int num = 1; num < 10; num++) {
            if (isSafeToPlaceNum(board, r, c, num)) {
                board[r][c] = num;
                solveSudoku1D(board, list, indx + 1);
                board[r][c] = 0;
            }
        }
    }

    public static void solveSudoku1(int[][] board) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    int bno = board.length * i + j; // bno -> box number
                    list.add(bno);
                }
            }
        }

        solveSudoku1D(board, list, 0);
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        solveSudoku(arr, 0, 0);
        // solveSudoku1(arr);
        scn.close();
    }
}
