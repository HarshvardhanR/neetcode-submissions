class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones) sum+= stone;

        int target = sum/2;

        // we are trying to achieve the target
        int dp[] = new int[target + 1];

        for(int stone: stones){
            for(int i=target; i>=0; i--){
                if(stone <= i){
                    dp[i] = Math.max(dp[i], dp[i - stone] + stone);
                }
            }
        }

        int best = dp[target];
        return sum - 2*best;
    }
}