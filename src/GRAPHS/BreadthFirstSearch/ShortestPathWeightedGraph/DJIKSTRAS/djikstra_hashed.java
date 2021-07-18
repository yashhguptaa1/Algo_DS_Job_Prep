package GRAPHS.BreadthFirstSearch.ShortestPathWeightedGraph.DJIKSTRAS;

import static GRAPHS.HashedGraph.*;
import GRAPHS.HashedGraph.*;

import java.util.*;
import java.io.*;

/*
Ques
Given a weighted bidirectional graph and a source vertex in the graph,
find shortest paths from source to all vertices in the given graph.
*/


/*
All steps are same as BFS

In place of normal Queue
Replace it with PriorityQueue (Min HEAP)
Comparison based on sum of weights

Basically We get shortest path based on minimum weightsSoFar

not applicable on negative weights
*/

/*

Shortest Path in terms of edges : BFS uses queue

Single Source Shortest path in weights : Djikstra uses minPriorityQueue

MST means saare spanning trees of a graph me se jis
spanning tree ka total weight sabse kam hota he

Djikstra algo ek src se dest tk ka vo path btata he
jiska total sum minimum ho
basically djikstra tb use krte he agr humme kissi particular src se min path
find krna he dest tk ka

prims overall graph pr lgta he
 */

/*
For graphs with negative weight edges and cycles, Bellman–Ford algorithm can be used

O(ELogV) algorithm for adjacency list
Time complexity of operations like extract-min and decrease-key value is O(LogV) for Min Heap.
 */
public class djikstra_hashed {


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
https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/

0 1 4
0 7 8
1 2 8
1 7 11
2 8 2
2 5 4
2 3 7
7 8 7
7 6 1
6 8 6
6 5 2
3 5 14
3 4 9
5 4 10

 */
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