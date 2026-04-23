class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int ansArray[] = new int[nums.length];

        int multiple = 1;
        boolean zeroFound = false;
        int zeroCount = 0;
        int zeroIndex = -1;


        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                zeroFound = true;
                zeroIndex = i;
                zeroCount++;
            }
            else{
                multiple = multiple * nums[i];
            }
        }

        if(zeroCount>1){
            return ansArray;
        }

        if(zeroFound){
            for(int i=0; i<nums.length; i++){
                if(zeroIndex==i){
                    ansArray[i] = multiple;
                    continue;
                }
                ansArray[i] = 0;
            }
        }
        else{
            for(int i=0; i<nums.length; i++){
                ansArray[i] = multiple/nums[i];
            }
        }
        return ansArray;
    }
}  
