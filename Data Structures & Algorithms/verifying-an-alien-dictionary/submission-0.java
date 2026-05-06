class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] arr = new int[26];
        
        for (int i = 0; i < order.length(); i++) {
            arr[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            int j = 0;
            while (j < first.length() && j < second.length()) {
                if (first.charAt(j) != second.charAt(j)) {
                    if (arr[first.charAt(j) - 'a'] > arr[second.charAt(j) - 'a']) {
                        return false;
                    }
                    break;
                }
                j++;
            }

            if (j == second.length() && first.length() > second.length()) {
                return false;
            }
        }

        return true;
    }
}