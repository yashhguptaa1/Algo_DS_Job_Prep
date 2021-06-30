package GRAPHS.BiDirectional.BFS_ShortestPath;

import GRAPHS.GRAPH.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static GRAPHS.GRAPH.*;
public class B_isGraphCyclic {





    //using DFS
    public static boolean dfsFroCycle(ArrayList<Edge>[] graph, int src, boolean[] vis, int par) {
        vis[src] = true;
        for(Edge e : graph[src]) {
            int nbr = e.nbr;
            // cycle is present
            //when we go to a vertex already marked but it should not be parent of
            //last vertex we visited kyunki me parent ko just abhi visit krke aaya tha
            if(vis[nbr] == true && nbr != par) {
                return true;
            }
            if(vis[nbr] == false) {
                boolean res = dfsFroCycle(graph, nbr, vis, src);
                if(res == true) return true;
            }
        }
        return false;
    }

}
