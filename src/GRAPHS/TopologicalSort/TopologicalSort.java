package GRAPHS.TopologicalSort;
import java.io.*;
import java.util.*;

import GRAPHS.DirectedGraph.*;
import static GRAPHS.DirectedGraph.*;

//Used in DAG
public class TopologicalSort {

    //Hum PostOrderPhase me stack me store krte he
    //We cant print in PostorderPhase cauz
    //vo Topological sort ka bilkul Ulta print krega
    //That is we would get Order Of compilation by printing in Postorder

    // ~~~~~~Topological sort-> valid for directed and acyclic graph~~~~~~~~
    public static void dfs_topo(ArrayList<ArrayList<directedEdge>> graph, int src, boolean[] vis, Stack<Integer> st) {

        vis[src] = true;
        for(directedEdge e : graph.get(src)) {
            int nbr = e.nbr;
            if(vis[nbr] == false) {
                dfs_topo(graph, nbr, vis, st);
            }
        }

        st.push(src);
    }

    public static void topologicalSort(ArrayList<ArrayList<directedEdge>> graph) {
        int n = graph.size();

        boolean[] vis = new boolean[n];

        Stack<Integer> st = new Stack<>();
        for(int v = 0; v < n; v++) {
            if(vis[v] == false) {
                dfs_topo(graph, v, vis, st);
            }
        }

        // order of compilation is just reverse of topological sort
        // and in stack we achieve topological sort
        // but for now, we have to print topo. sort
        while(st.size() > 0) {
            System.out.println(st.pop());
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        int tVertices = Integer.parseInt(inp.readLine());
        int tEdges = Integer.parseInt(inp.readLine());

        ArrayList<ArrayList<directedEdge>> graph=createDirectedGraph(tVertices);

        for(int i = 0; i < tEdges; i++){
            String[] parts = inp.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = 0;//Integer.parseInt(parts[2]);

            uniAddEdge(graph,v1,v2,wt);
        }

        printGraph(graph);

        topologicalSort(graph);

    }

}
/*
Sample Input
7
8
0 1
1 2
2 3
0 3
4 3
4 5
5 6
4 6
Sample Output
4
5
6
0
1
2
3
 */