package GRAPHS.DepthFirstSearch.B_AllPaths;

//https://www.pepcoding.com/resources/online-java-foundation/graphs/mutilsovler-graph-official/ojquestion
import java.io.*;
import java.util.*;

import GRAPHS.GRAPH.*;
import static GRAPHS.GRAPH.*;

/*
1. You are given a graph, a src vertex and a destination vertex.
2. You are give a number named "criteria" and a number "k".
3. You are required to find and print the values of
 */

public class Pep_MultiSolver {

    static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;

        Pair(int wsf, String psf){
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }

    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void multisolver(ArrayList<Edge>[] graph, int src, int dst, boolean[] vis,
                                   int factor, int k, String psf, int wsf) {
        if(src == dst) {
            // smallest path
            if(wsf < spathwt) {
                spath = psf;
                spathwt = wsf;
            }
            // largest path
            if(wsf > lpathwt) {
                lpath = psf;
                lpathwt = wsf;
            }
            // ceil path using factor
            if(wsf > factor) {
                if(wsf < cpathwt) {
                    cpath = psf;
                    cpathwt = wsf;
                }
            }
            // floor path using factor
            if(wsf < factor) {
                if(fpathwt < wsf) {
                    fpathwt = wsf;
                    fpath = psf;
                }
            }
            // kth largest using min priority queue
            if(pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            } else {
                if(pq.peek().wsf < wsf) {
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }
            return;
        }
        vis[src] = true;
        for(Edge e : graph[src]) {
            int nbr = e.nbr;
            int wt = e.wt;

            if(vis[nbr] == false) {
                multisolver(graph, nbr, dst, vis, factor, k, psf + nbr, wsf + wt);
            }
        }
        vis[src] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        int tVertices = Integer.parseInt(inp.readLine());
        ArrayList<Edge>[] graph = createEmptyGraph(tVertices);

        int tEdges = Integer.parseInt(inp.readLine());
        for (int i = 0; i < tEdges; i++) {
            String[] parts = inp.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);

            addEdge(graph, v1, v2, wt);
        }

        int src = Integer.parseInt(inp.readLine());
        int dest = Integer.parseInt(inp.readLine());
        boolean vis[] = new boolean[tVertices];

        int criteria = Integer.parseInt(inp.readLine());
        int k = Integer.parseInt(inp.readLine());

        boolean[] visited = new boolean[tVertices];
        multisolver(graph, src, dest, visited, criteria, k, src + "", 0);

        System.out.println("Path with smallest weight = " + spath + "@" + spathwt);
        System.out.println("Path with largest weight = " + lpath + "@" + lpathwt);
        System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
        System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
        System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);


    }
}

/*
Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
0
6
40
3
Sample Output
0123456
012346
03456
0346
 */
