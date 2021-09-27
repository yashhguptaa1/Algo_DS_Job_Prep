package GRAPHS.UnionFind.L684_RedundantConnection;

import java.io.*;
import java.util.*;

public class redundantConnection {

    public static int[] findRedundantConnection(int N, int[][] edges) {

        //In Ques:given a graph that started as a tree with n nodes labeled from 1 to n
        par = new int[N];
        Arrays.fill(par, -1);

        for (int[] edge : edges) {
            int p1 = findPar(edge[0]);
            int p2 = findPar(edge[1]);

            //we dont use merge function here as we have to only find cycle here
            //we dont have to create a new spanning tree or optimize union
            if (p1 == p2)
                par[p1] = p2;

            else
                return edge;


            //Only one extra edge present according to ques
                //Return an edge that can be removed so that the resulting graph is a tree of n nodes.
                return edge;

        }
        return new int[0];
    }
    static int[] par;

    public static int findPar(int u) {
        return par[u] == -1 ? u : (par[u] = findPar(par[u]));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader inp =new BufferedReader(new InputStreamReader(System.in));

        int tVertices= Integer.parseInt(inp.readLine().trim());
        int edges [][]=new int[5][2];

        for(int i=0;i<tVertices;i++)
        {
            String s[]=inp.readLine().trim().split(" ");
            edges[i][0]=Integer.parseInt(s[0]);
            edges[i][1]=Integer.parseInt(s[1]);
        }

        int res[]=findRedundantConnection(edges.length,edges);

        System.out.println("[" +res[0]+","+res[1]+"]");
    }
}
/*
Sample Input
5
1 2
2 3
3 4
1 4
1 5
Sample Output
[1,4]
 */
