class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean b;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        for(int i = 0; i < grid2.length; i++){
            for(int j = 0; j < grid2[0].length; j++){
                if(grid2[i][j] == 1){
                    b = true;
                    dfs(grid1, grid2, i, j);
                    if(b) res++;
                }
            }
        }
        return res;
    }
    void dfs(int[][] grid1, int[][] grid2, int i, int j){
        if(i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length || grid2[i][j] == 0){
            return ;
        }
        grid2[i][j] = 0;

        if(grid1[i][j] != 1) b = false;
        for(int[] dir : dirs)
            dfs(grid1, grid2, i + dir[0], j + dir[1]);
        
    }
}
// time O(nm)
// space O(nm)
