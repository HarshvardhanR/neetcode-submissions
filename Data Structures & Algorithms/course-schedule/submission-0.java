class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> h1 = new HashMap<>();
        HashSet<Integer> s1 = new HashSet<>();
        for(int i=0; i<numCourses; i++){
            h1.put(i, new ArrayList<>());
        }
        for(int[] pair : prerequisites){
            h1.get(pair[0]).add(pair[1]);
        }
        for(Integer i: h1.keySet()){
            if(!dfs(i, h1, s1)){
                return false;
            }
        }
        return true;
        
    }

    public boolean dfs(int course, HashMap<Integer, List<Integer>> h1, HashSet<Integer> s1){
        if(s1.contains(course)){
            return false;
        }
        if(h1.get(course).isEmpty()){
            return true;
        }
        s1.add(course);
        for(int i: h1.get(course)){
            if(!dfs(i, h1, s1)){
                return false;
            }
        }
        s1.remove(course);
        h1.put(course, new ArrayList<>());
        return true;
    }
}
