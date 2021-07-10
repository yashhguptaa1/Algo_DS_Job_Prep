package GRAPHS.TopologicalSort;

import java.util.*;

import GRAPHS.DirectedGraph.*;

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
}
