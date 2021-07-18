package GRAPHS.TopologicalSort.KahnsAlgoBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import GRAPHS.DirectedGraph.*;

import static GRAPHS.DirectedGraph.*;

//it gives longest path to reach a node in DAG
public class KahnsAlgo {

    public static ArrayList<Integer> kahnsAlgo(ArrayList<ArrayList<directedEdge>> graph)
    {
        int N = graph.size();
        int indegree[]=new int[N];

        //For each src Vertex store the number of its neighbors
        //that is store the number of nodes dependent on src vertex
        for (int i = 0; i < N; i++)
            for (directedEdge e : graph.get(i))
                indegree[e.nbr]++;

        Queue<Integer> que=new LinkedList<>();
        ArrayList<Integer>ans=new ArrayList<>();

        //First store all vertices jiske upr aur koi vertices dependent nhi he
        for (int i = 0; i < N; i++)
            if (indegree[i] == 0)
                que.add(i);

        int level = 0;
        while (que.size() != 0)
        {
            int size = que.size();
            while (size-- > 0)
            {
                //Get + remove
                int rvtx = que.remove();

                //Add it to ans : work
                ans.add(rvtx);

                //for the removed vertex work on all its neighbors
                for (directedEdge e : graph.get(rvtx))
                {
                    if (--indegree[e.nbr] == 0)
                        que.add(e.nbr);
                }
            }

            level++;
        }

    return ans;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        int tVertices = Integer.parseInt(inp.readLine());
        int tEdges = Integer.parseInt(inp.readLine());

        ArrayList<ArrayList<directedEdge>> graph=createDirectedGraph(tVertices);

        for(int i = 0; i < tEdges; i++){
            String[] parts = inp.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = 0;//Integer.parseInt(parts[2]);

            uniAddEdge(graph,v1,v2,wt);
        }

        printGraph(graph);

        System.out.println(kahnsAlgo(graph));

    }
}
/*
Sample Input
7
8
0 1
1 2
2 3
0 3
4 3
4 5
5 6
4 6

Output
[0, 4, 1, 5, 2, 6, 3]
 */