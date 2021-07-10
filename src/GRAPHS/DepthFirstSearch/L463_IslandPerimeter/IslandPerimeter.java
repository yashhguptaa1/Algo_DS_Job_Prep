package GRAPHS.DepthFirstSearch.L463_IslandPerimeter;

public class IslandPerimeter {

    static int[] xdir = {-1, 0, 1, 0};
    static int[] ydir = {0, -1, 0, 1};

    public int islandPerimeter(int[][] grid)
    {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int nbrs = 0, countFilledBoxes = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (grid[i][j] == 1)
                {
                    countFilledBoxes++;
                    for (int d = 0; d < 4; d++)
                    {
                        int r = i + xdir[d];
                        int c = j + ydir[d];
                        if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1)
                            nbrs++;
                    }
                }
            }
        }

        return countFilledBoxes * 4 - nbrs;
    }

}
