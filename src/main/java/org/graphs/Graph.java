package org.graphs;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    int size;
     LinkedList<Integer>[] adjList;

    public Graph(int size){
        this.adjList = new LinkedList[size];
        for (int i = 0;i<size ; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public boolean addEdge(int start, int end, boolean multiPart){

        this.adjList[start].add(end);
        if(multiPart){
            adjList[end].add(start);
        }
        return true;
    }

    public boolean hasEulerianCycle(LinkedList<Integer>[] adjList){

        int odd = 0;
        for(int i=0;i<adjList.length;i++){
            if((adjList[i].size() % 2) == 1){
                odd ++;
            }
        }
        return odd == 0 || odd == 2;
    }


    public static void main(String[] args){

        Graph graph = new Graph(6);
                graph.addEdge(0,1,true);
                graph.addEdge(0,3,true);

                graph.addEdge(1,0,true);
                graph.addEdge(1,2,true);
                graph.addEdge(1,3,true);
                graph.addEdge(1,4,true);

                graph.addEdge(2,1,true);
                graph.addEdge(2,3,true);
                graph.addEdge(2,4,true);
                graph.addEdge(2,5,true);


                graph.addEdge(3,1,true);
                graph.addEdge(3,2,true);
                graph.addEdge(3,4,true);
                graph.addEdge(3,5,true);

                graph.addEdge(4,1,true);
                graph.addEdge(4,2,true);
                graph.addEdge(4,3,true);
                graph.addEdge(4,5,true);

                graph.addEdge(5,2,true);
                graph.addEdge(5,4,true);

            boolean hadEulerian = graph.hasEulerianCycle(graph.adjList);

        System.out.println("Graph has eulerian cycle :: "+hadEulerian);

    }


}
