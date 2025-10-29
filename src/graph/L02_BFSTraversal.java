package graph;

import java.util.*;

/**
 * If you want to use string value in graph nodes then
 * please use String instead of Integers in throughout the code
 */
public class L02_BFSTraversal {

    private Map<Integer, List<Integer>> adjacencyList;

    /**
     * Constructor: creates an empty graph.
     * The adjacency list starts as an empty HashMap.
     */
    private L02_BFSTraversal() {
        adjacencyList = new HashMap<>();
    }

    private void addEdge(int v1, int v2) {
        // Ensure both vertices exist in the adjacency list
        adjacencyList.putIfAbsent(v1, new ArrayList<>());
        adjacencyList.putIfAbsent(v2, new ArrayList<>());

        // Add v2 to v1's list and v1 to v2's list (since undirected)
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }

    private void bfsTraversal(Integer u) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(u);
        queue.add(u);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            System.out.print(current + " ");

            for (Integer neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        L02_BFSTraversal graph = new L02_BFSTraversal();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.bfsTraversal(1);
    }
}
