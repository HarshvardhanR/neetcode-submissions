class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashSet<Integer> s1 = new HashSet<>();
        HashMap<Integer, List<Integer>> h1 = new HashMap<>();
        for(int i=0; i<n; i++){
            h1.put(i, new ArrayList<>());
        }

        for(int[] pair: edges){
            h1.get(pair[0]).add(pair[1]);
            h1.get(pair[1]).add(pair[0]);
        }
        if(!dfs(0, -1, h1, s1)){
            return false;
        }
        return s1.size()==n;
    }

    public boolean dfs(int curr, int prev, HashMap<Integer, List<Integer>> h1, HashSet<Integer> s1){
        if(s1.contains(curr)){
            return false;
        }
        s1.add(curr);
        for(Integer neighbor: h1.get(curr)){
            if(neighbor==prev){
                continue;
            }
            if(dfs(neighbor, curr, h1, s1)==false){
                return false;
            }
        }
        return true;
    }
}
