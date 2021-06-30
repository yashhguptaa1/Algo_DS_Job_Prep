package GRAPHS;

import java.io.*;
import java.util.*;

public class GRAPH {

    public static class Edge {

        public int src;
        public int nbr;
        public int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    //Uni Directional Graph

    //Bi Directional Graph

    public static void addEdge(ArrayList<Edge>[] graph, int src, int nbr, int wt) {
        graph[src].add(new Edge(src, nbr, wt));
        graph[nbr].add(new Edge(nbr, src, wt));
    }
    public static void display(ArrayList<Edge>[] graph) {
        for(int v = 0; v < graph.length; v++) {
            System.out.print("[" + v + "] -> ");
            for(int n = 0; n < graph[v].size(); n++) {
                Edge e = graph[v].get(n);
                System.out.print("[" + e.src + "-" + e.nbr + " @ " + e.wt + "], ");
            }
            System.out.println();
        }
    }
    public static ArrayList<Edge>[] createEmptyGraph(int v) {

        // n-> number of vertices
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        return graph;
    }

    //Using HashMap

    public static void hashedAddEdge(HashMap<Integer,ArrayList<Edge>>graph, int src, int nbr, int wt) {
        graph.get(src).add(new Edge(src, nbr, wt));
        graph.get(nbr).add(new Edge(nbr, src, wt));
    }

    public static void hashedDisplay(HashMap<Integer,ArrayList<Edge>>graph) {

        for (Map.Entry<Integer,ArrayList<Edge>> entry : graph.entrySet())
        {
            System.out.print("[" + entry.getKey() + "] -> ");

            for(Edge e : entry.getValue())
            {
                System.out.print("[" + e.src + "-" + e.nbr + " @ " + e.wt + "], ");
            }
            System.out.println();
        }
    }

    public static HashMap<Integer,ArrayList<Edge>>createHashedGraph(int tEdges,ArrayList<Integer>allVertices,ArrayList<Integer>correspondingNbrs,ArrayList<Integer>correspondingWts)
    {
        HashMap<Integer,ArrayList<Edge>> graph=new HashMap<>();

        for(int i = 0; i < tEdges; i++){

            graph.put(allVertices.get(i),new ArrayList<>());
            graph.put(correspondingNbrs.get(i),new ArrayList<>());
        }


        for(int i = 0; i < tEdges; i++){

            int v1=allVertices.get(i);
            int v2=correspondingNbrs.get(i);
            int wt=correspondingWts.get(i);
            hashedAddEdge(graph,v1,v2,wt);

        }

        return graph;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        int tVertices = Integer.parseInt(inp.readLine());
        int tEdges = Integer.parseInt(inp.readLine());

        ArrayList<Edge>[] graph=createEmptyGraph(tVertices);

        ArrayList<Integer>allVertices=new ArrayList<>();
        ArrayList<Integer>correspondingNbrs=new ArrayList<>();
        ArrayList<Integer>correspondingWts=new ArrayList<>();

        for(int i = 0; i < tEdges; i++){
            String[] parts = inp.readLine().split(" ");

            int v1 = Integer.parseInt(parts[0]);
            allVertices.add(v1);

            int v2 = Integer.parseInt(parts[1]);
            correspondingNbrs.add(v2);

            int wt = Integer.parseInt(parts[2]);
            correspondingWts.add(wt);

            addEdge(graph,v1,v2,wt);

        }

        display(graph);

        HashMap<Integer,ArrayList<Edge>> hashedGraph=createHashedGraph(tEdges,allVertices,correspondingNbrs,correspondingWts);

        System.out.println();

        hashedDisplay(hashedGraph);

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