class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outerList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int p1 = i+1;
            int p2 = nums.length-1;
            while(p1<p2){
                if(nums[p1] + nums[p2] + nums[i]==0){
                    addUniqueList(outerList, Arrays.asList(nums[i], nums[p1], nums[p2]));
                    p1++;
                    p2--;
                }
                else if(nums[p1] + nums[p2] + nums[i]>0){
                    p2--;
                }
                else{
                    p1++;
                }
            }
        }
        return outerList;
    }

    public void addUniqueList(List<List<Integer>> outerList, List<Integer> newList) {
        List<Integer> sortedList = new ArrayList<>(newList);
        Collections.sort(sortedList);

        if (!outerList.contains(sortedList)) {
            outerList.add(sortedList);
        }
    }
}
