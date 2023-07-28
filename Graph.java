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
        String v; // optionnel
        // e(v,w) sortante. s = v
        // clé – indice de w dans une table des sommets // valeur – poids de e sortante
        // Exemple: (1,7) = 1 => b; e = (a,b) poids 7 
        TreeMap<String, Edge> edges;
        // TreeMap aretesEntrantes; //optionel
        public Vertex(String v, TreeMap<String, Edge> edges) {
            this.v = v;
            this.edges = edges;
        }
    };

    private int curIndex = 0;
    //clé – sommet, valeur – indice de sommet 
    private TreeMap<String, Integer> indexes;
    private ArrayList<Vertex> vertexs;
    
    public void addVertex(String s) {

        this.indexes.put(s, curIndex);
        
        Vertex vertex = new Vertex(s, new TreeMap<>());
        this.vertexs.add(vertex);

        curIndex++;

    }

    public void addEdge(String name, String first, String second, int value ){
        Edge edge = new Edge(name, first, second, value);
        // this.vertexs.g
    }
        
}
