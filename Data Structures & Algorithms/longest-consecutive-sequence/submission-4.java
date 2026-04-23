class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int num : nums){
            if(set.contains(num - 1)) continue;

            int current = num;
            int currMax = 1;
            while(set.contains(current + 1)){
                currMax++;
                current = current + 1;
            }

            max = Math.max(max, currMax);
        }

        return max;    }
}
