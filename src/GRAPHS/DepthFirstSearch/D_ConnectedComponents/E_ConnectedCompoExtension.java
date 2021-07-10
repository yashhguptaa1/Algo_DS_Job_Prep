package GRAPHS.DepthFirstSearch.D_ConnectedComponents;

import java.io.*;
import java.util.*;
import GRAPHS.HashedGraph.*;
import static GRAPHS.HashedGraph.*;

public class E_ConnectedCompoExtension {

    public static void getConnectedComp(HashMap<String,ArrayList<hashedEdge>> graph, String src, HashSet<String>vis, ArrayList<String> comp, int count[]) {

        vis.add(src);
        comp.add(src);
        count[0]++;

        for(hashedEdge e : graph.get(src)) {
            String nbr = e.nbr;
            if(vis.contains(nbr) == false) {
                getConnectedComp(graph, nbr, vis, comp,count);
            }
        }
    }

    public static ArrayList<ArrayList<String>> getConnectedComponents(HashMap<String,ArrayList<hashedEdge>> hashedGraph, ArrayList<Integer>allcounts) {

        ArrayList<ArrayList<String>> comps = new ArrayList<>();
        HashSet<String>vis=new HashSet<>();

        for (Map.Entry<String,ArrayList<hashedEdge>> entry : hashedGraph.entrySet())
        {
            if(vis.contains(entry.getKey()) == false) {

                ArrayList<String> comp = new ArrayList<>();
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

        HashMap<String,ArrayList<hashedEdge>> hashedGraph=new HashMap<>();

        for(int i = 0; i < tEdges; i++){
            String[] parts = inp.readLine().split(" ");

            String v1 = parts[0];
            String v2 = parts[1];
            int wt = Integer.parseInt(parts[2]);

            hashedAddEdge(hashedGraph,v1,v2,wt);
        }

        System.out.println();
        hashedDisplay(hashedGraph);

        ArrayList<Integer>countAll=new ArrayList<>();
        ArrayList<ArrayList<String>>res = getConnectedComponents(hashedGraph,countAll);

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

/*
Sample Input
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10
Sample Output
[[0, 1], [2, 3], [4, 5, 6]]

10
5
1 2 10
1 3 10
2 4 10
3 5 10
7 8 10
 */
