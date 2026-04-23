class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        int first = 0;
        int second = 0 + nums.length;
        for(int i=0; i<nums.length; i++){
            ans[first] = nums[i];
            ans[second] = nums[i];
            first++;
            second++; 
        }
        return ans;
    }
}