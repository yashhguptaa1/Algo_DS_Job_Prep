package GRAPHS.DepthFirstSearch.C_HamiltonianPathsCycle;

//https://www.pepcoding.com/resources/online-java-foundation/graphs/hamiltonian-official/ojquestion

import java.io.*;
import java.util.*;

import GRAPHS.GRAPH.*;
import static GRAPHS.GRAPH.*;

public class Pep_HamiltonianPathCycle {

    // we just store the osrc which is the src given in question
    //so that we dont loose original src and use it in base case
    public static void hamiltonian(ArrayList<Edge>[] graph, int src, int osrc, HashSet<Integer> vis, String psf) {

        //our visited hashset/array contains vertices joki humne abhitak visit
        //krlyie
        //ab base case me hum last vertex add krte he psf me
        //usko visited me dalne ki jaroorat nhi kyunki vo last vertex he path ka
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

        //
        vis.add(src);
        for(Edge e : graph[src]) {
            int nbr = e.nbr;
            if(vis.contains(nbr) == false) {
                hamiltonian(graph, nbr, osrc, vis, psf + src);
            }
        }
        vis.remove(src);
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

        hamiltonian(graph,src,src,new HashSet<Integer>(),"");
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