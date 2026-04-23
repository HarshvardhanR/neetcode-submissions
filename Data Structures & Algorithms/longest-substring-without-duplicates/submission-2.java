class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.equals("")){
            return 0;
        }

        int maxSubstring = 1;
        HashSet<Character> h1= new HashSet<Character>();

        int left=0;
        int right = left+1;
        h1.add(s.charAt(left));

        int current = 1;
        while(left!=s.length()-1 && right!=s.length()){
            if(!h1.contains(s.charAt(right))){
                h1.add(s.charAt(right));
                right++;
                current++;
            }
            else{
                maxSubstring = Math.max(maxSubstring, current);
                h1.remove(s.charAt(left));
                current--;
                left++;
            }
        }

        maxSubstring = Math.max(maxSubstring, current);
        return maxSubstring;
    }
}
