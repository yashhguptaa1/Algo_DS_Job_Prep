package GRAPHS.DepthFirstSearch.A_hasPath;

import java.io.*;
import java.util.*;

import GRAPHS.GRAPH.*;
import static GRAPHS.GRAPH.*;

public class Pep_hasPath {

    // humme agr ek bhi path mil jaaye from given src to dest
    // toh hum return true krdenge ki atleast one path exists
    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dst, boolean vis[]) {

        // BC
        if (src == dst)
            return true;

        // PREPHASE
        // Only Mark since need to check only single path
        vis[src] = true;

        // LEVEL : each vertex denotes each level
        for (Edge e : graph[src]) {

            // OPTIONS : For all unvisited neighbors
            if (vis[e.nbr] == false) {

                // POSTORDER RECURSIVE CALL : return type
                boolean hasNbrPath = hasPath(graph, e.nbr, dst, vis);

                // POSTPHASE WORK
                if (hasNbrPath == true)
                    return true;
            }
        }

        // backtrack krte hue hum false mark tb krte he jb mjhe saare Paths explore krne
        // ho
        // agr false mark nhi krta toh ek hi path explore hoga

        return false;
    }

    public static boolean hasPathBtr(ArrayList<Edge> graph[], int src, int dst, boolean vis[]) {
        if (src == dst)
            return true;

        // Only Mark since need to check only single path
        vis[src] = true;
        boolean res = false;

        for (Edge e : graph[src]) {

            // For all unvisited neighbors
            if (vis[e.nbr] == false) {
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

        for (int i = 0; i < tEdges; i++) {
            String[] parts = inp.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);

            addEdge(graph, v1, v2, wt);
        }

        display(graph);

        int src = Integer.parseInt(inp.readLine());
        int dest = Integer.parseInt(inp.readLine());
        boolean vis[] = new boolean[tVertices];
        System.out.println(hasPath(graph, src, dest, vis));

    }
}