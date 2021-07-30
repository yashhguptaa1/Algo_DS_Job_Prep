package A_recursion.DivideAndConquer.BinarySearch.SortedArr;

public class G_L240_Search2DMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {

        //There are only two possible starting points to consider
        //Top RightMost and Bottom LeftMost
        //We choose starting point is TOP RIGHTMOST element
        //as Matrix can have only 1 row then
        //choosing TOP RIGHTMOST element will be better
        int row = 0;
        int col = matrix[0].length-1;

        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            }//go towards left half
            else if(target < matrix[row][col]) {
                col--;
            }//go towards right half
            else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
