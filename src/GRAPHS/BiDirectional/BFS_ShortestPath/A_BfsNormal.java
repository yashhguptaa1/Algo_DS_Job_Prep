package GRAPHS.BiDirectional.BFS_ShortestPath;

import GRAPHS.GRAPH.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static GRAPHS.GRAPH.*;

public class A_BfsNormal {

    public static class BFSPair {
        int vtx;
        String psf;

        BFSPair(int vtx, String psf) {
            this.vtx = vtx;
            this.psf = psf;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph, int src) {
        Queue<BFSPair> qu = new LinkedList<>();
        qu.add(new BFSPair(src, "" + src));
        boolean[] vis = new boolean[graph.length];

        while(qu.size() > 0) {
            // 1. get + remove
            BFSPair rem = qu.remove();
            // 2. mark *
            if(vis[rem.vtx] == true) {
                // already visited -> continue
                continue;
            } else {
                // unvisited -> mark it as visited
                vis[rem.vtx] = true;
            }
            // 3. work -> printing
            System.out.println(rem.vtx + " @ " + rem.psf);
            // 4. add unvisited neighbours
            for(Edge e : graph[rem.vtx]) {
                if(vis[e.nbr] == false) {
                    qu.add(new BFSPair(e.nbr, rem.psf + e.nbr));
                }
            }
        }
    }

}
