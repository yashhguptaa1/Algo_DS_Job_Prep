package GRAPHS.BFS_ShortestPath.A_BFSnormal;

import java.io.*;
import java.util.*;

import GRAPHS.GRAPH.*;
import static GRAPHS.GRAPH.*;

//https://www.pepcoding.com/resources/online-java-foundation/graphs/bfs-graph-official/ojquestion
public class Pep_BfsNormal {

    public static class BFSPair {
        int vtx;
        String psf;
        int lvl;


        BFSPair(int vtx, String psf,int lvl) {
            this.vtx = vtx;
            this.psf = psf;
            this.lvl=lvl;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph, int src) {
        Queue<BFSPair> qu = new LinkedList<>();

        int currLvl=0;
        qu.add(new BFSPair(src, "" + src,currLvl));

        boolean[] vis = new boolean[graph.length];

        while(qu.size()!= 0) {

            int sz=qu.size();
            currLvl++;
            while(sz-- > 0)
            {

                // 1. get + remove
                BFSPair rem = qu.remove();
                // 2. mark *
                if (vis[rem.vtx] == true) {
                    // already visited -> continue
                    continue;
                } else {
                    // unvisited -> mark it as visited
                    vis[rem.vtx] = true;
                }
                // 3. work -> printing
                System.out.println(rem.vtx + " @ " + rem.psf + " @ " + rem.lvl);
                // 4. add unvisited neighbours
                for (Edge e : graph[rem.vtx]) {
                    if (vis[e.nbr] == false) {
                        qu.add(new BFSPair(e.nbr, rem.psf + e.nbr, currLvl));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = createEmptyGraph(vtces);

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt=Integer.parseInt(parts[2]);
            addEdge(graph,v1,v2,wt);
        }

        int src = Integer.parseInt(br.readLine());

        bfs(graph,src);
    }


}
/*
Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2
Sample Output
2@2
1@21
3@23
0@210
4@234
5@2345
6@2346

 */