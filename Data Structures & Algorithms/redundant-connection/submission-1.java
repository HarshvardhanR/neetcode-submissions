class Solution {
    List<List<Integer>> adjList = new ArrayList<>();
    int cycleStart = -1;
    Set<Integer> cycleSet = new HashSet<>();

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visit = new boolean[n + 1];

        dfs(1, -1, visit);

        for (int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (cycleSet.contains(u) && cycleSet.contains(v)) {
                return new int[]{u, v};
            }
        }

        return new int[]{};
    }

    public boolean dfs(int node, int parent, boolean[] visit) {

        if (visit[node]) {
            cycleStart = node;
            return true;
        }

        visit[node] = true;

        for (int adj : adjList.get(node)) {

            if (adj == parent) continue;

            if (dfs(adj, node, visit)) {

                if (cycleStart != -1) {
                    cycleSet.add(node);
                }

                if (node == cycleStart) {
                    cycleStart = -1;
                }

                return true;
            }
        }

        return false;
    }
}