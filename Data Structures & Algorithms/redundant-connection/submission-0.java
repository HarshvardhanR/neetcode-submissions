class Solution {
    List<List<Integer>> adjList = new ArrayList<>();
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            boolean visit[] = new boolean[n + 1];
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            if(dfs(u, -1, visit)){
                return new int[]{u, v};
            }
        }

        return new int[]{};
    }

    public boolean dfs(int node, int parent, boolean visit[]){
        if(visit[node]){
            return true;
        }
        visit[node] = true;
        for(int adj: adjList.get(node)){
            if(adj==parent) continue;
            if(dfs(adj, node, visit)) return true;
        }

        return false;
    }
}
