package GRAPHS;

import java.io.*;
import java.util.*;

public class GRAPH {

    public static class Edge {

        public int nbr;
        public int wt;

        public Edge(int nbr, int wt) {
            this.nbr = nbr;
            this.wt = wt;
        }
    }

//................................................................................................................
    //USING ARRAYS OF ARRAYLIST

    public static ArrayList<Edge>[] createEmptyGraph(int tVertices) {

        ArrayList<Edge>[] graph = new ArrayList[tVertices];
        for (int i = 0; i < tVertices; i++) {
            graph[i] = new ArrayList<>();
        }
        return graph;
    }
    //BI DIRECTIONAL GRAPH
    public static void addEdge(ArrayList<Edge>[] graph, int src, int nbr, int wt) {
        graph[src].add(new Edge(nbr, wt));
        graph[nbr].add(new Edge(src, wt));
    }

    public static void display(ArrayList<Edge>[] graph) {
        for(int v = 0; v < graph.length; v++) {
            System.out.print("[" + v + "] -> ");
            for(int n = 0; n < graph[v].size(); n++) {
                Edge e = graph[v].get(n);
                System.out.print("[" + e.nbr + " @ " + e.wt + "], ");
            }
            System.out.println();
        }
    }

    //Find edge between srcVERTEX and nbrVERTEX
    //TC: O(V)
    public static int findEdge(ArrayList<Edge>[] graph, int src, int nbr)
    {
        int idx= -1;

        //go at index where srcVERTEX is present : graph[src]
        //Loop over all Edges from srcVERTEX
        //search for given nbrVertex in loop
        //for(Edge e:graph[src])
        for(int i=0;i<graph[src].size();i++)
        {
            if(graph[src].get(i).nbr == nbr)
            {
                idx = i;
                break;
            }
        }
        return idx;
    }

    //Since we have bidirectional graph to connection between two VERTICES
    //we have to remove two edges between given two VERTEX
    //TC : O(V+E)
    public static void removeEdge(ArrayList<Edge>[] graph, int src, int nbr)
    {
        int idx1 = findEdge(graph,src,nbr);    //TC: O(V)
        int idx2 = findEdge(graph,nbr,src);    //TC: O(V)

        if(idx1!= -1 && idx2!= -1)
        {
            graph[src].remove(idx1);            //TC: O(E)
            graph[nbr].remove(idx2);            //TC: O(E)
        }

    }

    //We start deleting ARRAYLIST from last index
    //cauz when we delete from end the size of list decreases
    //our pointer in each iteration points to last element

    //To delete vertex delete all its edges but dont remove the vertex itself
    //as in our graph
    //Index of Array corresponds to Vertex Number
    public static void removeVertex(ArrayList<Edge>[] graph, int src)
    {
        for(int i = graph[src].size()-1; i>=0;i--)
        {
            int nbr = graph[src].get(i).nbr;
            removeEdge(graph,src,nbr);
        }
        graph[src].add(new Edge(-1,-1));
    }


    public static void main(String[] args) throws IOException {

        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        int tVertices = Integer.parseInt(inp.readLine());
        int tEdges = Integer.parseInt(inp.readLine());

        ArrayList<Edge>[] graph=createEmptyGraph(tVertices);

        for(int i = 0; i < tEdges; i++){
            String[] parts = inp.readLine().split(" ");

            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);

            addEdge(graph,v1,v2,wt);

        }

        System.out.println("GRAPH as Adjacency List");
        display(graph);

        removeVertex(graph,3);

        System.out.println("GRAPH as Adjacency List");
        display(graph);


//        int src = Integer.parseInt(inp.readLine());
//        int dest = Integer.parseInt(inp.readLine());
//

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
 */