import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Graph {

     private int curIndex = 0;
    // // clé – sommet, valeur – indice de sommet 
     private TreeMap<String, Integer> indexes;
    // private ArrayList<Vertex> vertexs;

    private TreeSet<String> vertexTree = new TreeSet<>();
    private ArrayList<Vertex> vertexsEdges = new ArrayList<Vertex>();

    class Edge{
        
        String name;
        Vertex first, second;
        int value;

        public Edge(String name, Vertex first, Vertex second, int value) {
            this.name = name;
            this.first = first;
            this.second = second;
            this.value = value;
        }
    };
    
    class Vertex{
<<<<<<< HEAD
        String v; 
        
        TreeMap<Integer, Edge> edges;

        public Vertex(String v, TreeMap<Integer, Edge> edges) {
=======
        String v; // optionnel
        // e(v,w) sortante. s = v
        // clé – indice de w dans une table des sommets // valeur – poids de e sortante
        // Exemple: (1,7) = 1 => b; e = (a,b) poids 7 
        TreeSet<Edge> edges;
        // TreeMap aretesEntrantes; //optionel
        public Vertex(String v, TreeSet<Edge> edges) {
>>>>>>> 3c219f5 (adding edges to the graph)
            this.v = v;
            this.edges = edges;
        }

        public void  addEdge(String name,Vertex start, Vertex end, Integer weight){
            if(edges == null){
                edges = new TreeSet<Edge>();
            }
            edges.add(new Edge(name,start,end,weight));
        }

        @Override
        public boolean equals(Object o) {
            if(this == o){
                return true;
            }
            if(!(o instanceof Vertex)){
                return false;
            }

            Vertex ver = (Vertex) o;

            return this.v == ver.v;
            
        }
    };

<<<<<<< HEAD
    private int curIndex = 0;
    private TreeMap<String, Integer> indexes = new TreeMap<>();
    private ArrayList<Vertex> vertexs;
=======
   
>>>>>>> 3c219f5 (adding edges to the graph)
    
    // public void addVertex(String s) {

<<<<<<< HEAD
        this.indexes.put(s, curIndex);

        curIndex++;
=======
    //     this.indexes.put(s, curIndex);
        
    //     Vertex vertex = new Vertex(s, new TreeMap<>());
    //     this.vertexs.add(vertex);

    //     curIndex++;

    // }
    public void addVertex(String v){
        this.vertexTree.add(v);
        Vertex vertex = new Vertex(v,new TreeSet<>());
        this.vertexsEdges.add(vertex);
>>>>>>> 3c219f5 (adding edges to the graph)
    }


    public void addEdge(String name, Vertex first, Vertex second, int value ){
        Edge edge = new Edge(name, first, second, value);
        int indexFirst = this.indexes.get(first);
        int indexSecond = this.indexes.get(second);

        // Vertex vertex = this.vertexs.get(indexFirst);

        // vertex.edges.put(indexSecond, edge);
    }

<<<<<<< HEAD
    // public int getIndex(String v){
    //     return this.indexes.get(v);
    // }
=======
   public ArrayList<Vertex>  getVertexsEdges(){
        return this.vertexsEdges;
   }
>>>>>>> 3c219f5 (adding edges to the graph)
        
}
