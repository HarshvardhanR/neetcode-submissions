class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int dp[] = new int[target + 1];
        dp[0] = 1;
        for(int i=0; i<=target; i++){
            for(int coin: nums){
                if(i >= coin){
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[target];
    }
}