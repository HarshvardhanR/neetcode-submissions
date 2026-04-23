class Solution {
    public int maxArea(int[] heights) {
        int max= 0;
        if(heights.length==0 || heights.length==1){
            return max;
        }
        int p1 = 0;
        int p2 = heights.length-1;
        int current = 0;
        while(p1<p2){
            current = Math.min(heights[p1], heights[p2]) * (p2-p1);
            max  = Math.max(current, max);
            if(heights[p1]<=heights[p2]){
                p1++;
            }
            else{
                p2--;
            }
        }
        return max;
    }
}
