import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;









public class Process {
    private String readFile;
    private String writeFile;
    
    // private TreeMap<String, TreeMap<String, Edge>> graph;
    // private TreeMap<String, TreeMap<String, Edge>> treeMin;

    private TreeSet<Graph.Vertex> vertices;
    private PriorityQueue<Graph.Vertex> queue;


    private Graph graph;
    private Graph treeMin;


    public Process (String [] args){
        this.readFile = args[0];
        this.writeFile = args[1];
        // this.graph = new TreeMap<>();
        // this.treeMin = new TreeMap<>();

        this.graph = new Graph();
        this.treeMin = new Graph();
    }

    public void compute() {
        processDataFile();
        Mst();
    }

    private void Mst() {
        for(Graph.Vertex v: this.graph.getVerticesEdges()){
            if(!v.isVisited()){
                primJarnik(v);
                
            }
        }
       
    }

    private void  primJarnik(Graph.Vertex  v){
        v.setMinDistance(0);
        queue.add(v);
        while(!queue.isEmpty()){
            Graph.Vertex v2 = queue.remove();
            checkVertex(v2);
        }

    }

    private void checkVertex(Graph.Vertex v){
        v.setVisited(true);
        for(Graph.Edge edge : v.getAdjacentEdges()){
            Graph.Vertex w = edge.getTargetVertex();
            if(w.isVisited()){
                continue;
            }
            if(edge.getWeight() < w.getMinDistance()){
                w.setMinDistance(edge.getWeight());
                w.setMinEdge(edge);
                if(this.queue.contains(w)){
                    this.queue.remove(w);
                }
                this.queue.add(w);
            }
        }
    }

    private Graph.Vertex pickRandomVertex(ArrayList<Graph.Vertex> vertices) {
        Random rand  = new Random();
        int index = rand.nextInt(vertices.size());
        return vertices.get(index);
    }

    private void processDataFile() {
    try {
        File myObj = new File(this.readFile);
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()){// read vertices
            String data = myReader.nextLine();
            String [] line = data.split("\\s+");
            if(line[0].equals("---") ){
                break;
            }
            // this.graph.put(line[0],new TreeMap<>());
            this.graph.addVertex(line[0]);
            // System.out.println(graph);
        }

        while(myReader.hasNextLine()){// read edges
            String data = myReader.nextLine();
            String [] line = data.split("\\s+");
            if(line[0].equals("---") ){
                break;
            }
            Graph.Vertex startVertex = this.graph.new Vertex(line[2],new TreeSet<Graph.Edge>());
            Graph.Vertex endVertex = this.graph.new Vertex(line[3], null);
            int indexStart = this.graph.getVerticesEdges().indexOf(startVertex); // getting the vertex from the list of vertices contained in the class graph
            int indexEnd = this.graph.getVerticesEdges().indexOf(endVertex); // getting the vertex from the list
            if(indexStart >= 0 && indexEnd >= 0){ // checking if the vertex was in the list or not.
                Graph.Vertex firstVertex = this.graph.getVerticesEdges().get(indexStart); 
                Graph.Vertex lastVertex = this.graph.getVerticesEdges().get(indexEnd);            
                firstVertex.addEdge(line[0],firstVertex,lastVertex, Integer.parseInt(line[4])); // adding the edge of the given vertex
            }
            else{ // if not we add it in the list of vertexs 
                this.graph.addVertex(line[2]);
            }
                
                     
            // EdgeOld edge = new EdgeOld(line[0], line[2], line[3], Integer.parseInt(line[4]));

            // first vertex
            // this.graph.get(edge.getStart()).put(edge.getEnd(), edge);

            // second vertex
            // this.graph.get(edge.getEnd()).put(edge.getStart(), edge);
            // System.out.println(graph);

        }

        myReader.close();
        
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    }

    class pair{
        int weight;
        int vertex;

        pair(int weight, int vertex){
            this.weight = weight;
            this.vertex = vertex;
        }
    }
}
