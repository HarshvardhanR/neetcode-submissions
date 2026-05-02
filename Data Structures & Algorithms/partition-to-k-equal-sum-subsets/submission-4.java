

class Solution {
    int[] buckets;
    int target;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % k != 0) return false;

        target = sum / k;
        buckets = new int[k];

        // sort descending
        Arrays.sort(nums);
        reverse(nums);

        // largest number too big
        if (nums[0] > target) return false;

        return backtrack(nums, 0, k);
    }

    private boolean backtrack(int[] nums, int index, int k) {
        if (index == nums.length) return true;

        int num = nums[index];

        for (int i = 0; i < k; i++) {

            // cannot place
            if (buckets[i] + num > target) continue;

            // skip duplicate bucket states
            if (i > 0 && buckets[i] == buckets[i - 1]) continue;

            buckets[i] += num;

            if (backtrack(nums, index + 1, k)) return true;

            buckets[i] -= num;

            // if empty bucket failed, no need to try other empty buckets
            if (buckets[i] == 0) break;
        }

        return false;
    }

    private void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}