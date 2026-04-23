class Solution {
    public int maxProfit(int[] nums) {
        int i=0;
        int maxProfit = 0;
        for(int j=1; j<nums.length; j++){
            if(nums[j] > nums[i]){
                maxProfit = Math.max(maxProfit, nums[j] - nums[i]);
            }
            else if (nums[j] < nums[i]){
                i = j;
            }
        }

        return maxProfit;
    }
}
