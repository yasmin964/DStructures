package DStructers_algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class week10 {
    public static void main(String[] args) {
        Graph<String, Integer> inno = new Graph<>();
        Graph<String, Integer>.Vertex A, B;
        A = inno.addV("123");
        B = inno.addV("345");
        inno.addE(A, B, 5);


    }
}
class Graph <V, E> {
    class Vertex {
        List<Vertex> adjacent;
        V value;
        int indegree;
        int outdegree;

        public Vertex(V value) {
            this.value = value;
        }
    }

    class Edge {
        Vertex from;
        Vertex to;
        E lable;

        public Edge(Vertex from, Vertex to, E lable) {
            this.from = from;
            this.to = to;
            this.lable = lable;
        }
    }
    List<Vertex> vertices;
    List<Edge> edges;
    //deconstructor
    public Graph(){
        this.edges = new ArrayList<>();
        this.vertices = new ArrayList<>();
    }
    Vertex addV (V value){
        Vertex v = new Vertex(value);
        this.vertices.add(v);
        return v;
    }
    Edge addE (Vertex from, Vertex to, E label){
        Edge edge = new Edge(from, to, label);
        this.edges.add(edge);
        from.adjacent.add(to);
        from.outdegree++;
        to.indegree++;
        return edge;
    }
    boolean adjacent (Vertex u, Vertex v){
        for (Vertex vertex: u.adjacent){
            if(vertex.equals(v)){
                return true;
            }
        }
        return false;
    }
    void removeE (Edge edge){
        edge.from.adjacent.remove(edge.to);
        edge.from.outdegree--;
        edge.to.indegree--;
        this.edges.remove(edge);
    }

}

