//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adjList);
            }
        }
    }

    static boolean hasCycle(int node, boolean[] visited, int parent, ArrayList<ArrayList<Integer>> adjList) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, visited, node, adjList)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Back edge found, indicating a cycle
            }
        }
        return false;
    }
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        // code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Check if the graph is connected
        boolean[] visited = new boolean[n];
        dfs(0, visited, adjList);
        for (boolean v : visited) {
            if (!v) {
                return false; // Graph is not connected
            }
        }

        // Check for cycles
        visited = new boolean[n];
        if (hasCycle(0, visited, -1, adjList)) {
            return false; // Graph has a cycle
        }

        // Check if the number of edges is exactly n-1
        int edgeCount = 0;
        for (int i = 0; i < n; i++) {
            edgeCount += adjList.get(i).size();
        }
        edgeCount /= 2; // Since each edge is counted twice
        return edgeCount == n - 1;
    }
}

