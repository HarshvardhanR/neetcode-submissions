class Pair{
    String s;
    int i;
    public Pair(String s, int i){
        this.s = s;
        this.i = i;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int max = 0;
        HashSet<String> set = new HashSet<>();
        for(String str: wordList){
            set.add(str);
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int distance = p.i;
            String temp = p.s;
            if(temp.equals(endWord)) return distance;
            for(int i=0; i<beginWord.length(); i++){
                char tempArray[] = temp.toCharArray();
                for(char c='a'; c <= 'z'; c++){
                    tempArray[i] = c;
                    String newStr = new String(tempArray);
                    if(set.contains(newStr)){
                        q.add(new Pair(newStr, distance + 1));
                        set.remove(newStr);
                    }
                }
            }
            distance++;
        }
        return max;

    }
}
