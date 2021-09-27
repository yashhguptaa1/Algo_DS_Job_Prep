package GRAPHS.DepthFirstSearch.B_AllPaths;

import java.io.*;
import java.util.*;

import GRAPHS.GRAPH.*;
import static GRAPHS.GRAPH.*;

public class Pep_PrintCountAllPaths {

    public static void printAllPaths(ArrayList<Edge> graph[], int src, int dst, boolean vis[], String psf) {
        // BASE CASE
        // return if answer found
        if (src == dst) {
            psf += dst;
            System.out.println(psf);
            return;
        }

        // Since its preorder traversal
        // we mark the vertex as we go up( DEPTHVISE)
        // as its bidirectional graph a vertex points might
        // visit the already visited node again
        vis[src] = true;

        // Used to denote all possible options
        // That is all neighbours of a current vertex are
        // options which the current vertex can consider
        for (Edge e : graph[src]) {
            int nbr = e.nbr;
            int wt = e.wt;
            // if neighbour is unvisited, move toward it
            if (vis[nbr] == false) {
                printAllPaths(graph, nbr, dst, vis, psf + src + " ");
            }
        }

        // Since a vertex in graph can have more than 1 neighbour
        // its possible the current vertex can be part of more than one paths
        // so unmark it so that we can consider another path that includes current
        // vertex
        vis[src] = false;
    }

    public static void countAllPaths(ArrayList<Edge> graph[], int src, int dst, boolean vis[], int countPaths[]) {
        if (src == dst) {
            countPaths[0]++;
            return;
        }

        vis[src] = true;

        for (Edge e : graph[src]) {
            if (vis[e.nbr] == false) {
                countAllPaths(graph, e.nbr, dst, vis, countPaths);
            }
        }

        vis[src] = false;

        return;
    }

    public static int countAllPaths(ArrayList<Edge> graph[], int src, int dst, boolean vis[]) {
        // BASE CASE
        if (src == dst) {
            // last vertex is visited here
            // so return its count as 1
            return 1;
        }

        // Since its preorder traversal
        // we mark the vertex as we go up( DEPTHVISE)
        // as its bidirectional graph a vertex points might
        // visit the already visited node again
        vis[src] = true;
        int count = 0;

        // Used to denote all possible options
        // That is all neighbours of a current vertex are
        // options which the current vertex can consider
        for (Edge e : graph[src]) {
            int nbr = e.nbr;

            // if neighbour is unvisited, move toward it
            if (vis[nbr] == false) {
                count += countAllPaths(graph, nbr, dst, vis);
            }
        }

        // Since a vertex in graph can have more than 1 neighbour
        // its possible the current vertex can be part of more than one paths
        // so unmark it so that we can consider another path that includes current
        // vertex
        vis[src] = false;
        return count;
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
        printAllPaths(graph, src, dest, vis, "");

        int count[] = new int[1];

        countAllPaths(graph, src, dest, vis, count);

        int res = countAllPaths(graph, src, dest, vis);
        System.out.println("Count of all paths " + res);
    }
}

/*
 * Sample Input 7 8 0 1 10 1 2 10 2 3 10 0 3 10 3 4 10 4 5 10 5 6 10 4 6 10 0 6
 * Sample Output 0123456 012346 03456 0346
 */