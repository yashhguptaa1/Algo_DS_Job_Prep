package GRAPHS.DepthFirstSearch.D_ConnectedComponents;

import java.io.*;
import java.util.*;

import GRAPHS.GRAPH.*;
import static GRAPHS.GRAPH.*;


public class Pep_Getconnectedcompo {

    //dfs to ensure each vertex is visited only once
    //TC: O(E+V)
    public static void getConnectedComp(ArrayList<Edge>[] graph, int src, boolean[] vis, ArrayList<Integer> comp,int count[]) {
        vis[src] = true;
        comp.add(src);
        count[0]++;

        for(Edge e : graph[src]) {
            int nbr = e.nbr;
            if(vis[nbr] == false) {
                getConnectedComp(graph, nbr, vis, comp,count);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<Edge>[] graph,int tVertices,ArrayList<Integer>allcounts) {
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] vis = new boolean[tVertices];

        for(int v = 0; v < tVertices; v++) {
            if(vis[v] == false) {

                ArrayList<Integer> comp = new ArrayList<>();
                int count[]=new int[1];
                getConnectedComp(graph, v, vis, comp,count);
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

        ArrayList<Edge>[] graph = createEmptyGraph(tVertices);

        for (int i = 0; i < tEdges; i++) {
            String[] parts = inp.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);

            addEdge(graph, v1, v2, wt);
        }

        display(graph);

        ArrayList<Integer>countAll=new ArrayList<>();
        ArrayList<ArrayList<Integer>>res = getConnectedComponents(graph,tVertices,countAll);

        System.out.println(countAll);

        int sum = 0;
        for( int x : countAll)
        {
            sum += (int)Math.ceil(Math.sqrt(x));
        }

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

/*
if you notice once we mark a vertex as visited we dont unmark it as
doing it we would be considering same  connected compo with different starting vertex

so we unmark when we want to go through same vertex again to obtain some different result
like in print all paths
we want to find different path from same vertex again so we unmark it
 */