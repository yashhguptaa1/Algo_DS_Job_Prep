package GRAPHS.DepthFirstSearch.D_ConnectedComponents;

import java.util.*;

import GRAPHS.GRAPH.*;

//https://www.pepcoding.com/resources/online-java-foundation/graphs/is-graph-connected-official/ojquestion
public class Pep_IsGraphConnected {

    /*
    1. You are given a graph.
    2. You are required to find and print if the graph is connected (there is a path from
     every vertex to every other).
     */
    public static boolean isAllVertexConnected(ArrayList<Edge>[] graph)
    {
        int count = 0;
        int n = graph.length;
        boolean[] vis = new boolean[n];

        for(int v = 0; v < n; v++) {
            if(vis[v] == false) {
                count++;

                //if number of connected components is greater than 1 then graph is not connected
                if(count > 1) {
                    return false;
                }
                gcc(graph, v, vis);
            }
        }
        return true;

    }

    //dfs
    public static void gcc(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        for(Edge e : graph[src]) {
            int nbr = e.nbr;
            if(vis[nbr] == false) {
                gcc(graph, nbr, vis);
            }
        }
    }

}
