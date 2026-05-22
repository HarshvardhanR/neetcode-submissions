class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        int m = nums.length;
        int n = nums[0].length;

        int low = 0;
        int high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid][n - 1] == target) {
                return true;
            }

            if (nums[mid][n - 1] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int row = low;

        if (row >= m) {
            return false;
        }

        low = 0;
        high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[row][mid] == target) {
                return true;
            }

            if (nums[row][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}