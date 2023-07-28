import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Process {
    private String readFile;
    private String writeFile;
    // private Graph graph = new Graph();
    // private TreeMap<String, Vertex> graph = new TreeMap<>();
    private TreeMap<String, TreeMap<String, Edge>> graph;

    public Process (String [] args){
        this.readFile = args[0];
        this.writeFile = args[1];
        this.graph = new TreeMap<>();
    }

    public void compute() {
        processDataFile();
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
            this.graph.put(line[0],new TreeMap<>());
            System.out.println(graph);
        }

        while(myReader.hasNextLine()){// read edges
            String data = myReader.nextLine();
            String [] line = data.split("\\s+");
            if(line[0].equals("---") ){
                break;
            }
            
            Edge edge = new Edge(line[0], line[2], line[3], Integer.parseInt(line[4]));

            // first vertex
            this.graph.get(edge.getStart()).put(edge.getEnd(), edge);

            // second vertex
            this.graph.get(edge.getEnd()).put(edge.getStart(), edge);
            // System.out.println(graph);

        }

        myReader.close();
        
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    }
}
