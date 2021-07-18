package GRAPHS.BreadthFirstSearch.ShortestPathWeightedGraph.DJIKSTRAS;

import GRAPHS.GRAPH.*;
import java.util.*;

public class djikstra_shreesh {
    public static class DPair implements Comparable<DPair> {
        int wsf;
        int vtx;
        String psf;

        public DPair(int vtx, String psf, int wsf) {
            this.vtx = vtx;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(DPair o) {
            return this.wsf - o.wsf;
        }
    }

    public static void dijkstras(ArrayList<Edge>[] graph, int src) {
        //track unvisited nodes
        PriorityQueue<DPair> pq = new PriorityQueue<>();
        pq.add(new DPair(src, "" + src, 0));

        //mark visited node true;
        boolean[] vis = new boolean[graph.length];

        while(pq.size() > 0) {
            // 1. get + remove
            DPair rem = pq.remove();
            // 2. mark*
            if(vis[rem.vtx] == true) {
                continue;
            }
            vis[rem.vtx] = true;
            // 3. work -> printing of path2qas
            System.out.println(rem.vtx + " via " + rem.psf + " @ " + rem.wsf);
            // 4. add neighbours
            for(Edge e : graph[rem.vtx]) {
                int nbr = e.nbr;
                if(vis[nbr] == false) {
                    pq.add(new DPair(nbr, rem.psf + nbr, rem.wsf + e.wt));
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
/*
Given a weighted bidirectional graph and a source vertex in the graph,
find shortest paths from source to all vertices in the given graph.

https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/


 */