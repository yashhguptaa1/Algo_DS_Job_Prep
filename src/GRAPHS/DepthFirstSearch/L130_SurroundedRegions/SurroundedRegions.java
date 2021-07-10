package GRAPHS.DepthFirstSearch.L130_SurroundedRegions;

public class SurroundedRegions {

    static int[] xdir = {-1, 0, 1, 0};
    static int[] ydir = {0, -1, 0, 1};

    void surroundedRegionDFS(int i, int j, int n, int m, char[][] grid)
    {
        grid[i][j] = '$';
        for (int d = 0; d < 4; d++)
        {
            int r = i + xdir[d];
            int c = j + ydir[d];

            if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 'O')
                surroundedRegionDFS(r, c, n, m, grid);
        }
    }

    public void solve(char[][] grid) {

        if (grid.length == 0 || grid[0].length == 0)
            return;

        int area = 0;
        int n = grid.length;
        int m = grid[0].length;

        //TRAVERSE THROUGH BOUNDARIES OF MATRIX
        //if found O mark it and its neighbors as useless($)
        for (int i = 0; i < n; i++)
        {
            //FIRST COLUMN
            if (grid[i][0] == 'O')
                surroundedRegionDFS(i, 0, n, m, grid);

            //if any O in
            //LAST COLUMN
            if (grid[i][m - 1] == 'O')
                surroundedRegionDFS(i, m - 1, n, m, grid);
        }

        for (int j = 0; j < m; j++)
        {
            //FIRST ROW
            if (grid[0][j] == 'O')
                surroundedRegionDFS(0, j, n, m, grid);

            //LAST ROW
            if (grid[n - 1][j] == 'O')
                surroundedRegionDFS(n - 1, j, n, m, grid);
        }

        //ONLY ENCLOSED O ARE REMAINING NOW
        //WITH NO CONNECTION TO BOUNDARY
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (grid[i][j] == 'O')
                    grid[i][j] = 'X';
                if (grid[i][j] == '$')
                    grid[i][j] = 'O';
            }
        }
    }

}
