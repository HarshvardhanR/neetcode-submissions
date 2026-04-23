class Solution {
    public int majorityElement(int[] nums) {
        Integer element = null;
        int elementCount = 0;
        for(int num: nums){
            if(element==null){
                element = num;
            }
            if(element==num){
                elementCount++;
            }
            else{
                elementCount--;
            }
            if(elementCount==0){
                element = null;
            }
        }
        return element;
    }
}