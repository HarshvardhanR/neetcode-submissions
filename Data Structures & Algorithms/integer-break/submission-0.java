class Solution {

    int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        return dfs(n);
    }

    private int dfs(int n) {

        if (n == 1) return 1;

        if (memo[n] != 0) return memo[n];

        int max = 0;

        for (int j = 1; j < n; j++) {

            int noSplit = j * (n - j);

            int split = j * dfs(n - j);

            max = Math.max(max, Math.max(noSplit, split));
        }

        memo[n] = max;
        return max;
    }
}