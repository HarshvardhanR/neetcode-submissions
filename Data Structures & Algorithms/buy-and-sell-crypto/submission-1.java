class Solution {
    public int maxProfit(int[] prices) {
        int p1=0;
        int p2=1;
        int max = 0;
        while(p1!=prices.length-1 && p2!=prices.length){
            if(prices[p2]<prices[p1]){
                p1 = p2;
                p2 = p1 + 1;
            }
            else if(prices[p2]>prices[p1]){
                max = Math.max(max, prices[p2]-prices[p1]);
                p2++;
            }
            else{
                p1 = p2;
                p2 = p1 + 1;
            }
        }
        return max;
    }
}
