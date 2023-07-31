import java.util.ArrayList;


public class Graph {


   

    private ArrayList<Vertex> vertices = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();

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
        ArrayList<Edge> adjacentEdges;
        
        public Vertex(String v) {
            this.name = v;
            this.adjacentEdges = new ArrayList<>();
        }

        public void  addEdge(Edge e ){
            this.adjacentEdges.add(e);
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

        public void setAdjacentEdges(ArrayList<Graph.Edge> adjacentEdges) {
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

        public ArrayList<Graph.Edge> getAdjacentEdges() {
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
        Vertex vertex = new Vertex(v);
        this.vertices.add(vertex);
    }


    public void addEdge(String name, Vertex first, Vertex second, int value ){

        Edge edge = new Edge(name, first, second, value);
        Vertex startV = edge.getStartVertex();
        Vertex TargetV = edge.getTargetVertex();

        this.vertices.get(this.vertices.indexOf(startV)).addEdge(new Edge(name, startV, TargetV, value));
        this.vertices.get(this.vertices.indexOf(TargetV)).addEdge(new Edge(name, TargetV, startV, value));

    }

   public ArrayList<Edge>  getEdges(){
        return this.edges;
   }
   public int size(){
       return this.vertices.size();
   }

   public ArrayList<Graph.Vertex> getVertices(){
        return this.vertices;

   }

        
}
