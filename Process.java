import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Process {
    private String readFile;
    private String writeFile;
    // private Graph graph = new Graph();
    private TreeMap<String, Vertex> graph = new TreeMap<>();


    public Process (String [] args){
        this.readFile = args[0];
        this.writeFile = args[1];
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
            this.graph.put(line[0],null);
            System.out.println(graph);
        }

        while(myReader.hasNextLine()){// read edges
            String data = myReader.nextLine();
            String [] line = data.split("\\s+");
            if(line[0].equals("---") ){
                break;
            }
            String streetName = line[0];
            String originVertice = line[2];
            String endVertice = line[3];
            int cost = Integer.parseInt(line[4]);
            // System.out.println("edge " + originVertice + " " + endVertice + " " + cost);
            Edge edge = new Edge(streetName, originVertice, endVertice, cost);
            TreeMap<String, Edge> edges; 
            Vertex vertex = this.graph.get(originVertice);
            // vertex.add(edge);
            System.out.println(graph);

        }

        myReader.close();
        
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    }
}
