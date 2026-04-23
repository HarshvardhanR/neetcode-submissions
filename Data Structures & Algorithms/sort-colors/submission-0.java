class Solution {
    public void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for(int num: nums){
            if(num==0) zeroCount++;
            else if(num==1) oneCount++;
            else twoCount++;
        }

        int index = 0;

        for(int i=0; i<nums.length; i++){
            if(zeroCount!=0){
                zeroCount--;
                nums[i] = 0;
            }
            else if(oneCount!=0){
                oneCount--;
                nums[i] = 1;
            }
            else{
                nums[i] = 2;
                twoCount--;
            }
        }
    }
}