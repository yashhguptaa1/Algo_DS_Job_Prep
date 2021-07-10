package GRAPHS.DepthFirstSearch.L695_MaxAreaofIsland;

public class MaxAreaIsland {

    static int[] xdir = {-1, 0, 1, 0};
    static int[] ydir = {0, -1, 0, 1};

    public int dfsArea(int grid[][],int n,int m,int srcX,int srcY)
    {
        //mark visited
        grid[srcX][srcY]=0;

        int countOf1s=1;

        for(int d=0;d<4;d++)
        {
            int r= srcX+xdir[d];
            int c= srcY+ydir[d];

            if(r>=0 && c>=0 && r<n && c<m && grid[r][c] == 1)
            {
                countOf1s+=dfsArea(grid,n,m,r,c);
            }
        }
        return countOf1s;

    }
    public int maxAreaOfIsland(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;

        int maxArea=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                    maxArea=Math.max(maxArea,dfsArea(grid,n,m,i,j));
            }
        }
        return maxArea;
    }
}
