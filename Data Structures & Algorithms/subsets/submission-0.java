class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return list;
    }

    public void helper(int nums[], int index, List<Integer> ans){
        list.add(new ArrayList<>(ans));
        if(index==nums.length) return;
        for(int i=index; i<nums.length; i++){
            ans.add(nums[i]);
            helper(nums, i+1, ans);
            ans.remove(ans.size() - 1);
        }
    }
}
