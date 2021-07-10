package GRAPHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
We have learnt about Generic class in Java.
We can also use them to code for Graph in Java.
The Graph Class is implemented using HashMap in Java.
As we know HashMap contains a key and a value,
we represent nodes as keys and their adjancency list in values in the graph.
 */
public class HashedGraph {

    public static class hashedEdge {
        public String nbr;
        public Integer wt;
        public int minWtSoFar=0;

        public hashedEdge(String nbr, Integer wt)
        {
            this.nbr=nbr;
            this.wt=wt;
        }
    }

    public static void hashedUniAddEdge(HashMap<String,ArrayList<hashedEdge>> hashedGraph,String v1,String v2,Integer wt)
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

    public static void hashedAddEdge(HashMap<String,ArrayList<hashedEdge>> hashedGraph, String v1, String v2, Integer wt)
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

        if(hashedGraph.containsKey(v2)==true)
        {
            hashedGraph.get(v2).add(new hashedEdge(v1,wt));
        }
        else
        {
            hashedGraph.put(v2,new ArrayList<>());
            hashedGraph.get(v2).add(new hashedEdge(v1,wt));
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
    public static void main(String[] args) throws IOException {

        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String,ArrayList<hashedEdge>> hashedGraph=new HashMap<>();

        int tVertices = Integer.parseInt(inp.readLine());
        int tEdges = Integer.parseInt(inp.readLine());

        for(int i = 0; i < tEdges; i++){
            String[] parts = inp.readLine().split(" ");

            String v1 = parts[0];
            String v2 = parts[1];
            int wt = Integer.parseInt(parts[2]);

            hashedAddEdge(hashedGraph,v1,v2,wt);
        }

    }

}
