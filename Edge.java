public class Edge {

    private String name;
    private String start, end;
    private int cost;
    
    public Edge(String name, String start, String end, int cost) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
    
    public String getName(){
        return this.name;
    }

    public int getCost() {
        return cost;
    }

    public String getEnd() {
        return end;
    }

    public String getStart() {
        return start;
    }

    public String toString(){
        return name + " " + start + " " +  end + " " + cost;
    }
}
