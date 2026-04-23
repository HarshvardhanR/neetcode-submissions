class Solution {

    public String encode(List<String> strs) {
        String str = "";
        for(String s : strs){
            str = str + s.length() + "#" + s;
        }
        return str;
    }

    public List<String> decode(String str) {
        ArrayList<String> a1 = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            a1.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        
        return a1;
    }

}
