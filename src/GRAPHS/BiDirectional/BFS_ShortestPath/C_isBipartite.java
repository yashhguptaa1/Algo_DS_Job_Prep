package GRAPHS.BiDirectional.BFS_ShortestPath;
import GRAPHS.GRAPH.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static GRAPHS.GRAPH.*;

//Kya me apne graph ko aise two sets me divide kr
//ek set me jitne bhi vertices he unke beech me edge nhi honi chahiye
//do sets me jo vertices ke across edges ho skti he but not within the set

//by doing dry run
//or by making different graphs
//Acyclic graphs humesha bipartite honge
//cyclic vale me check krna pdegaa kb bipartite he ki nhi
//we deduced even edged graphs are bipartite
//and odd edged graphs are never bipartite

//agr same lvl / discover time pr hum same vertex ko revisit krte he toh mtlb its'
//even sized graph
public class C_isBipartite {

    public static class BPair {
        int vtx;
        int level; // discovery time //mtlb kis time pr mene is vtx ko search kiya

        public BPair(int vtx, int level) {
            this.vtx = vtx;
            this.level = level;
        }
    }

    public static boolean isBipertiteComp(ArrayList<Edge>[] graph, int src, int[] vis) {
        Queue<BPair> qu = new LinkedList<>();

        qu.add(new BPair(src, 0));
        while(qu.size() > 0) {
            BPair rem = qu.remove();

            if(vis[rem.vtx] != -1) {
                // already discovered
                // 1. if again discovered with same level-> continue
                // 2. if again discovered, but with different level -> return false,
                // because odd size cycle is present in graph
                if(vis[rem.vtx] == rem.level)
                    continue;
                else
                    return false;
            }
            vis[rem.vtx] = rem.level;

            for(Edge e : graph[rem.vtx]) {
                int nbr = e.nbr;
                if(vis[nbr] == -1) {
                    qu.add(new BPair(nbr, rem.level + 1));
                }
            }
        }
        return true;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        for(int v = 0; v < n; v++) {
            if(vis[v] == -1) {
                boolean res = isBipertiteComp(graph, v, vis);
                if(res == false) return false;
            }
        }
        return true;
    }
}
