class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        for(int i=0; i<piles.length; i++){
            if(piles[i]>max){
                max = piles[i];
            }
        }
        int l=1;
        int r=max;
        int res = r;
        while(l<=r){
            int mid = (l+r)/2;

            int count = 0;
            for(int p: piles){
                count += Math.ceil((double) p/mid);
            }
            if(count<=h){
                res = mid;
                r = mid-1;
            }
            else{
                l = mid + 1;
            }
        }
        return res;
    }
}
