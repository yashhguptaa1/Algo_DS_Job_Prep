package GRAPHS.DepthFirstSearch.A_hasPath;


import java.io.*;
import java.util.*;

import GRAPHS.GRAPH.*;
import static GRAPHS.GRAPH.*;

public class Pep_hasPath {


    //backtrack krte hue hum false mark tb krte he jb mjhe saare Paths explore krne ho
    //agr false mark nhi krta toh ek hi path explore hoga

    //humme agr ek bhi path mil jaaye from given src to dest so hum return true krdenge
    public static boolean hasPath(ArrayList <Edge> graph[],int src,int dst,boolean vis[] )
    {
        if(src == dst)
            return true;

        //Only Mark since need to check only single path
        vis[src]=true;

        for(Edge e : graph[src])
        {
            //For all unvisited neighbors
            if(vis[e.nbr] == false) {
                boolean hasNbrPath = hasPath(graph, e.nbr, dst, vis);
                if (hasNbrPath == true)
                    return true;
            }
        }
        return false;
    }

    public static boolean hasPathBtr(ArrayList <Edge> graph[],int src,int dst,boolean vis[] )
    {
        if(src == dst)
            return true;

        //Only Mark since need to check only single path
        vis[src]=true;
        boolean res=false;

        for(Edge e : graph[src])
        {
            //For all unvisited neighbors
            if(vis[e.nbr] == false) {
                res = res || hasPathBtr(graph, e.nbr, dst, vis);
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        int tVertices = Integer.parseInt(inp.readLine());
        int tEdges = Integer.parseInt(inp.readLine());

        ArrayList<Edge>[] graph = createEmptyGraph(tVertices);

        for(int i = 0; i < tEdges; i++){
            String[] parts = inp.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);

            addEdge(graph,v1,v2,wt);
        }

        display(graph);

        int src = Integer.parseInt(inp.readLine());
        int dest = Integer.parseInt(inp.readLine());
        boolean vis[]=new boolean[tVertices];
        System.out.println(hasPath(graph,src,dest,vis));

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
0
6
 */