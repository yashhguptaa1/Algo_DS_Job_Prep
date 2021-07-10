package GRAPHS.BFS_ShortestPath.A_BFSnormal;

import java.io.*;
import java.util.*;

import GRAPHS.GRAPH.*;
import static GRAPHS.GRAPH.*;

//https://www.pepcoding.com/resources/online-java-foundation/graphs/is-cyclic-official/ojquestion
public class Pep_isGraphCyclic {

    public static boolean bfsForCycle(ArrayList<Edge>[] graph, int src) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(src);

        boolean[] vis=new boolean[graph.length];
        while(qu.size() > 0) {
            // 1. get + remove
            int rem = qu.remove();
            // 2. mark *
            if(vis[rem] == true) {
                // already visited -> cycle is detected
                return true;
            } else {
                // unvisited -> mark it as visited
                vis[rem] = true;
            }
            // 3. work*
            // 4. add unvisited neighbours
            for(Edge e : graph[rem]) {
                if(vis[e.nbr] == false) {
                    qu.add(e.nbr);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = createEmptyGraph(vtces);

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt=Integer.parseInt(parts[2]);
            addEdge(graph,v1,v2,wt);
        }

        int src = Integer.parseInt(br.readLine());

        System.out.println(bfsForCycle(graph,src));
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
2
Sample Output
2@2
1@21
3@23
0@210
4@234
5@2345
6@2346

 */