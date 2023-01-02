package org.graphs;

import java.util.LinkedList;

public class Graph {

    LinkedList<Integer>[] adjList;

    public Graph(int size){
        this.adjList = new LinkedList[size];
        for (int i = 0;i<size ; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void construct(int[][] input,boolean multipart){

        for (int[] ints : input) {

            int start = ints[0];
            int end = ints[1];

               adjList[start].add(end);

            if (multipart) {
                adjList[end].add(start);
            }
        }
    }

}