import java.util.ArrayList;
import java.util.List;

class Graph_Init {
    private final int V;
    private final List<List<Integer>> adj;

    public Graph_Init(int vertices) {
        V = vertices;
        this.adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public boolean isCyclicUtil(int v, boolean[] visited, boolean[] recursionStack) {
        visited[v] = true;
        recursionStack[v] = true;

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack[neighbor]) {
                return true;
            }
        }

        recursionStack[v] = false;
        return false;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, recursionStack))
                    return true;
            }
        }
        return false;
    }
}
public class Graph {
        public static void main(String[] args) {
            Graph_Init g = new Graph_Init(4);
            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);

            if (g.isCyclic()) {
                System.out.println("Graph contains cycle");
            } else {
                System.out.println("Graph does not contain cycle");
            }
        }
    }
