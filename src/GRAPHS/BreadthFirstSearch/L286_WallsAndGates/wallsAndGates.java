package GRAPHS.BreadthFirstSearch.L286_WallsAndGates;

import java.util.LinkedList;
import java.util.Queue;

public class wallsAndGates {

    public void wallsAndGates(int[][] rooms)
    {

        int n = rooms.length;
        int m = rooms[0].length;

        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        Queue<Integer> que = new LinkedList<>();

        //To stop BFS_loop
        int countOfRooms = 0;
        int distance = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (rooms[i][j] == 0) // gates//collect all src vtx
                    que.add(i * m + j);
                else if (rooms[i][j] == 2147483647)
                    countOfRooms++;

        while (que.size() != 0)
        {
            int size = que.size();
            while (size-- > 0)
            {
                int idx = que.remove();
                int r = idx / m;
                int c = idx % m;

                for (int d = 0; d < 4; d++)
                {
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];
                    if (x >= 0 && y >= 0 && x < n && y < m && rooms[x][y] == 2147483647)
                    {
                        countOfRooms--;
                        rooms[x][y] = distance + 1;
                        que.add(x * m + y);

                        if (countOfRooms == 0)
                            return;
                    }
                }
            }
            distance++;
        }
    }

}
