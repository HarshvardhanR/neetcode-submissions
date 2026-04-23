class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        if(amount==0) return 0;
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for(int i=1; i<=amount; i++){
            for(int num: coins){
                if(i>=num){
                    dp[i] = Math.min(dp[i], 1 + dp[i-num]);
                }
            }
        }

        return dp[amount]==amount+1 ? -1 : dp[amount];
    }
}
