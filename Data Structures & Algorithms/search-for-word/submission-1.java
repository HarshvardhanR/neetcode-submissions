class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board, word, 0, i, j, new boolean[board.length][board[0].length])) return true;
                }
                
            }
        }

        return false;
    }

    public boolean helper(char[][] board, String word, int index, int i, int j, boolean visited[][]){
        if(index>=word.length()) return true;
        if(i>=board.length || j>=board[0].length || i<0 || j<0 || board[i][j]!= word.charAt(index) || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        boolean down =  helper(board, word, index + 1, i+1, j, visited);
        boolean up = helper(board, word, index + 1, i - 1, j, visited); 
        boolean right = helper(board, word, index + 1, i, j + 1, visited);
        boolean left =  helper(board, word, index + 1, i, j - 1, visited);
        visited[i][j] = false;

        return down || up || right || left;
    }
}
