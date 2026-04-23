class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean [][] visit = new boolean[rows][cols];
        Queue<Point> q = new LinkedList<>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==0){
                    q.add(new Point(i, j));
                    visit[i][j] = true;
                }
            }
        }

        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                Point p = q.poll();
                grid[p.i][p.j] = dist;
                addrooms(p.i + 1, p.j, grid, visit, q);
                addrooms(p.i - 1, p.j, grid, visit, q);
                addrooms(p.i, p.j + 1, grid, visit, q);
                addrooms(p.i, p.j - 1, grid, visit, q);
            }
            dist++;
        }
    }

    public void addrooms(int r, int c, int[][] grid, boolean[][] visit, Queue<Point> q){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==-1 || visit[r][c]==true){
            return;
        }
        q.add(new Point(r,c));
        visit[r][c] = true;
    }
}

class Point{
    int i;
    int j;
    public Point(int i, int j){
        this.i = i;
        this.j = j;
    }
}
