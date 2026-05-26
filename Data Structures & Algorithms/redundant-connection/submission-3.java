class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n + 1);

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            if(dsu.union(u, v)) return new int[]{u, v};
        }

        return new int[]{};
    }
}

class DSU{
    int parent[];
    int rank[];

    public DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int u){
        if(parent[u]!=u){
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    public boolean union(int u, int v){
        int uParent = find(u);
        int vParent = find(v);

        if(uParent==vParent) return true;

        if(rank[uParent] > vParent){
            parent[vParent] = uParent;
        }
        else if(rank[uParent] < vParent){
            parent[uParent] = vParent;
        }
        else{
            parent[vParent] = uParent;
            rank[uParent]++;
        }

        return false;
    }
}
