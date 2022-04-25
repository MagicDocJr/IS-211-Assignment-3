
import java.util.ArrayList;

public class Vertex {

    private final String data;
    private final ArrayList<Edge> edges;

    public Vertex(String inputData) {
        this.data = inputData;
        this.edges = new ArrayList<>();
    }

    public String getData() {
        return this.data;
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public void addEdge(Vertex v, int weight) {
        this.edges.add(new Edge(this, v, weight));
    }
}

