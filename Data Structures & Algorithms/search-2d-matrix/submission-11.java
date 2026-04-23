class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j=matrix[i].length-1;

        while(i<matrix.length && j>=0){
            if(matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]>target && j>0){
                j--;
                break;
            }
            else if(matrix[i][j]<target && i<matrix.length-1){
                i++;
            }
            else{
                return false;
            }
        } 

        for(int k=j; k>=0; k--){
            if(matrix[i][k]==target){
                return true;
            }
        }
        return false;
    }
}
