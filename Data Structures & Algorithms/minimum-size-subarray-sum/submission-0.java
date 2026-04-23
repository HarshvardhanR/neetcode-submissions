class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int currSum = 0;
        int min = nums.length + 1;
        for(int j=0; j<nums.length; j++){
            currSum += nums[j];

            while(currSum >= target){
                min = Math.min(min, j - i + 1);
                currSum -= nums[i];
                i++;
            }
        }

        return min==nums.length + 1 ? 0 : min;
    }
}