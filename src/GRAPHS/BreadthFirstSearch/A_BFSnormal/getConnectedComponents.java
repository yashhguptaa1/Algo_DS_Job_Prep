package GRAPHS.BreadthFirstSearch.A_BFSnormal;

import java.io.*;
import java.util.*;

import GRAPHS.GRAPH.*;
import static GRAPHS.GRAPH.*;

public class getConnectedComponents {

    public static int BFS_GCC(ArrayList<Edge>[] graph)
    {
        int N = graph.length;
        boolean vis[]=new boolean[N];
        int components = 0;
        for (int i = 0; i < N; i++)
        {
            if (!vis[i])
            {
                components++;
                BFS_Cycle(i, vis,graph);
            }
        }
        return components;
    }

    public static void BFS_Cycle(int src, boolean vis[],ArrayList<Edge>[] graph)
    {
        Queue<Integer>que=new LinkedList<>();
        que.add(src);

        int dest = 6;
        int atLevel = -1;

        boolean isCycle = false;
        int level = 0;

        while (que.size() != 0)
        {
            int size = que.size();
            while (size-- > 0)
            {
                int rvtx = que.remove();

                if (vis[rvtx])
                {
                    isCycle = true;
                    continue;
                }

                if (rvtx == dest)
                {
                    atLevel = level;
                }

                vis[rvtx] = true;
                for (Edge e : graph[rvtx])
                {
                    if (!vis[e.nbr])
                        que.add(e.nbr);

                }
            }
            level++;
        }
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
        System.out.println(BFS_GCC(graph));//,tVertices,countAll);

//        System.out.println(countAll);
//
//        int sum = 0;
//        for( int x : countAll)
//        {
//            sum += (int)Math.ceil(Math.sqrt(x));
//        }

//        System.out.println("sum = " + sum);
//        System.out.println(res);


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