package org.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {


    int[] visited;
    int[] parent;
    LinkedList<Integer>[] adjList;
    public boolean hasEulerianCycle(LinkedList<Integer>[] adjList) {

        int odd = 0;
        for (LinkedList<Integer> integers : adjList) {
            if ((integers.size() % 2) == 1) {
                odd++;
            }
        }
        return odd == 0 || odd == 2;
    }

    public int hasComponents(LinkedList<Integer>[] adjList) {
        this.visited = new int[adjList.length];

        bfs(0, adjList);

        /* Code to find out components based on visited */
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                bfs(i, adjList);
                count++;
            }
        }

        return count;
    }


    public void bfs(int source, LinkedList<Integer>[] adjList) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int j = 0; j < adjList[current].size(); j++) {
                int vertex = adjList[current].get(j);
                if (visited[vertex] == 0) {
                    queue.add(vertex);
                    visited[vertex] = 1;
                }
            }
        }
    }

    public boolean isValidTree_bfs_approach(int source, LinkedList<Integer>[] adjList) {
        visited = new int[adjList.length];
        parent = new int[adjList.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = 1;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int j = 0; j < adjList[vertex].size(); j++) {
                int current = adjList[vertex].get(j);
                if (visited[current] == 0) {
                    queue.add(current);
                    visited[current] = 1;
                    parent[current] = vertex;
                } else {
                    if (parent[vertex] != current) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidTree_dfs_stack_approach(int source,LinkedList<Integer>[] adjList){
         visited = new int[adjList.length];
         parent = new int[adjList.length];

         Stack<Integer> stack = new Stack<>();
                        stack.add(source);
                        visited[source] = 1;

                while(!stack.isEmpty()) {
                   int vertex = stack.pop();
                   for(int i=0;i<adjList[vertex].size();i++){
                       int current = adjList[vertex].get(i);
                        if(visited[current] == 0) {
                            visited[current] = 1;
                            parent[current] = vertex;
                            stack.add(current);
                        } else if(parent[vertex] != current){
                            return false;
                        }
                   }
                }
        return true;
    }

    public boolean isValidTree_recursion_approach(int source,LinkedList<Integer>[] adjList){

        visited = new int[adjList.length];
        parent = new int[adjList.length];
         this.adjList = adjList;
        return isCycleDFS(source);
    }

    public boolean isCycleDFS(int source){

        visited[source] = 1;
        for (int i=0;i<adjList[source].size();i++){
              int currEdge = adjList[source].get(i);
            if(visited[currEdge] == 0){
                parent[currEdge] = source;
                if(isCycleDFS(currEdge)){
                    return true;
                }
             } else {
                if(parent[source] != currEdge){
                    return true;
                }
            }
        }

        return false;
    }

}
