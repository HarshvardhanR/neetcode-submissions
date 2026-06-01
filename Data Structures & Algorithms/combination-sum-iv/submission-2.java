class Solution {
    int[] nums;
    int dp[];

    public int combinationSum4(int[] nums, int target) {
        this.nums = nums;
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return dfs(target);
    }

    private int dfs(int target) {
        if (target == 0) return 1;
        if(dp[target]!= -1) return dp[target];
        int ways = 0;
        for (int num : nums) {
            if (num <= target) {
                ways += dfs(target - num);
            }
        }

        return dp[target] = ways;
    }
}