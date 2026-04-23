class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0; i<board.length; i++){
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> subgridSet = new HashSet<>();
            for(int j=0; j<board.length; j++){
                if(board[i][j]!='.'){
                    if(rowSet.add(board[i][j])==false){
                        return false;
                    }
                }
                if(board[j][i]!='.'){
                    if(colSet.add(board[j][i])==false){
                        return false;
                    }
                }

                int subgridRow = 3 * (i / 3); 
                int subgridCol = 3 * (i % 3); 
                if (board[subgridRow + j / 3][subgridCol + j % 3] != '.') {
                    if (!subgridSet.add(board[subgridRow + j / 3][subgridCol + j % 3])) {
                        return false;
                    }
                }
            }
        }

        return true;
        
    }
}
