
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Simplied version of Sedgwick’s class.
 *
 * @author TIANZE ZHANG
 */
public class EdgeWeightedDigraph {
    private int V;                // number of vertices in this digraph
    private int E;                      // number of edges in this digraph
    private Bag<DirectedEdge>[] adj;    // adj[v] = adjacency list for vertex v

    public EdgeWeightedDigraph(String fileName) {

        Scanner scanner = getScanner(fileName);
        int V = scanner.nextInt();
        //EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner.nextInt());

        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<DirectedEdge>();

        int E = scanner.nextInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");

        for (int i = 0; i < E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            double weight = scanner.nextDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
        //  return graph;
    }

    private Scanner getScanner(String fileName) {
        if (fileName == null) throw new IllegalArgumentException("fileName is null");
        Scanner scanner = null;
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fis));
            ;
        } catch (Exception e1) {
            throw new RuntimeException("File access issue :" + e1);
        }

        return scanner;
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        E++;
    }



    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

}
