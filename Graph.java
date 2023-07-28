import java.util.ArrayList;
import java.util.TreeMap;

public class Graph {

    class Edge{
        
        String name;
        String first, second;
        int value;

        public Edge(String name, String first, String second, int value) {
            this.name = name;
            this.first = first;
            this.second = second;
            this.value = value;
        }
    };
    
    class Vertex{
        String v; 
        
        TreeMap<Integer, Edge> edges;

        public Vertex(String v, TreeMap<Integer, Edge> edges) {
            this.v = v;
            this.edges = edges;
        }
    };

    private int curIndex = 0;
    private TreeMap<String, Integer> indexes = new TreeMap<>();
    private ArrayList<Vertex> vertexs;
    
    public void addVertex(String s) {

        this.indexes.put(s, curIndex);

        curIndex++;
    }

    public void addEdge(String name, String first, String second, int value ){
        Edge edge = new Edge(name, first, second, value);
        int indexFirst = this.indexes.get(first);
        int indexSecond = this.indexes.get(second);

        // Vertex vertex = this.vertexs.get(indexFirst);

        // vertex.edges.put(indexSecond, edge);
    }

    // public int getIndex(String v){
    //     return this.indexes.get(v);
    // }
        
}
