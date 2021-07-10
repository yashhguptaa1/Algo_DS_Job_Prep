package GRAPHS.DepthFirstSearch.L200_NumberOfIslands;

public class F_NumberOfIslands {

    static int[] xdir = {-1, 0, 1, 0};
    static int[] ydir = {0, -1, 0, 1};

    //dfs
    public static void gccForIsland(char[][] graph, int x, int y) {
        //Mark curr vertex visited
        graph[x][y] = '#';

        for(int d = 0; d < 4; d++) {
            int r = x + xdir[d];
            int c = y + ydir[d];

            //if next cell is a valid position and it has not been visited
            if(r >= 0 && r < graph.length && c >= 0 && c < graph[0].length && graph[r][c] == '1') {
                gccForIsland(graph, r, c);
            }
        }
    }

    //Here our graph is in form of 2d Adjacency Matrix
    public int numIslands(char[][] adjGraph) {

        int countConnectedComponents=0;

        for(int i=0;i<adjGraph.length;i++)
        {
            for(int j=0;j<adjGraph[0].length;j++)
            {
                //if current vertex is not visited
                if(adjGraph[i][j]=='1')
                {
                    //this is a start of new connected component
                    countConnectedComponents++;

                    //mark all the neighbours of curr vertex visited
                    gccForIsland(adjGraph,i,j);
                }
            }
        }

        return countConnectedComponents;
    }

}
/*
200. Number of Islands
Medium

8864

250

Add to List

Share
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */