import java.io.File;
import java.io.FileNotFoundException;
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
        // int [] dist = new int [graph.size()];
        // for (int i : dist) {
        //     dist[i] = 1000; // + infiny ?
        // }
        // // TreeMap<String, Edge> v = graph.get(graph.firstKey());
        // String v = graph.firstKey();
        // System.out.println(graph.firstKey());
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

            this.graph.addVertex(line[0]);
            System.out.println(graph);

            // this.graph.put(line[0],new TreeMap<>());
            // this.graph.addVertex(line[0]);
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
            int indexStart = this.graph.getVertexsEdges().indexOf(startVertex); // getting the vertex from the list of vertexs contained in the class graph
            int indexEnd = this.graph.getVertexsEdges().indexOf(endVertex); // getting the vertex from the list
            if(indexStart >= 0 && indexEnd >= 0){ // checking if the vertex was in the list or not.
                Graph.Vertex firstVertex = this.graph.getVertexsEdges().get(indexStart); 
                Graph.Vertex lastVertex = this.graph.getVertexsEdges().get(indexEnd);            
                firstVertex.addEdge(line[0],firstVertex,lastVertex, Integer.parseInt(line[4])); // adding the edge of the given vertex
            }
            else{ // if not we add it in the list of vertexs 
                this.graph.addVertex(line[2]);
            }
                
                     
            // EdgeOld edge = new EdgeOld(line[0], line[2], line[3], Integer.parseInt(line[4]));
            String name = line[0];
            String firstV = line[2];
            String secondV = line[3];
            int value = Integer.parseInt(line[4]); 

            // first vertex
            // int indexFirst = this.graph.getIndex(firstV);
            // System.out.println(indexFirst);
            this.graph.addEdge(name, firstV, secondV, value);
            // this.graph.get(edge.getStart()).put(edge.getEnd(), edge);

            // second vertex
            // this.graph.get(edge.getEnd()).put(edge.getStart(), edge);
            // System.out.println(graph); 
            // tes

        }

        myReader.close();
        
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    }
}
