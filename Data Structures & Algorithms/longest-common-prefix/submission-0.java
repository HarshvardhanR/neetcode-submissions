class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a,b) -> a.compareTo(b));
        for(int i=0; i<strs.length; i++){
            System.out.println(strs[i]);
        }
        int i=0;
        while(i<strs[0].length() && i<strs[strs.length - 1].length()){
            if(strs[0].charAt(i)!=strs[strs.length - 1].charAt(i)){
                break;
            }
            i++;
        }
        return strs[0].substring(0,i);
    }
}