class Solution {
    List<List<Integer>> adjList = new ArrayList<>();
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int minHeight = n;

        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<adjList.size(); i++){
            int currHeight = dfs(i, -1);
            if(currHeight==minHeight){
                res.add(i);
            }
            else if(currHeight < minHeight){
                minHeight = currHeight;
                res = new ArrayList<>();
                res.add(i);
            }
        }

        return res;
    }

    public int dfs(int node, int parent){
        int height = 0;
        for(int adj : adjList.get(node)){
            if(adj==parent){
                continue;
            }
            height = Math.max(height, 1 + dfs(adj, node));
        }
        return height;
    }
}