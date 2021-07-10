package GRAPHS.TopologicalSort.L210_CourseSchedule2;

import java.util.*;
public class OrderOfWork {


    public ArrayList<Integer> kahnsAlgo(ArrayList<ArrayList<Integer>>graph)
    {
        int N = graph.size();
        int indegree[]=new int[N];

        //For each src Vertex store the number of its neighbors
        //that is store the number of nodes dependent on src vertex
        for (int i = 0; i < N; i++)
            for (int e : graph.get(i))
                indegree[e]++;

        Queue<Integer> que=new LinkedList<>();
        ArrayList<Integer>ans=new ArrayList<>();

        //First store all vertices jiske upr aur koi vertices dependent nhi he
        for (int i = 0; i < N; i++)
            if (indegree[i] == 0)
                que.add(i);

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
                for (int e : graph.get(rvtx))
                {
                    if (--indegree[e] == 0)
                        que.add(e);
                }
            }
        }

        return ans;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {


        ArrayList<ArrayList<Integer>> graph=new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            graph.add(i,new ArrayList<>());
        }

        for (int arr []: prerequisites)
        {
            graph.get(arr[0]).add(arr[1]);
        }

        //if there is cycle in graph
        //then SIZE of arraylist returned from topological sort
        // will not be equal to numOfVertices : numCourses
        //if there is cycle we wont be able to follow courseSchedule
        ArrayList<Integer> temp= kahnsAlgo(graph);

        int n = temp.size();

        if(n != numCourses)
        {
            return new int[]{};
        }

        int res[]=new int[n];

        for(int i=0,j=n-1;i<n;i++,j--)
        {
            res[i]=temp.get(j);
        }

        return res;
    }
}
