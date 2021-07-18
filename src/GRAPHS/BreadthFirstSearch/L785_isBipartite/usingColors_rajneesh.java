package GRAPHS.BreadthFirstSearch.L785_isBipartite;

import java.util.*;
public class usingColors_rajneesh {
    public boolean isBipartite(int graph[][], int vis[], int src)
    {
        Queue<Integer> que=new LinkedList<>();
        que.add(src);

        int lvlColor = 0; // red
        boolean isCycle = false;

        while (que.size() != 0)
        {
            int size = que.size();
            while (size-- > 0)
            {
                int rvtx = que.remove();
                if (vis[rvtx] != -1)
                {
                    isCycle = true;
                    if (vis[rvtx] != lvlColor)
                        return false;

                    continue;
                }

                vis[rvtx] = lvlColor;
                for (int v : graph[rvtx])
                {
                    if (vis[v] == -1)
                    {
                        que.add(v);
                    }
                }
            }

            lvlColor = (lvlColor + 1) % 2;
        }

        return true;
    }

    // after reading question we know
    // complete grpah has already been given in form of
    // arrays of arrays (not adjacency matrix)

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        // -1 : not visited, 0 : red, 1 : green
        int vis[]=new int[n];
        Arrays.fill(vis,-1);

        boolean res = true;
        for (int i = 0; i < n; i++)
        {
            if (vis[i] == -1)
                res = res && isBipartite(graph, vis, i);
        }

        return res;
    }
}
