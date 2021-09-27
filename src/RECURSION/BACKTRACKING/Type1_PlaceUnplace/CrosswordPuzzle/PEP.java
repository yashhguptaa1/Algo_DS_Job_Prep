package RECURSION.BACKTRACKING.Type1_PlaceUnplace.CrosswordPuzzle;

import java.util.*;

public class PEP {

    // crossword
    public static boolean canPlaceHorizontal(char[][] grid, int r, int c, String word) {
        // left check
        if (c > 0 && grid[r][c - 1] != '+') {
            return false;
        }
        // right check
        // we take c-1 to take care of indexing issues
        if (c - 1 + word.length() >= grid[0].length) {
            return false;
        }

        if ((c - 1 + word.length() < grid[0].length - 1) && (grid[r][c + word.length()] != '+')) {
            return false;
        }
        for (int j = 0; j < word.length(); j++) {
            if (grid[r][j + c] != '-' && grid[r][j + c] != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static boolean canPlaceVertical(char[][] grid, int r, int c, String word) {
        // top check
        if (r > 0 && grid[r - 1][c] != '+') {
            return false;
        }
        // bottom check
        if (r - 1 + word.length() >= grid.length) {
            return false;
        }

        if ((r - 1 + word.length() < grid.length - 1) && (grid[r + word.length()][c] != '+')) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (grid[i + r][c] != '-' && grid[i + r][c] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean[] placeHorizontal(char[][] grid, int r, int c, String word) {
        boolean[] status = new boolean[word.length()];
        for (int j = 0; j < word.length(); j++) {
            if (grid[r][c + j] == '-') {
                grid[r][c + j] = word.charAt(j);
                status[j] = true;
            }
        }
        return status;
    }

    public static boolean[] placeVertical(char[][] grid, int r, int c, String word) {
        boolean[] status = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (grid[r + i][c] == '-') {
                grid[r + i][c] = word.charAt(i);
                status[i] = true;
            }
        }
        return status;
    }

    public static void unplaceHorizontal(char[][] grid, int r, int c, boolean[] status) {
        for (int i = 0; i < status.length; i++) {
            if (status[i] == true) {
                grid[r][c + i] = '-';
            }
        }
    }

    public static void unplaceVertical(char[][] grid, int r, int c, boolean[] status) {
        for (int i = 0; i < status.length; i++) {
            if (status[i] == true) {
                grid[r + i][c] = '-';
            }
        }
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void solution(char[][] grid, String[] words, int vidx) {
        if (vidx == words.length) {
            // print
            print(grid);
            return;
        }

        String word = words[vidx];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '-' || grid[i][j] == word.charAt(0)) {
                    // horizontal try
                    if (canPlaceHorizontal(grid, i, j, word)) {
                        // place
                        boolean[] status = placeHorizontal(grid, i, j, word);
                        solution(grid, words, vidx + 1);
                        // unplace
                        unplaceHorizontal(grid, i, j, status);
                    }
                    // vertical try
                    if (canPlaceVertical(grid, i, j, word)) {
                        // place
                        boolean[] status = placeVertical(grid, i, j, word);
                        solution(grid, words, vidx + 1);
                        // unplace
                        unplaceVertical(grid, i, j, status);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);
        scn.close();
    }
}
