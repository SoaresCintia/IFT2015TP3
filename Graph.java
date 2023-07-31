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

    class Edge implements Comparable<Edge> {
        
        String name;
        Vertex startVertex;        
        Vertex targetVertex;
        int weight;

        public Edge(String name, Vertex startVertex, Vertex targVertex, int weight) {
            this.name = name;
            this.startVertex = startVertex;
            this.targetVertex = targVertex;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public Vertex getStartVertex() {
            return startVertex;
        }

        public Vertex getTargetVertex() {
            return targetVertex;
        }

        public int getWeight() {
            return weight;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setStartVertex(Vertex startVertex) {
            this.startVertex = startVertex;
        }

        public void setTargetVertex(Vertex targetVertex) {
            this.targetVertex = targetVertex;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.getWeight());
           
        }

        
    };
    
    class Vertex implements Comparable<Vertex>{

        String name; // optionnel
        Edge minEdge;
        boolean visited;
        Vertex prevVertex;
        double minDistance = Double.POSITIVE_INFINITY;
        TreeSet<Edge> adjacentEdges;
        
        public Vertex(String v, TreeSet<Edge> adjacentEdges) {
            this.name = v;
            this.adjacentEdges = adjacentEdges;
        }

        public void  addEdge(String name,Vertex start, Vertex end, Integer weight){
            if(adjacentEdges == null){
                adjacentEdges = new TreeSet<Edge>();
            }
            adjacentEdges.add(new Edge(name,start,end,weight));
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

            return this.name.equals(ver.getName());
            
        }

        @Override
        public int compareTo(Graph.Vertex o) {
            return Double.compare(minDistance, o.getMinDistance());
        }

        public double getMinDistance() {
            return  this.minDistance;
        }

        public void setAdjacentEdges(TreeSet<Edge> adjacentEdges) {
            this.adjacentEdges = adjacentEdges;
        }

        public void setMinDistance(double minDistance) {
            this.minDistance = minDistance;
        }

        public void setMinEdge(Edge minEdge) {
            this.minEdge = minEdge;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrevVertex(Vertex prevVertex) {
            this.prevVertex = prevVertex;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public TreeSet<Edge> getAdjacentEdges() {
            return adjacentEdges;
        }

        public Edge getMinEdge() {
            return minEdge;
        }

        public String getName() {
            return name;
        }

        public Vertex getPrevVertex() {
            return prevVertex;
        }

        public boolean isVisited() {
            return visited;

        }
        
    }

   
    

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
