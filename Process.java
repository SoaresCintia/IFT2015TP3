import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;











public class Process {
    private String readFile;
    private String writeFile;
    
  
    private PriorityQueue<Graph.Vertex> queue = new PriorityQueue<Graph.Vertex>();


    private Graph graph;


    public Process (String [] args){
        this.readFile = args[0];
        this.writeFile = args[1];
        this.graph = new Graph();
    }


    public void compute() { // O(|V|) + O(|E| log |V|) 
        processDataFile();  // O(|V|) + 0(|E|)
        Mst(); //O(|E| log |V|)
        writeResult(); //O(V)
    }

    private void Mst() {
        for(Graph.Vertex v: this.graph.getVertices()){
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


    private void processDataFile() { // O(|V|) + 0(|E|)
    try {
        File myObj = new File(this.readFile);
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()){// read vertices O(V)
            String data = myReader.nextLine();
            String [] line = data.split("\\s+");
            if(line[0].equals("---") ){
                break;
            }
            // this.graph.put(line[0],new TreeMap<>());
            this.graph.addVertex(line[0]);
            // System.out.println(graph);
        }
        while(myReader.hasNextLine()){// read edges O(|E|)
            String data = myReader.nextLine();
            String [] line = data.split("\\s+");
            if(line[0].equals("---") ){
                break;
            }
            Graph.Vertex startVertex = this.graph.new Vertex(line[2]);
            Graph.Vertex endVertex = this.graph.new Vertex(line[3]);
            int indexStart = this.graph.getVertices().indexOf(startVertex); // getting the vertex from the list of vertices contained in the class graph
            int indexEnd = this.graph.getVertices().indexOf(endVertex); // getting the vertex from the list
            if(indexStart >= 0 && indexEnd >= 0){ // checking if the vertex was in the list or not.
                Graph.Vertex firstVertex = this.graph.getVertices().get(indexStart); 
                Graph.Vertex lastVertex = this.graph.getVertices().get(indexEnd);            
                graph.addEdge(line[0],firstVertex,lastVertex, Integer.parseInt(line[4].replace(";",""))); // adding the edge of the given vertex
            }
            else{ // if not we add it in the list of vertexs 
                this.graph.addVertex(line[2]);
            }
                
                     

        }

        myReader.close();
        
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    }

    public void writeResult(){ // O(|V|)
        int sum = 0;
        for(Graph.Vertex v : this.graph.getVertices()){ // O(|V|)

                try {
                FileWriter myWriter = new FileWriter(writeFile,true);
                myWriter.write(v.getName() + "\n");
                myWriter.close();
                } 
                catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            
                
        }
        for(Graph.Vertex v : this.graph.getVertices()){ //O(|V|)
            if(v.getMinEdge() != null){
                Graph.Edge edge = v.getMinEdge();

                try {
                FileWriter myWriter = new FileWriter(writeFile,true);
                sum += edge.getWeight();
                myWriter.write(edge.getName() + "\t" + edge.getStartVertex().getName() + "\t" + edge.getTargetVertex().getName()+ "\t" + edge.getWeight() + "\n");
                myWriter.close();
                } 
                catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
                
        }


        try {
        FileWriter myWriter = new FileWriter(writeFile,true);
        myWriter.write("---"+ "\n" + sum);
        myWriter.close();
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

       
}

    

