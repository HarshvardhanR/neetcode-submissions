class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        TreeSet<Integer> t1 = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            t1.add(nums[i]);
        }

        int val = t1.first();

        Iterator<Integer> it = t1.iterator();

        if (it.hasNext()) {
            it.next();
        }

        int count = 1;
        int maxCount = 1;

        while(it.hasNext()){
            int valToComp = it.next();
            if(val + 1 == valToComp){
                count++;
                val = valToComp;
                if(count>maxCount){
                    maxCount = count;
                }
                continue;
            }
            System.out.println(count);
            count = 1;
            val = valToComp;
        }
        return maxCount;
    }
}
