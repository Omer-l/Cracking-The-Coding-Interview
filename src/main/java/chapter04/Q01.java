package chapter04;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 * Hints:#127
 * <p>
 * My Approach 0
 * Given indexes of each node, using an adjacency list approach, the adj list is an integer array.
 * Recursively go down the directed graph in a breadth first search order.
 * Once at the deepest level, stop the search.
 */
public class Q01 {
    int[][] directedGraph;

    public Q01(int[][] directedGraph) {
        this.directedGraph = directedGraph;
    }

    /**
     * Searches for all the possible routes to get to the desired index.
     *
     * @param src  index to search route from
     * @param dest index to search for
     * @return true if there exists a path to the given index
     */
    public boolean existsRoute(int src, int dest) {

        if(src >= directedGraph.length) //ensures breadth first search is stopped when all nodes are visited.
            return false;

        System.out.print("\n" + src + "... NODE: ");
        //traverse to all the indexes from src
        for (int nodeNumber = 0; nodeNumber < directedGraph[src].length; nodeNumber++) {
            int node = directedGraph[src][nodeNumber];
            System.out.print(" " + node);
            if (node == dest)
                return true;
        }

        //Keep searching recursively
        return existsRoute(src + 1, dest);
    }
}
