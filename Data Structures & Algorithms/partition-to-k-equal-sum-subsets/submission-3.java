class Solution {
    int[] buckets;
    int globalTarget = 0;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        buckets = new int[k];

        int total = 0;
        for (int num : nums) total += num;

        if (total % k != 0) return false;

        globalTarget = total / k;
       Arrays.sort(nums);

        for(int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        return helper(nums, k, globalTarget, 0);
    }

    public boolean helper(int[] nums, int k, int target, int index) {
        if (index == nums.length) {
            for (int bucket : buckets) {
                if (bucket != target) return false;
            }
            return true;
        }

        int number = nums[index];

        for (int i = 0; i < k; i++) {
            if (buckets[i] + number <= target) {

                buckets[i] += number;

                if (helper(nums, k, target, index + 1))
                    return true;

                buckets[i] -= number;
            }
        }

        return false;
    }
}