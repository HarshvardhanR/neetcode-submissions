class Solution {
    int globalTarget = 0;

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int x : matchsticks) sum += x;

        if (sum % 4 != 0) return false;

        globalTarget = sum / 4;

        return helper(matchsticks, 0, 1, globalTarget);
    }

    public boolean helper(int[] matchsticks, int index, int side, int target) {
        if (side == 4) return true;

        if (target == 0) {
            return helper(matchsticks, 0, side + 1, globalTarget);
        }

        if (index >= matchsticks.length) return false;

        boolean take = false;
        boolean skip = false;

        if (matchsticks[index] <= target) {
            int val = matchsticks[index];
            matchsticks[index] = Integer.MAX_VALUE; // mark used

            take = helper(matchsticks, index + 1, side, target - val);

            matchsticks[index] = val; // restore
        }

        skip = helper(matchsticks, index + 1, side, target);

        return take || skip;
    }
}