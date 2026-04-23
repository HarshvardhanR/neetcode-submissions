class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s1 = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(!s1.contains(nums[i])){
                s1.add(nums[i]);
            }
            else{
                return true;
            }
        }
        return false;
    }
}
