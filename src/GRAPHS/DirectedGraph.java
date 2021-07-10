package GRAPHS;

import java.util.ArrayList;

public class DirectedGraph {

    public static class directedEdge {
        public int nbr;
        public int wt;

        public directedEdge(int nbr, int wt) {
            this.nbr = nbr;
            this.wt = wt;

        }
    }

        //Using ArrayList of ArrayList
        public static ArrayList<ArrayList<directedEdge>> createDirectedGraph(int tVertices)
        {
            ArrayList<ArrayList<directedEdge>> graph=new ArrayList<>();

            for(int i=0;i<tVertices;i++)
            {
                graph.add(i,new ArrayList<>());
            }
            return graph;
        }

        public static void uniAddEdge(ArrayList<ArrayList<directedEdge>>graph,int src,int nbr,int wt)
        {
            graph.get(src).add(new directedEdge(nbr,wt));
        }

        public static void printGraph(ArrayList<ArrayList<directedEdge>>graph)
        {
            for(int i=0;i<graph.size();i++)
            {
                System.out.print(i + "->");
                for(directedEdge e:graph.get(i))
                {
                    System.out.print(e.nbr + " @ " +e.wt + " -> ");
                }
                System.out.println();
            }
        }

}
