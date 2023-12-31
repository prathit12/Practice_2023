import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph_3 {
    public boolean canFinish( int n, int[][] preReq) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] pre : preReq) {
            int course = pre[0];
            int preRequisite = pre[1];
            adjList.get(course).add(preRequisite);
        }

        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && hasCycle(adjList, visited, i))
                return false;
        }
        return true;
    }
    public boolean hasCycle(Map<Integer, List<Integer>> adjList, int[] visited, int i ){
        if (visited[i] == 1){
            return true;
        }
        if (visited[i] == 2){
            return false;
        }
        visited[i] = 1;
        for(int pre: adjList.get(i)){
            if (hasCycle(adjList,visited,pre)){
                return true;
            }
        }
        visited[i] = 2;
        return false;
    }

    public static void main(String[] args) {
        Graph_3 sol = new Graph_3();
        int[][] prereq  = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(sol.canFinish(3,prereq));
    }
}
