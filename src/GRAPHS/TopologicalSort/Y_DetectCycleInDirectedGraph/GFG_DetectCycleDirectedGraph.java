package GRAPHS.TopologicalSort.Y_DetectCycleInDirectedGraph;

import java.util.*;

import GRAPHS.DirectedGraph.*;

public class GFG_DetectCycleDirectedGraph {
    // cycle detection in directed graph : https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
    public boolean dfsCycle(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis, boolean[] mypath) {
        vis[src] = true;

        //mypath helps in tracking whether current element is part of the
        //cyclic path being considered currently
        mypath[src] = true;
        for(int nbr : graph.get(src)) {
            if(mypath[nbr] == true) {
                return true;
            } else if(vis[nbr] == false) {
                boolean res = dfsCycle(graph, nbr, vis, mypath);
                if(res == true) return true;
            }
        }

        mypath[src] = false;
        return false;
    }

    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> graph)  {
        boolean[] vis = new boolean[n];
        boolean[] mypath = new boolean[n];
        for(int v = 0; v < n; v++) {
            if(vis[v] == false) {
                boolean res = dfsCycle(graph, v, vis, mypath);
                if(res == true) return true;
            }
        }
        return false;
    }
    public static boolean bfsForCycle(ArrayList<ArrayList<directedEdge>> graph, int src, boolean[] vis) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(src);

        while(qu.size() > 0) {
            // 1. get + remove
            int rem = qu.remove();
            // 2. mark *
            if(vis[rem] == true) {
                // already visited -> cycle is detected
                return true;
            } else {
                // unvisited -> mark it as visited
                vis[rem] = true;
            }
            // 3. work*
            // 4. add unvisited neighbours
            for(directedEdge e : graph.get(rem)) {
                if(vis[e.nbr] == false) {
                    qu.add(e.nbr);
                }
            }
        }
        return false;
    }

    public static boolean isCyclePresent_DFSTopo(ArrayList<ArrayList<directedEdge>> graph,int src, int vis[], ArrayList<Integer>ans)
    {
        //Mark current vertex as a part of current path
        vis[src] = 0;
        boolean res = false;

        for (directedEdge e : graph.get(src))
        {
            if (vis[e.nbr] == -1)
            { // unvisited
                res = res || isCyclePresent_DFSTopo(graph,e.nbr, vis, ans);
            }
            else if (vis[e.nbr] == 0)
            {
                //the vertex that was marked as part of current path
                //it is being visited again
                // there is cycle.
                return true;
            }
        }

        vis[src] = 1;
        ans.add(src);
        return res;
    }

    public static ArrayList<Integer>isCyclePresent_DFS(ArrayList<ArrayList<directedEdge>> graph)
    {
        int N=graph.size();

        int vis[]=new int[N];
        Arrays.fill(vis,-1);

        ArrayList<Integer>ans=new ArrayList<>();
        boolean res = false;
        for (int i = 0; i < N; i++)
        {
            if (vis[i] == -1)
            {
                res = res || isCyclePresent_DFSTopo(graph,i, vis, ans);
            }
        }

        if (res)
            ans.clear();
        return ans;
    }
}
