package GRAPHS.BreadthFirstSearch.A_BFSnormal;

import java.io.*;
import java.util.*;

import GRAPHS.GRAPH.*;
import static GRAPHS.GRAPH.*;

public class ShortestPath {

    void BFS_shortestPath(ArrayList<Edge>[] graph, int src) {
        Queue<Integer> que = new LinkedList<>();
        que.add(src);

        boolean[] vis = new boolean[graph.length];

        int dest = 6;
        int atLevel = -1;

        int level = 0;
        vis[src] = true;

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.remove();

                // mark visited as soon as you store vrtx
                for (Edge e : graph[rvtx]) {
                    if (!vis[e.nbr]) {
                        vis[e.nbr] = true;
                        que.add(e.nbr);
                    }

                    if (e.nbr == dest)
                        atLevel = level + 1;
                }
            }
            level++;
        }

        System.out.println(dest + " present at : " + atLevel);
    }

    // Using a parent array
    public static void BFS_printshortestPath(ArrayList<Edge>[] graph, int src) {
        Queue<Integer> que = new LinkedList<>();
        que.add(src);

        int n = graph.length;
        boolean[] vis = new boolean[n];

        int dest = 6;
        int atLevel = -1;

        int level = 0;
        vis[src] = true;

        int par[] = new int[n];
        Arrays.fill(par, -1);

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.remove();
                for (Edge e : graph[rvtx]) {
                    if (!vis[e.nbr]) {
                        vis[e.nbr] = true;
                        que.add(e.nbr);
                        par[e.nbr] = rvtx;
                    }

                    if (atLevel == -1 && e.nbr == dest)
                        atLevel = level + 1;
                }
            }
            level++;
        }

        System.out.println(dest + " present at : " + atLevel);

        int idx = dest;
        while (idx != -1) {
            System.out.print(idx + " -> ");
            idx = par[idx];
        }
        System.out.print(idx);
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
            int wt = Integer.parseInt(parts[2]);
            addEdge(graph, v1, v2, wt);
        }

        int src = Integer.parseInt(br.readLine());

        BFS_printshortestPath(graph, src);
    }

}
/*
 * Sample Input 7 8 0 1 10 1 2 10 2 3 10 0 3 10 3 4 10 4 5 10 5 6 10 4 6 10 2
 * Sample Output 2@2 1@21 3@23 0@210 4@234 5@2345 6@2346
 * 
 */