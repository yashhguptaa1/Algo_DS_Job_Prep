package GRAPHS.BreadthFirstSearch.ShortestPathWeightedGraph;

import java.util.*;
/*
Given a graph and a source vertex src in graph,
find shortest paths from src to all vertices in the given graph.
The graph may contain negative weight edges.
 */

/*
Dijkstra doesn’t work for Graphs with negative weight edges,
Bellman-Ford works for such graphs. Bellman-Ford is also simpler than Dijkstra and suites well for distributed systems.
But TC of Bellman-Ford is O(VE), which is more than Dijkstra.
 */

/*
Unlike Dijkstra’s where we need to find the minimum value of all vertices, in Bellman-Ford, edges are considered one by one.
3) Bellman-Ford does not work with undirected graph with negative edges as it will declared as negative cycle.
1) The standard Bellman-Ford algorithm reports the shortest path only if there are no negative weight cycles.
Modify it so that it reports minimum distances even if there is a negative weight cycle.
 */
public class BellmanFord {
    // Bellman Ford.
    // {{u,v,w}.....}
    public static void bellmanFord(int src, int[][] edges, int N) {

        //solving 2d matrix dp by using two 1d array
        //one stores previous state
        //other calculates current state
        int[] dis = new int[N];
        Arrays.fill(dis, (int) 1e9);

        dis[src] = 0;
        boolean isNegativeCycle = false;

        for (int EdgeCount = 1; EdgeCount <= N; EdgeCount++) {
            int[] ndis = new int[N];

            //copying all old state
            for (int i = 0; i < N; i++)
                ndis[i] = dis[i];

            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                if (dis[u] != (int) 1e9 && dis[u] + w < ndis[v]) {

                    //if we are still getting shorter path
                    if (EdgeCount == N) {
                        isNegativeCycle = true;
                        break;
                    }

                    ndis[v] = dis[u] + w;
                }
            }

            dis = ndis;
        }
    }
}
