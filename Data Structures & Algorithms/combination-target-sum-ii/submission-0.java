class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), target);
        return ans;
    }

    public void helper(int[] nums, int index, List<Integer> temp, int target) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (index >= nums.length || target < 0) return;

        temp.add(nums[index]);
        helper(nums, index + 1, temp, target - nums[index]);
        temp.remove(temp.size() - 1);

        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
            nextIndex++;
        }

        helper(nums, nextIndex, temp, target);
    }
}