package GRAPHS.BFS_ShortestPath;

//import GRAPHS.HashedGraph;
//import GRAPHS.HashedGraph.*;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;

import static GRAPHS.HashedGraph.hashedDisplay;
import static GRAPHS.HashedGraph.hashedUniAddEdge;

import java.util.*;
import java.io.*;

public class D_DijkstraAlgorithm {

    public static class hashedEdge {
        public String nbr;
        public Integer wt;

        public hashedEdge(String nbr, Integer wt)
        {
            this.nbr=nbr;
            this.wt=wt;
        }
    }

    public static void hashedDisplay(HashMap<String,ArrayList<hashedEdge>> hashedGraph)
    {
        for(String key:hashedGraph.keySet())
        {
            System.out.print("{" + key + "} ->");
            for(hashedEdge e:hashedGraph.get(key))
            {
                System.out.print("[" +e.nbr+" @ "+e.wt+"], ");
            }
            System.out.println();
        }

    }


    public static void hashedUniAddEdge(HashMap<String,ArrayList<hashedEdge>> hashedGraph, String v1, String v2, Integer wt)
    {
        if(hashedGraph.containsKey(v1)==true)
        {
            hashedGraph.get(v1).add(new hashedEdge(v2,wt));
        }
        else
        {
            hashedGraph.put(v1,new ArrayList<>());
            hashedGraph.get(v1).add(new hashedEdge(v2,wt));
        }

    }



    /*
    All steps are same as BFS
    In place of normal Queue
    Replace it with PriorityQueue (Min HEAP)
    Comparison based on sum of weights

    Basically We get shortest path based on minimum weightsSoFar

    not applicable on negative weights
    */
    public static class DPair implements Comparable<DPair> {
        int wsf;
        String vtx;
        String psf;

        public DPair(String vtx, String psf, int wsf) {
            this.vtx = vtx;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(DPair o) {
            return this.wsf - o.wsf;
        }
    }

    public static void dijkstras(HashMap<String, ArrayList<hashedEdge>>graph, String src,String dest) {
        PriorityQueue<DPair> pq = new PriorityQueue<>();
        pq.add(new DPair(src, "" + src, 0));

        HashMap<String,Integer> wtSoFar=new HashMap<>();
        HashSet<String>vis=new HashSet<>();

        while (pq.size() > 0) {
            // 1. get + remove
            DPair rem = pq.remove();
            // 2. mark*

            //if(rem.vtx == dest)
              //  System.out.println(rem.vtx + " via " + rem.psf + " @ " + rem.wsf);

            if(vis.contains(rem.vtx))
                continue;

            vis.add(rem.vtx);

            // 3. work -> printing of paths
            //if(rem.vtx == dest)

            wtSoFar.put(rem.vtx,rem.wsf);
            //System.out.println(rem.vtx + " via " + rem.psf + " @ " + rem.wsf);

            // 4. add neighbours
            for (hashedEdge e : graph.get(rem.vtx)) {
                String nbr = e.nbr;
                if (!vis.contains(nbr)) {
                    pq.add(new DPair(nbr, rem.psf + nbr, rem.wsf + e.wt));
                }
            }
        }


        System.out.println(wtSoFar.get(dest));
    }


    public static void main(String[] args) throws IOException {

        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        HashMap<String ,ArrayList<hashedEdge>> graph=new HashMap<>();

        int tVertices = Integer.parseInt(inp.readLine());

        for(int i=0 ;i<tVertices;i++)
        {
            String vertex = inp.readLine().trim();
            graph.put(vertex,new ArrayList<hashedEdge>());
        }

        int tEdges = Integer.parseInt(inp.readLine());

        for(int i = 0; i < tEdges; i++){
            String[] parts = inp.readLine().split(" ");

            String v1 = parts[0];
            String v2 = parts[1];
            int wt = Integer.parseInt(parts[2]);

            hashedUniAddEdge(graph,v1,v2,wt);

        }

        System.out.println("GRAPH as Adjacency List");
        hashedDisplay(graph);

        String src = inp.readLine().trim();
        String dest = inp.readLine().trim();

        dijkstras(graph,src,dest);

        //ArrayList<String> res= kahnsAlgo(graph,src,dest);

        //System.out.println(res);

    }

}
/*
4
2
5
7
9
4
2 9 2
7 2 3
7 9 7
9 5 1
7
9

 */