package GRAPHS.TopologicalSort;

import GRAPHS.GRAPH;
import GRAPHS.HashedGraph.*;
import static GRAPHS.HashedGraph.*;

import java.io.*;
import java.util.*;

public class hashedKahnsAlgo {

    public static ArrayList<String> kahnsAlgo(HashMap<String,ArrayList<hashedEdge>> graph,String src, String dest)
    {
        HashMap<String,Integer> indegree =new HashMap<>();
        int WtSoFar=0;

        for (Map.Entry<String,ArrayList<hashedEdge>> entry : graph.entrySet())
        {
            indegree.put(entry.getKey(),0);
        }

        //For each src Vertex store the number of its neighbors
        //that is store the number of nodes dependent on src vertex
        for (Map.Entry<String,ArrayList<hashedEdge>> entry : graph.entrySet())
        {
            for(hashedEdge e:entry.getValue())
            {
                int count = indegree.get(e.nbr);
                count++;
                indegree.put(e.nbr,count);
            }

        }

        System.out.println("indegree = "+indegree);

        Queue<String> que=new LinkedList<>();
        ArrayList<String>ans=new ArrayList<>();

        //First store all vertices jiske upr aur koi vertices dependent nhi he

//        for (Map.Entry<String,Integer> entry : indegree.entrySet())
//        {
//            if(entry.getValue() == 0)
//            {
//                que.add(entry.getKey());
//            }
//        }
//
        //ONLY ADD SRC VERTEX
        que.add(src);

        int level = -1;
        while (que.size() != 0)
        {
            int size = que.size();
            level++;

            while (size-- > 0)
            {
                //Get + remove
                String rvtx = que.remove();

                //Add it to ans : work
                System.out.println(rvtx);
                if (rvtx == dest)
                    return ans;
                ans.add(rvtx);


                //for the removed vertex work on all its neighbors

                int minWtNbr=Integer.MAX_VALUE;
                String nbr = "";
                for (hashedEdge e : graph.get(rvtx))
                {
                    if(e.wt<minWtNbr )
                    {
                        minWtNbr=e.wt;
                        nbr=e.nbr;
                    }
                }

                if(indegree.containsKey(nbr))
                {
                    int currCount= indegree.get(nbr);
                    currCount--;
                    indegree.put(nbr,currCount);
                    que.add(nbr);

                }


//                for (hashedEdge e : graph.get(rvtx))
//                {
//                    int currCount= indegree.get(e.nbr);
//                    currCount--;
//                    indegree.put(e.nbr,currCount);
//                    if (currCount == 0)
//                        que.add(e.nbr);
//                }
            }

        }

        return ans;
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

        ArrayList<String> res= kahnsAlgo(graph,src,dest);

        System.out.println(res);

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
7 9 1
9 5 1
7
9
 */