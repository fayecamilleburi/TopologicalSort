// This is the final code.
// Code by: Jimuel Angelo Maxwell
// package machine;

import java.util.*;

class TopologicalSort_VSD {
    int V; // No. of vertices
    List<Integer> adjListArray[];

    public TopologicalSort_VSD(int V) {
        this.V = V;
        @SuppressWarnings("unchecked")
        List<Integer> adjListArray[] = new LinkedList[V];
        this.adjListArray = adjListArray;
        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    // Utility function to add edge
    public void addEdge(int src, int dest) {
        this.adjListArray[src].add(dest);
    }

    // Function to perform topological sort using variable size decrease algorithm
    public List<List<Integer>> topologicalSortVariableSizeDecrease() {
        // Calculate in-degrees of all vertices
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int adjacent : adjListArray[i]) {
                inDegree[adjacent]++;
            }
        }

        // Initialize a queue and enqueue all vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // List to store all possible topological orders
        List<List<Integer>> allOrders = new ArrayList<>();

        // Recursively explore all possible orders
        backtrack(queue, inDegree, new ArrayList<>(), allOrders);

        return allOrders;
    }

    // Backtracking function to generate all possible orders
    private void backtrack(Queue<Integer> queue, int[] inDegree, List<Integer> currentOrder, List<List<Integer>> allOrders) {
        if (queue.isEmpty()) {
            allOrders.add(new ArrayList<>(currentOrder));
            return;
        }

        Queue<Integer> queueCopy = new LinkedList<>(queue);
        while (!queueCopy.isEmpty()) {
            int vertex = queueCopy.poll();
            currentOrder.add(vertex);
            Queue<Integer> nextQueue = new LinkedList<>(queue);
            nextQueue.remove(vertex);
            for (int adjacent : adjListArray[vertex]) {
                inDegree[adjacent]--;
                if (inDegree[adjacent] == 0) {
                    nextQueue.add(adjacent);
                }
            }
            backtrack(nextQueue, inDegree, currentOrder, allOrders);
            for (int adjacent : adjListArray[vertex]) {
                inDegree[adjacent]++;
            }
            currentOrder.remove(currentOrder.size() - 1);
        }
    }

    // Driver code
    public static void main(String[] args) {
        // Create a graph for steps to get dressed for school diagram
        TopologicalSort_VSD graph = new TopologicalSort_VSD(9);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 8);
        graph.addEdge(6, 8);
        graph.addEdge(7, 8);

        System.out.println("All possible topological orders:");
        List<List<Integer>> allOrders = graph.topologicalSortVariableSizeDecrease();
        for (List<Integer> order : allOrders) {
            for (int vertex : order) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
}
