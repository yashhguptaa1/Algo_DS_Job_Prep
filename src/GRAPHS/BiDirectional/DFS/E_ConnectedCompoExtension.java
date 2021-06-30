package GRAPHS.BiDirectional.DFS;

import GRAPHS.GRAPH.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static GRAPHS.GRAPH.*;

public class E_ConnectedCompoExtension {

    public static void getConnectedComp(HashMap<Integer,ArrayList<Edge>> graph, int src, HashSet<Integer>vis, ArrayList<Integer> comp, int count[]) {

        vis.add(src);
        comp.add(src);
        count[0]++;

        for(Edge e : graph.get(src)) {
            int nbr = e.nbr;
            if(vis.contains(nbr) == false) {
                getConnectedComp(graph, nbr, vis, comp,count);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> getConnectedComponents(HashMap<Integer,ArrayList<Edge>> hashedGraph, ArrayList<Integer>allcounts) {
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        int tVertices = hashedGraph.size();

        HashSet<Integer>vis=new HashSet<>();

        for (Map.Entry<Integer,ArrayList<Edge>> entry : hashedGraph.entrySet())
        {


            if(vis.contains(entry.getKey()) == false) {

                ArrayList<Integer> comp = new ArrayList<>();
                int count[]=new int[1];
                getConnectedComp(hashedGraph, entry.getKey(), vis, comp,count);
                allcounts.add(count[0]);
                comps.add(comp);
            }
        }

        return comps;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        int tVertices = Integer.parseInt(inp.readLine());
        int tEdges = Integer.parseInt(inp.readLine());

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

        }

        HashMap<Integer,ArrayList<Edge>> hashedGraph=createHashedGraph(tEdges,allVertices,correspondingNbrs,correspondingWts);
        System.out.println();
        hashedDisplay(hashedGraph);

        ArrayList<Integer>countAll=new ArrayList<>();
        ArrayList<ArrayList<Integer>>res = getConnectedComponents(hashedGraph,countAll);

        System.out.println(countAll);

        int sum = 0;
        for( int x : countAll)
        {
            sum += (int)Math.ceil(Math.sqrt(x));
        }

        sum+= tVertices - hashedGraph.size();
        System.out.println("sum = " + sum);
        System.out.println(res);


    }


}
