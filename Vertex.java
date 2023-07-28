import java.util.TreeMap;

class Vertex {

    TreeMap<String, Edge> edges;

    public void add(Edge edge) {
        this.edges.put(edge.getStart(), edge);
    } 

}

