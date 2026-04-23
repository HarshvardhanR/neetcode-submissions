class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1]<nums[i]){
                ans = nums[i+1];
                break;
            }
        }
        return ans;
    }
}
