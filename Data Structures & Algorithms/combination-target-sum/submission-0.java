class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(nums, 0, new ArrayList<>(), target);
        return ans;
    }

    public void helper(int[] nums, int index, List<Integer> temp, int target){
        if(index >= nums.length || target < 0) return;
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        helper(nums, index, temp, target - nums[index]);
        temp.remove(temp.size() - 1);

        helper(nums, index + 1, temp, target);
    }
}
