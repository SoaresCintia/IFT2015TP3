import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Graph {

     private int curIndex = 0;
    // // clé – sommet, valeur – indice de sommet 
     private TreeMap<String, Integer> indexes;
    // private ArrayList<Vertex> vertexs;

    private TreeSet<String> vertexTree = new TreeSet<>();
    private ArrayList<Vertex> verticesEdges = new ArrayList<Vertex>();

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
        String v; // optionnel
        // e(v,w) sortante. s = v
        // clé – indice de w dans une table des sommets // valeur – poids de e sortante
        // Exemple: (1,7) = 1 => b; e = (a,b) poids 7 
        TreeSet<Edge> edges;
        // TreeMap aretesEntrantes; //optionel
        public Vertex(String v, TreeSet<Edge> edges) {
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

   
    
    // public void addVertex(String s) {

    //     this.indexes.put(s, curIndex);
        
    //     Vertex vertex = new Vertex(s, new TreeMap<>());
    //     this.vertexs.add(vertex);

    //     curIndex++;

    // }
    public void addVertex(String v){
        this.vertexTree.add(v);
        Vertex vertex = new Vertex(v,new TreeSet<>());
        this.verticesEdges.add(vertex);
    }


    public void addEdge(String name, Vertex first, Vertex second, int value ){
        Edge edge = new Edge(name, first, second, value);
        // this.vertexs.g
    }

   public ArrayList<Vertex>  getVerticesEdges(){
        return this.verticesEdges;
   }
   public int size(){
       return this.vertexTree.size();
   }

   public TreeSet<String> getVertexTree(){
        return this.vertexTree;

   }

        
}
