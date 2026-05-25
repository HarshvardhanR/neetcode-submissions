class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int [] edge: edges){
            dsu.union(edge[0], edge[1]);
        }
        Integer parent = null;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(dsu.find(i));
        }

        return set.size();

    }
}

class DSU {
    int[] parent;
    int[] rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    public void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}