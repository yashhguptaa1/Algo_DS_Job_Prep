package GRAPHS.BreadthFirstSearch.L1091_ShortestPathBinaryMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class shortestPathMatrix {

    public int shortestPathBinaryMatrix(int[][] grid)
    {

        int n = grid.length;
        int m = n;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        Queue<Integer> que=new LinkedList<>();
        int dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

        grid[0][0] = 1;

        //To avoid making a new class to store a matrix element and its coordinates
        // we can use concept of converting 2d to 1d
        que.add(0 * m + 0); // r * m + c

        int level = 1;
        while (que.size() != 0)
        {
            int size = que.size();
            while (size-- > 0)
            {
                int idx = que.remove();
                int r = idx / m;
                int c = idx % m;

                if (r == n - 1 && c == m - 1)
                {
                    return level;
                }

                for (int d = 0; d < dir.length; d++)
                {
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];

                    if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 0)
                    {
                        //Marking visited directly in given matrix
                        //instead of taking
                        grid[x][y] = 1;
                        que.add(x * m + y);
                    }
                }
            }
            level++;
        }

        return -1;
    }

}
