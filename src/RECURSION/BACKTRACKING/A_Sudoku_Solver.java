package A_recursion.BACKTRACKING;

public class A_Sudoku_Solver {

    //Boxes denote Levels\
    //1-9 numbers denote options breadthvise

    public void solveSudoku(char[][] board) {
        helper(board);
    }

    public boolean helper(char[][] board) {

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {
                    continue;
                }

                for (char po = '1'; po <= '9'; po++) {
                    if (isValid(board, i, j, po)) {

                        //PrePhase of Edge
                        board[i][j] = po;

                        if (helper(board)) {
                            return true;
                        }

                        //PostPhase of edge
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }

        return true; //return true if all cells are checked
    }

    public boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {

            //ColumnVise
            if ( board[i][col] == c) {
                return false;
            }

            //RowVise
            if (board[row][i] == c) {
                return false;
            }


            int subMatrixStartRow= 3 * (row / 3);
            int subMatrixStartCol= 3 * (col / 3);
            if (board[subMatrixStartRow + i / 3][subMatrixStartCol + i % 3] == c) {

                return false;
            }
        }
        return true;
    }
}
/*
37. Sudoku Solver
Hard

2993

110

Add to List

Share
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.
 */