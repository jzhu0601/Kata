package graph;

import java.util.List;

/**
 * Created by Jason on 12/21/15.
 */
public class GraphAdjMatrix extends Graph{

    private int[][] adjMatrix;

    @Override
    public void implementAddVertex(int v, int w) {
        adjMatrix[v][w] = 1;
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        return null;
    }
}
