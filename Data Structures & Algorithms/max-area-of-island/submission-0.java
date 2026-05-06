class Solution {
    int max = 0;
    boolean visited[][];
    int m;
    int n;
    int grid[][];
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    dfs(i, j);
                }
            }
        }

        return max;
    }

    public int dfs(int i, int j){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0 || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        int maxVal = 1 + dfs(i+1, j) + dfs(i-1, j) + dfs(i, j+1) + dfs(i, j-1);
        max = Math.max(max, maxVal);
        return maxVal;
    }
}
