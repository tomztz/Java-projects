import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Simplied version of Sedgwick’s class.
 *
 * @author TIANZE ZHANG
 */
public class AdjMatrixEdgeWeightedDigraph {
    private final int V;
    private int E;
    private DirectedEdge[][] adj;

    public AdjMatrixEdgeWeightedDigraph(String fileName) {

        Scanner scanner = getScanner(fileName);
        int V = scanner.nextInt();
        //EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner.nextInt());

        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        this.adj = new DirectedEdge[V][V];

        int E = scanner.nextInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");

        for (int i = 0; i < E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            double weight = scanner.nextDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }

    }

    /**
     * Returns the number of vertices in the edge-weighted digraph.
     * @return the number of vertices in the edge-weighted digraph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in the edge-weighted digraph.
     * @return the number of edges in the edge-weighted digraph
     */
    public int E() {
        return E;
    }

    /**
     * Adds the directed edge {@code e} to the edge-weighted digraph (if there
     * is not already an edge with the same endpoints).
     * @param e the edge
     */
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();

        if (adj[v][w] == null) {
            E++;
            adj[v][w] = e;
        }
    }


    public Iterable<DirectedEdge> adj(int v) {

        return new AdjIterator(v);
    }

    // support iteration over graph vertices
    private class AdjIterator implements Iterator<DirectedEdge>, Iterable<DirectedEdge> {
        private int v;
        private int w = 0;

        public AdjIterator(int v) {
            this.v = v;
        }

        public Iterator<DirectedEdge> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w] != null) return true;
                w++;
            }
            return false;
        }
        public DirectedEdge next() {
            return adj[v][w++];
        }
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

}