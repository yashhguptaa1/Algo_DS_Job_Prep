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

    //we find the global parent or you can say the first parent of current
    //connected component
    public static int findPar(int u)
    {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }

    // O(1)
    //seeting up leader or parent
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

        //FIND
        for (int[] edge : Edges) {
            //component 1 : u
            //component 2 : v
            int u = edge[0], v = edge[1], w = edge[2];
            int p1 = findPar(u);
            int p2 = findPar(v);

            //UNION
            //yeh do alag components ke beech me edge he inko
            //merge krke ek component bnayo
            if (p1 != p2) {
                merge(p1, p2);
                addEdge(graph, u, v, w);//to create a new SpanningTree not MST
            } else
                //we can also think of this condition as
                //agr humne EDGE u - v htadi toh graph disconnected hojayega
                //isko htate hi humme Spanning tree mil jayega
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
/*
jb humme lge ki kissi question me HashMap lga skte he jisme value is a list of more than 1 item

go with union find
 */