package org.graphs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTraversalTest {

    @Test
    void hasComponents() {

        GraphTraversal gt = new GraphTraversal();

        int[][] input = new int[][]{
                {0,1},{0,3},
                {1,0},{1,2},{1,3},{1,4},
                {2,1},{2,3},{2,4},
                {3,0},{3,1},{3,2},{3,4},
                {4,1},{4,2},{4,3},
                {5,6},
                {6,5}
        };

        Graph graph = new Graph(7);
        graph.construct(input,true);

        assertEquals(1, gt.hasComponents(graph.adjList));

    }

    @Test
    void hasEulerian() {

        GraphTraversal gt = new GraphTraversal();

        int[][] input = new int[][]{
                {0,1},{0,3},
                {1,0},{1,2},{1,3},{1,4},
                {2,1},{2,3},{2,4},
                {3,0},{3,1},{3,2},{3,4},
                {4,1},{4,2},{4,3},
                {5,6},
                {6,5}
        };

        Graph graph = new Graph(7);
        graph.construct(input,true);

        assertTrue(gt.hasEulerianCycle(graph.adjList));

    }

    @Test
    void hasComponents1() {

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

        assertEquals(0, gt.hasComponents(graph.adjList));

    }

    @Test
    void hasComponents2() {

        GraphTraversal gt = new GraphTraversal();

        int[][] input = new int[][]{
                {0,1},{1,2},{3,4}
        };

        Graph graph = new Graph(5);
        graph.construct(input,true);

        assertEquals(1, gt.hasComponents(graph.adjList));

    }

    @Test
    void isValidTree() {

        GraphTraversal gt = new GraphTraversal();

        int[][] input = new int[][]{
                {0,1},{1,2}
        };

        Graph graph = new Graph(3);
        graph.construct(input,true);

        assertTrue(gt.isValidTree_bfs_approach(0, graph.adjList));

    }
    @Test
    void isValidTree1() {

        GraphTraversal gt = new GraphTraversal();

        int[][] input = new int[][]{
                {0,1},
                {0,2},
                {1,2}
        };

        Graph graph = new Graph(3);
        graph.construct(input,true);

        assertFalse(gt.isValidTree_bfs_approach(0, graph.adjList));

    }

    @Test
    void isValidTree2() {

        GraphTraversal gt = new GraphTraversal();

        int[][] input = new int[][]{
                {0,1},
                {0,2}
        };

        Graph graph = new Graph(3);
        graph.construct(input,true);

        assertTrue(gt.isValidTree_dfs_stack_approach(0, graph.adjList));

    }

    @Test
    void isValidTree3() {

        GraphTraversal gt = new GraphTraversal();

        int[][] input = new int[][]{
                {0,1},
                {0,2},
                {1,2}
        };

        Graph graph = new Graph(3);
        graph.construct(input,true);

        assertFalse(gt.isValidTree_dfs_stack_approach(0, graph.adjList));

    }

    @Test
    void isValidTree4() {

        GraphTraversal gt = new GraphTraversal();

        int[][] input = new int[][]{
                {0,1},
                {0,2},
                {1,2}
        };

        Graph graph = new Graph(3);
        graph.construct(input,true);

        assertTrue(gt.isValidTree_recursion_approach(0, graph.adjList));

    }

    @Test
    void isValidTree5() {

        GraphTraversal gt = new GraphTraversal();

        int[][] input = new int[][]{
                {0,1},
                {0,2}
        };

        Graph graph = new Graph(3);
        graph.construct(input,true);

        assertFalse(gt.isValidTree_recursion_approach(0, graph.adjList));

    }

}