package GRAPHS.BreadthFirstSearch.L994_RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

//given
// minimum number of minutes that must elapse until no cell has a fresh orange.
//PHLE DRY RUN FIR CODE
//DRY RUN SE CODE NIKALTA HE
public class rottenOranges {

    static int[] xdir = { -1, 0, 1, 0 };
    static int[] ydir = { 0, -1, 0, 1 };

    // Based on MultiPoint BFS
    public int orangesRottingV1(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // Stores the index of 2D matrix in 1D form
        Queue<Integer> que = new LinkedList<>();
        int time = 0, freshOranges = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // First store all the points which will act starting Vertex for bfs
                // count of all already rotten
                if (grid[i][j] == 2)
                    que.add(i * m + j);

                // Total Vertices that must be visited
                // count of all freshOranges
                else if (grid[i][j] == 1)
                    freshOranges++;
            }
        }

        if (freshOranges == 0)
            return 0;
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int idx = que.remove();

                int r = idx / m;
                int c = idx % m;

                //visiting neighbours
                for (int d = 0; d < 4; d++) {
                    int x = r + xdir[d];
                    int y = c + ydir[d];
                    if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
                        freshOranges--;
                        grid[x][y] = 2;
                        que.add(x * m + y);

                        // time pr rot hona shuru hoyega
                        // time+1 pr orange rot hojayega
                        if (freshOranges == 0)
                            return time + 1;
                    }
                }
            }

            time++;
        }

        return -1;
    }

    public class OPair {
        int r;
        int c;
        int t;

        public OPair(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public int orangesRottingV2(int[][] grid) {
        Queue<OPair> qu = new LinkedList<>();

        // 1. travel on grid, add rotted orange in queue, and count oranges
        int orange = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    qu.add(new OPair(i, j, 0));

                if (grid[i][j] == 1 || grid[i][j] == 2)
                    orange++;
            }
        }

        // 2. apply BFS and find remaining orange count and time as well
        int time = 0;

        while (qu.size() > 0) {
            OPair rem = qu.remove();
            if (grid[rem.r][rem.c] == -2) {
                continue;
            }
            grid[rem.r][rem.c] = -2;

            orange--;
            time = rem.t;

            for (int d = 0; d < 4; d++) {
                int x = rem.r + xdir[d];
                int y = rem.c + ydir[d];

                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                    qu.add(new OPair(x, y, rem.t + 1));
                }
            }
        }
        return orange == 0 ? time : -1;
    }
}