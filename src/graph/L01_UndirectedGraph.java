package graph;

import java.util.*;

/**
 * Represents an undirected graph using an adjacency list.
 *
 * <p> A graph is a set of nodes (vertices) connected by edges.
 * In an <b>undirected</b> graph, the edges have no direction,
 * meaning if there is an edge between node 1 and node 2,
 * you can travel both ways — from 1 to 2 and from 2 to 1.
 *
 * <p>Example Graph:
 * <pre>
 *     (1)
 *    /   \
 *  (2)   (3)
 *    \   /
 *     (4)
 * </pre>
 *
 * <p>The adjacency list representation of the above graph:
 * <pre>
 *     1 -> [2, 3]
 *     2 -> [1, 4]
 *     3 -> [1, 4]
 *     4 -> [2, 3]
 * </pre>
 *
 * This means:
 * - Node 1 is connected to nodes 2 and 3
 * - Node 2 is connected to nodes 1 and 4
 * - Node 3 is connected to nodes 1 and 4
 * - Node 4 is connected to nodes 2 and 3
 */
public class L01_UndirectedGraph {

    // This map stores each vertex (key) and the list of vertices it connects to (value)
    private Map<Integer, List<Integer>> adjacencyList;

    /**
     * Constructor: creates an empty graph.
     * The adjacency list starts as an empty HashMap.
     */
    public L01_UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Adds an edge (connection) between two vertices.
     * Since this is an undirected graph, both directions are added.
     *
     * @param v1 the first vertex
     * @param v2 the second vertex
     */
    public void addEdge(int v1, int v2) {
        // Ensure both vertices exist in the adjacency list
        adjacencyList.putIfAbsent(v1, new ArrayList<>());
        adjacencyList.putIfAbsent(v2, new ArrayList<>());

        // Add v2 to v1's list and v1 to v2's list (since undirected)
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }

    /**
     * Removes an edge (connection) between two vertices.
     * Both directions are removed since the graph is undirected.
     *
     * @param v1 the first vertex
     * @param v2 the second vertex
     */
    public void removeEdge(int v1, int v2) {
        List<Integer> eV1 = adjacencyList.get(v1);
        List<Integer> eV2 = adjacencyList.get(v2);

        // Remove v2 from v1’s list
        if (eV1 != null) eV1.remove(Integer.valueOf(v2));

        // Remove v1 from v2’s list
        if (eV2 != null) eV2.remove(Integer.valueOf(v1));
    }

    /**
     * Removes a vertex completely from the graph.
     * This also removes all edges connected to that vertex.
     *
     * @param vertex the vertex to remove
     */
    public void removeVertex(int vertex) {
        // Get all neighbors connected to this vertex
        List<Integer> neighbors = adjacencyList.get(vertex);

        if (neighbors != null) {
            // Remove this vertex from each of its neighbors' lists
            for (Integer neighbor : neighbors) {
                adjacencyList.get(neighbor).remove(Integer.valueOf(vertex));
            }
        }

        // Finally, remove the vertex itself from the graph
        adjacencyList.remove(vertex);
    }

    /**
     * Prints the current structure of the graph.
     * Example:
     * 1 -> [2, 3]
     * 2 -> [1, 4]
     */
    public void printGraph() {
        for (var entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    /**
     * Main method to demonstrate adding, removing, and printing graph data.
     */
    public static void main(String[] args) {
        // Create a new graph
        L01_UndirectedGraph graph = new L01_UndirectedGraph();

        // Add edges to form the example graph structure
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        // Display the initial graph
        System.out.println("Graph:");
        graph.printGraph();

        // Remove one edge (1,3)
        graph.removeEdge(1, 3);
        System.out.println("\nAfter removing edge (1,3):");
        graph.printGraph();

        // Remove vertex 4 completely
        graph.removeVertex(4);
        System.out.println("\nAfter removing vertex 4:");
        graph.printGraph();
    }
}
