class Solution {
    public int[] twoSum(int[] nums, int target) {
        int outputArray[] = new int[2];
        HashMap<Integer, Integer> h1 = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];

            if(h1.containsKey(diff)){
                outputArray[0] = Math.min(i, h1.get(diff));
                outputArray[1] = Math.max(i, h1.get(diff));
                break;
            }

            h1.put(nums[i], i);
        }

        return outputArray;
    }
}
