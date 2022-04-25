import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.PriorityQueue;


public class Dijkstra {
    public static Dictionary[] dijkstra(Graph g, Vertex startingVertex) {
        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertex> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<>();

        queue.add(new QueueObject(startingVertex, 0));

        for (Vertex vertex : g.getVertices()) {
            if (vertex != startingVertex) {
                distances.put(vertex.getData(), Integer.MAX_VALUE);
            }
            previous.put(vertex.getData(), new Vertex("Null"));
        }

        distances.put(startingVertex.getData(), 0);

        while (queue.size() != 0) {
            Vertex current = queue.poll().vertex;
            for (Edge edge : current.getEdges()) {
                Integer alternate = distances.get(current.getData()) + edge.getWeight();
                String neighborValue = edge.getEnd().getData();
                if (alternate < distances.get(neighborValue)) {
                    distances.put(neighborValue, alternate);
                    previous.put(neighborValue, current);
                    queue.add(new QueueObject(edge.getEnd(), distances.get(neighborValue)));
                }
            }
        }

        return new Dictionary[]{distances, previous};
    }

    public static void shortestPathBetween(Graph g, Vertex startingVertex, Vertex targetVertex) {
        Dictionary[] dijkstraDictionaries = dijkstra(g, startingVertex);
        Dictionary distances = dijkstraDictionaries[0];
        Dictionary previous = dijkstraDictionaries[1];
        Integer cost = (Integer) distances.get(targetVertex.getData());

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex vertex = targetVertex;
        while (vertex.getData() != "Null") {
            path.add(0, vertex);
            vertex = (Vertex) previous.get(vertex.getData());
        }
        StringBuilder shortestPath = new StringBuilder();
        for (Vertex pathVertex : path) {
            shortestPath.append(pathVertex.getData());
        }

        System.out.println("Shortest Path between " + startingVertex.getData() + " and " + targetVertex.getData());
        System.out.println("Path: " + "[" + shortestPath + "] " + "Cost: " + cost);
    }


    public static void main(String[] args) {
        Graph network = new Graph(true, false);
        Vertex a = network.addVertex("A");
        Vertex b = network.addVertex("B");
        Vertex c = network.addVertex("C");
        Vertex d = network.addVertex("D");
        Vertex e = network.addVertex("E");
        Vertex f = network.addVertex("F");

        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);

        network.addEdge(a, b, 10);
        network.addEdge(a, c, 5);
        network.addEdge(a, e, 3);
        network.addEdge(a, f, 12);
        network.addEdge(b, c, 17);
        network.addEdge(b, d, 9);
        network.addEdge(b, e, 17);
        network.addEdge(b, f, 12);
        network.addEdge(c, d, 35);
        network.addEdge(c, e, 3);
        network.addEdge(c, f, 12);
        network.addEdge(d, f, 12);
        network.addEdge(e, f, 12);

        for (Vertex startingVertex : vertices) {
            for (Vertex endVertex : network.getVertices()) {
                shortestPathBetween(network, startingVertex, endVertex);
                System.out.println(" ");
            }
        }
    }
}