package graph;

import java.util.*;

/**
 *
 */
public class L03_DFSTraversal {

    private Map<Integer, List<Integer>> adjacencyList;

    /**
     * Constructor: creates an empty graph.
     * The adjacency list starts as an empty HashMap.
     */
    private L03_DFSTraversal() {
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

    // Iterative Approach

    /**
     * TC =
     * Node Work: The time in processing nodes is O(V), as each node is visited exactly once.
     * Edge Work: The time in processing edges is O(E), as each edge is explored once.
     */
    private void dfsTraversalIterative(int u) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(u);
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            if (!visited.contains(node)) {
                System.out.println("Popped is the result" + node);
                visited.add(node);
                List<Integer> neighbours = adjacencyList.get(node);

                for (int neighbour : neighbours) {
                    if (!visited.contains(neighbour)) {
                        stack.push(neighbour);
                    }
                }
            }
        }
    }

    // Recursive DFS in one method
    /**
     * TC =
     * Node Work: The time in processing nodes is O(V), as each node is visited exactly once.
     * Edge Work: The time in processing edges is O(E), as each edge is explored once.
     */
    public void dfsTraversalRecursion(Integer node, Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        System.out.print(node + " ");

        for (Integer neighbor : adjacencyList.getOrDefault(node, new ArrayList<>())) {
            dfsTraversalRecursion(neighbor, visited);
        }
    }

    public static void main(String[] args) {
        L03_DFSTraversal graph = new L03_DFSTraversal();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.dfsTraversalIterative(1);
        graph.dfsTraversalRecursion(1, new HashSet<>());
    }
}
