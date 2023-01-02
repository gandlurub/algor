package org.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {


    int[] visited;
    public boolean hasEulerianCycle(LinkedList<Integer>[] adjList){

        int odd = 0;
        for (LinkedList<Integer> integers : adjList) {
            if ((integers.size() % 2) == 1) {
                odd++;
            }
        }
        return odd == 0 || odd == 2;
    }

    public int hasComponents(LinkedList<Integer>[] adjList){
        this.visited = new int[adjList.length];

            bfs(0,adjList);

            /* Code to find out components based on visited */
            int count = 0;
            for(int i=0;i<visited.length;i++){
                if(visited[i] == 0){
                    bfs(i,adjList);
                    count++;
                }
            }

        return count;
    }


    public void bfs(int source,LinkedList<Integer>[] adjList){

        Queue<Integer> queue = new LinkedList<>();
                        queue.add(source);
                        visited[source] = 1;

             while(!queue.isEmpty()){
                 int current = queue.poll();
                 for(int j=0;j<adjList[current].size();j++){
                     int vertex = adjList[current].get(j);
                     if(visited[vertex] == 0){
                         queue.add(vertex);
                         visited[vertex] = 1;
                     }
                 }
             }
    }



    public static void main(String[] args){

        GraphTraversal gt = new GraphTraversal();

        int[][] input = new int[][]{
                {0,1},{0,3},
                {1,0},{1,2},{1,3},{1,4},
                {2,1},{2,3},{2,4},{2,5},
                {3,0},{3,1},{3,2},{3,4},
                {4,1},{4,2},{4,3},{4,5},
                {5,2},{5,4}
        };

        Graph graph = new Graph(6);
                graph.construct(input,true);

        gt.hasComponents(graph.adjList);
        System.out.println("is Eulerian cycle :: "+gt.hasEulerianCycle(graph.adjList));


    }


}
