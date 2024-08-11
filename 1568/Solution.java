class Solution {
    public int minDays(int[][] grid) {
        if(count(grid) != 1) return 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if(count(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
    
        return 2;
    }
    int count(int[][] grid){
        int count = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !seen[i][j]){
                    dfs(grid, i, j, seen);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(int[][] grid, int i, int j, boolean[][] seen){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1 || seen[i][j]){
            return;
        }
        seen[i][j] = true;
        dfs(grid, i, j + 1, seen);
        dfs(grid, i, j - 1, seen);
        dfs(grid, i + 1, j, seen);
        dfs(grid, i - 1, j, seen);
    }
}