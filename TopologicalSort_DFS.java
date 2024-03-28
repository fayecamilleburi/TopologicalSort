//Code by: Jimuel Angelo Maxwell

import java.util.*;

class TopologicalSort_DFS {
    int V; // No. of vertices
    List<Integer> adjListArray[];

    public TopologicalSort_DFS(int V) {
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

    // Depth-First Search (DFS) function
    private void dfs(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for (int adjacent : adjListArray[vertex]) {
            if (!visited[adjacent]) {
                dfs(adjacent, visited, stack);
            }
        }
        stack.push(vertex);
    }

    // Function to perform topological sort using DFS
    public List<List<Integer>> topologicalSortDFS() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Perform DFS from each vertex if not visited
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        // Create an array to store the topological order
        int[] topologicalOrder = new int[V];
        int index = 0;
        while (!stack.isEmpty()) {
            topologicalOrder[index++] = stack.pop();
        }

        // Generate all possible topological sorts
        return generateTopologicalSorts(topologicalOrder);
    }

    // Function to generate all possible topological sorts
    private List<List<Integer>> generateTopologicalSorts(int[] topologicalOrder) {
        List<List<Integer>> allSorts = new ArrayList<>();
        List<Integer> currentOrder = new ArrayList<>();
        boolean[] used = new boolean[V];
        backtrack(topologicalOrder, currentOrder, used, allSorts);
        return allSorts;
    }

    // Backtracking function to generate all possible permutations
    private void backtrack(int[] topologicalOrder, List<Integer> currentOrder, boolean[] used, List<List<Integer>> allSorts) {
        if (currentOrder.size() == V) {
            List<Integer> result = new ArrayList<>();
            for (int i = V - 1; i >= 0; i--) {
                result.add(currentOrder.get(i));
            }
            allSorts.add(result);
            return;
        }

        for (int i = 0; i < topologicalOrder.length; i++) {
            int vertex = topologicalOrder[i];
            if (!used[vertex]) {
                boolean isValid = true;
                for (int adjacent : adjListArray[vertex]) {
                    if (!used[adjacent]) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    used[vertex] = true;
                    currentOrder.add(vertex);
                    backtrack(topologicalOrder, currentOrder, used, allSorts);
                    currentOrder.remove(currentOrder.size() - 1);
                    used[vertex] = false;
                }
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        // Create a graph for steps to prepare for school diagram
        TopologicalSort_DFS graph = new TopologicalSort_DFS(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        System.out.println("All Topological sorts:");
        List<List<Integer>> allSorts = graph.topologicalSortDFS();
        for (List<Integer> sort : allSorts) {
            for (int vertex : sort) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
}
