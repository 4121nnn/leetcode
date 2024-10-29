class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int j = 1; j< m; j++){
            boolean moved = false;
            for(int i = 0; i < n; i++){
                if(grid[i][j-1] < grid[i][j] ||
                    (i > 0 && grid[i-1][j-1] < grid[i][j]) || 
                    (i < n - 1 && grid[i+1][j-1] < grid[i][j])){
                    moved = true;
                }else{
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
            if(!moved) return j-1;
        }
        return m-1;
    }
}
