class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, 1, new ArrayList<>());
        return list;
    }

    public void helper(int n, int k, int num, List<Integer> temp){
        if(temp.size()==k) list.add(new ArrayList<>(temp));
        if(num>n) return;

        for(int i=num; i<=n; i++){
            temp.add(i);
            helper(n, k, i+1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}