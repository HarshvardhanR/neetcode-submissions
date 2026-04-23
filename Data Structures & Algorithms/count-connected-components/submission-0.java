class Solution {
    public int countComponents(int n, int[][] edges) {
        int parent[] = new int[n + 1];
        int rank[] = new int[n + 1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        int ans = n;
        for(int [] pair: edges){
            if(union(pair[0], pair[1], parent, rank)){
                ans--;
            }
        }
        return ans;
    }

    public int findParent(int n1, int []parent){
        if(n1!=parent[n1]){
            parent[n1] = findParent(parent[n1], parent);
        }
        return parent[n1];
    }

    public boolean union(int n1, int n2, int[] parent, int[] rank) {
        int np1 = findParent(n1, parent);
        int np2 = findParent(n2, parent);
        if (np1 == np2) {
            return false;
        }
        if (rank[np1] > rank[np2]) { 
            parent[np2] = np1; 
        } else if (rank[np1] < rank[np2]) { 
            parent[np1] = np2; 
        } else {
            parent[np2] = np1;
            rank[np1]++;  
        }
    return true;
}

}
