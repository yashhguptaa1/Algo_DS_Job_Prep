package RECURSION.DivideAndConquer.BinarySearch.SortedArr;

public class F_L74_Search2DMatrix {
    /*
     Since its given ,The first integer of
    each row is greater than the last integer of the previous row.
     */

    public boolean searchMatrix(int[][] matrix, int target) {

        int nRows=matrix.length;

        if(nRows == 0)
            return false;

        int nCols=matrix[0].length;

        int leftPtr=0;
        int rightPtr=(nRows*nCols)-1;

        while(leftPtr<=rightPtr)
        {
            int middlePtr=leftPtr + (rightPtr - leftPtr)/2;

            int middleElementVal=matrix[middlePtr/nCols][middlePtr%nCols];

            if(target ==  middleElementVal)
                return true;

            else if(target>middleElementVal)
                leftPtr=middlePtr+1;

            else
                rightPtr=middlePtr - 1;

        }
        return false;
    }
}
/*
[[1,3,5,7],
[10,11,16,20],
[23,30,34,60]], target = 3
 */