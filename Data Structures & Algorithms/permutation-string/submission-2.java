class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }

        int arrayS1[] = new int[26];
        int arrayS2[] = new int[26];

        for(int i=0; i<s1.length();i++){
            arrayS1[s1.charAt(i) - 'a']++;
            arrayS2[s2.charAt(i) - 'a']++; 
        }

        int matches = 0;
        for(int i=0; i<26; i++){
            if(arrayS1[i]==arrayS2[i]){
                matches++;
            }
        }

        int l=0;
        for(int r=s1.length(); r<s2.length(); r++){
            if(matches==26){
                return true;
            }

            arrayS2[s2.charAt(r) - 'a']++;
            if(arrayS2[s2.charAt(r) - 'a']==arrayS1[s2.charAt(r) - 'a']){
                matches++;
            }
            else if(arrayS2[s2.charAt(r) - 'a']==arrayS1[s2.charAt(r) - 'a'] + 1){
                matches--;
            }
            
            arrayS2[s2.charAt(l) - 'a']--;
            if(arrayS2[s2.charAt(l) - 'a']==arrayS1[s2.charAt(l) - 'a']){
                matches++;
            }
            else if(arrayS2[s2.charAt(l) - 'a']==arrayS1[s2.charAt(l) - 'a'] - 1) {
                matches--;
            }

            l++;
        }
        return matches==26;

    }
}
