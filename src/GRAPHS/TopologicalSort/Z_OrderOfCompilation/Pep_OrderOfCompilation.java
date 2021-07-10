package GRAPHS.TopologicalSort.Z_OrderOfCompilation;

import GRAPHS.GRAPH.*;
import java.util.*;

//https://www.pepcoding.com/resources/online-java-foundation/graphs/compilation-order-official/ojquestion
public class Pep_OrderOfCompilation {

    // ~~~~~~Topological sort-> valid for directed and acyclic graph~~~~~~~~
    public static void tsHelper(ArrayList<Edge>[] graph, int src, boolean[] vis, Stack<Integer> st) {
        vis[src] = true;
        for(Edge e : graph[src]) {
            int nbr = e.nbr;
            if(vis[nbr] == false) {
                tsHelper(graph, nbr, vis, st);
            }
        }

        st.push(src);
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        int n = graph.length;

        boolean[] vis = new boolean[n];

        Stack<Integer> st = new Stack<>();
        for(int v = 0; v < n; v++) {
            if(vis[v] == false) {
                tsHelper(graph, v, vis, st);
            }
        }

        // order of compilation is just reverse of topological sort
        // and in stack we achieve topological sort
        // but for now, we have to print topo. sort
        while(st.size() > 0) {
            System.out.println(st.pop());
        }
    }



}
/*
1. You are given a directed acyclic graph. The vertices represent tasks and edges represent
    dependencies between tasks.
2. You are required to find and print the order in which tasks could be done. The task that should be
    done at last should be printed first and the task which should be done first should be printed last.
    This is called topological sort. Check out the question video for details.

Topological sort -> A permutation of vertices for a directed acyclic graph is called topological sort if
                                    for all directed edges uv, u appears before v in the graph

 */
