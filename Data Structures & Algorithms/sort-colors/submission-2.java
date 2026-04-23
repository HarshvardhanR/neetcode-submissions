class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int start = 0;
        int mid = 0;
        int end = n - 1;

        while(mid<=end){
            if(nums[mid]==0){
                swap(mid, start, nums);
                mid++;
                start++;
            }
            else if(nums[mid]==2){
                swap(mid, end, nums);
                end--;
            }
            else if(nums[mid]==1){
                mid++;
            }
            
        }
    }

    public void swap(int i, int j, int nums[]){
       int temp = nums[i];
       nums[i] = nums[j];
       nums[j] = temp;
    }
}