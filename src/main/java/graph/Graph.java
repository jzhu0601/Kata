package graph;

import java.util.List;

/**
 * Created by Jason on 12/21/15.
 */
public abstract class Graph {

    private int numVertices;

    private int numEdges;

    public Graph() {
        numEdges = 0;
        numVertices = 0;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void setNumEdges(int numEdges) {
        this.numEdges = numEdges;
    }


    public abstract void implementAddVertex(int x, int y);

    public abstract List<Integer> getNeighbors(int v);

}
