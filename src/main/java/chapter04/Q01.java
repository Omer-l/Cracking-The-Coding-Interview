package chapter04;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 * Hints:#127
 * <p>
 * My Approach 1
 * Beginning with the source index, recursively iterate to it's children and then go down a level to the next
 * node's chi
 */
public class Q01 {

    private enum State {
        Unvisited, Visited, Visiting
    }

    private static class BFSNode {
        State state = State.Unvisited;
        int[] neighbours;

        public BFSNode(int[] neighbours) {
            this.neighbours = neighbours;
        }
    }

    private final BFSNode[] directedGraph;

    public Q01(int[][] directedGraph) {
        this.directedGraph = new BFSNode[directedGraph.length];

        for(int nodeIndex = 0; nodeIndex < directedGraph.length; nodeIndex++)
            this.directedGraph[nodeIndex] = new BFSNode(directedGraph[nodeIndex]);

    }

    /**
     * Searches for all the possible routes to get to the desired index.
     *
     * @param src  index to search route from
     * @param dest index to search for
     * @return true if there exists a path to the given index
     */
    public boolean existsRoute(int src, int dest) {
        LinkedList<BFSNode> queue = new LinkedList<>();

        directedGraph[src].state = State.Visiting; //current node is being visited

        queue.add(directedGraph[src]); // begin the search

        while(!queue.isEmpty()) {
            BFSNode visitingNode = queue.remove();

            if(visitingNode != null) {
                int[] neighboursIndexes = visitingNode.neighbours;
                System.out.println(Arrays.toString(neighboursIndexes));
                for(int neighbourIndex : neighboursIndexes) {
                    BFSNode neighbour = directedGraph[neighbourIndex];
                    if(neighbour.state == State.Unvisited) {
                        if(neighbourIndex == dest) {
                            return true;
                        } else {
                            neighbour.state = State.Visiting;
                            queue.add(neighbour);
                        }
                    }
                }
            }

            visitingNode.state = State.Visited;
        }

        return false;
    }
}
