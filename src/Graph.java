

import java.util.ArrayList;

public class Graph {
    private final ArrayList<Vertex> vertices;
    private final boolean isDirected;
    private final boolean isWeighted;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
        this.vertices = new ArrayList<>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public ArrayList<Vertex> getVertices(){
        return this.vertices;
    }

    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }



    public void addEdge(Vertex v1, Vertex v2, int weight) {
        if (!isWeighted) {
            weight = 0;
        }
        v1.addEdge(v2, weight);
        if(!this.isDirected) {
            v2.addEdge(v1, weight);
        }
    }
}