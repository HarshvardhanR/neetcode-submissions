class Solution {



    // example

    /*
        0 a b a b d
        a T F 
        b   T F
        a     T F  
        b       T F
        d         T 

    */
    
    
    public String longestPalindrome(String s) {
        int stringLength = s.length();
        boolean dp[][] = new boolean[stringLength][stringLength];
        int maxLength = 1;
        int start = 0;
        
        // length 1
        for(int i=0; i<stringLength; i++){
            dp[i][i] = true;
        }
        
        //length 2
        for(int i=0; i<stringLength - 1; i++){
            if(s.charAt(i)==s.charAt(i+1)){
                start = i;
                maxLength = 2;
                dp[i][i+1] = true; 
            }
        }

        // length 3 onwards

        for(int i=2; i<stringLength; i++){
            for(int j=0; j<stringLength - i; j++){
                int k = j + i;
                if(s.charAt(j)==s.charAt(k)){
                    dp[j][k] = dp[j + 1][k - 1];
                }

                if(dp[j][k] && (k - j + 1 > maxLength)){
                    start = j;
                    maxLength = k - j + 1;
                }
            }
        }

        return s.substring(start, start + maxLength);

    }
}
