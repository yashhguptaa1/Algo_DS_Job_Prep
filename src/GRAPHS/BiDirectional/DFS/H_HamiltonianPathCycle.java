package GRAPHS.BiDirectional.DFS;


import GRAPHS.GRAPH.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static GRAPHS.GRAPH.*;

public class H_HamiltonianPathCycle {

    // we just store the osrc which is the src given in question
    //so that we dont loose original src and use it in base case
    public static void hamiltonian(ArrayList<Edge>[] graph, int src, int osrc, HashSet<Integer> vis, String psf) {
        if(vis.size() == graph.length - 1) {
            psf += src;
            System.out.print(psf);

            // thinking about star(cyclic) and dot(normal)
            boolean isCyclic = false;
            for(Edge e : graph[osrc]) {
                if(e.nbr == src) {
                    isCyclic = true;
                    break;
                }
            }

            if(isCyclic == true) {
                System.out.println("*");
            } else {
                System.out.println(".");
            }
            return;
        }

        vis.add(src);
        for(Edge e : graph[src]) {
            int nbr = e.nbr;
            if(vis.contains(nbr) == false) {
                hamiltonian(graph, nbr, osrc, vis, psf + src);
            }
        }
        vis.remove(src);
    }

}
//This is a source dependent problem
// It means whether we obtain hamiltonianpath can vary on basis of the given source

/*
1. You are given a graph and a src vertex.
2. You are required to find and print all hamiltonian paths and cycles starting from src. The cycles must end with "*" and paths with a "."

Note -> A hamiltonian path is such which visits all vertices without visiting any twice. A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
Note -> Print in lexicographically increasing order.

Sample Input
7
9
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2 5 10
0
Sample Output
0123456.
0123465.
0125643*
0346521*
 */