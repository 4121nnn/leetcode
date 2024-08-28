/**
 * @param {number[][]} grid1
 * @param {number[][]} grid2
 * @return {number}
 */
var countSubIslands = function(grid1, grid2) {
    let b = true;
    let res = 0;
    const dfs = (grid1, grid2, i, j) => {
        if(i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length || 
            grid2[i][j] == 0) {
            return;
        }
        grid2[i][j] = 0;
        if(grid1[i][j] == 0) b = false;

        dfs(grid1, grid2, i + 1, j);
        dfs(grid1, grid2, i - 1, j);
        dfs(grid1, grid2, i, j + 1);
        dfs(grid1, grid2, i, j - 1);
    }

    for(let i = 0; i < grid1.length; i++){
        for(let j = 0; j < grid1[0].length; j++){
            if(grid2[i][j] == 1){
                b = true;
                dfs(grid1, grid2, i, j);
                if( b )  res++;
            }
        }
    }
    return res;
};
