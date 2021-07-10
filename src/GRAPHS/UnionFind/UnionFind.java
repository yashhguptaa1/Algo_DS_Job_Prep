package GRAPHS.UnionFind;

import java.io.*;
import java.util.*;

import GRAPHS.GRAPH.*;
import static GRAPHS.GRAPH.*;

public class UnionFind {

    static int[] par;
    static int[] size;

    // with Path Cpmpression : alpha(n) <= 4, Inverse Akermann Function
    // without path compression : O(logn)
    public static int findPar(int u) {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }

    // O(1)
    public static void merge(int p1, int p2) {
        if (size[p1] > size[p2]) {
            par[p2] = p1; // merge
            size[p1] += size[p2];
        } else {
            par[p1] = p2; // merge
            size[p2] += size[p1];
        }
    }

    // Edges : {{u,v,w}.....}
    // without Path Compression and size : V + E*V
    // Path Compression: V + E(alpha(n))
    // without Path Compression: V + ELog(V)
    public static void unionFind(int N, int[][] Edges) {

        ArrayList<Edge>[] graph = createEmptyGraph(N);

        par = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            size[i] = 1;
            par[i] = i;
        }

        boolean cycle = false;
        for (int[] edge : Edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            int p1 = findPar(u);
            int p2 = findPar(v);

            if (p1 != p2) {
                merge(p1, p2);
                addEdge(graph, u, v, w);
            } else
                cycle = true;
        }

        System.out.println(cycle);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        int tVertices = Integer.parseInt(inp.readLine());
        int tEdges = Integer.parseInt(inp.readLine());

        ArrayList<Edge>[] graph = createEmptyGraph(tVertices);

        for(int i = 0; i < tEdges; i++){
            String[] parts = inp.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);

            addEdge(graph,v1,v2,wt);
        }

        display(graph);
    }
}
