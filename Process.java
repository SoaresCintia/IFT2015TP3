import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        doPrimJarnik();
    }

    private void doPrimJarnik() {
        int [] dist = new int [graph.size()];
        for (int i : dist) {
            dist[i] =  Integer.MAX_VALUE; 
        }
        Graph.Vertex v = pickRandomVertex(this.graph.getVerticesEdges());
        int vIndex = graph.getVerticesEdges().indexOf(v);
        dist[vIndex] = 0;
        PriorityQueue<Graph.Edge> queue = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            
        }
        // String v = graph.firstKey();
        // System.out.println(graph.firstKey());
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
}
