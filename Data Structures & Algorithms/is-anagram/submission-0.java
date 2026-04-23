class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();

        for(int i=0; i<s.length();i++){
            if(h1.containsKey(s.charAt(i))){
                int x = h1.get(s.charAt(i)) + 1;
                h1.put(s.charAt(i), x);
            }
            else{
                h1.put(s.charAt(i), 1);
            }
            if(h2.containsKey(t.charAt(i))){
                int y = h2.get(t.charAt(i)) + 1;
                h2.put(t.charAt(i), y);
            }
            else{
                h2.put(t.charAt(i), 1);
            }
        }

        if(h1.equals(h2)){
            return true;
        }
        return false;
    }
}
