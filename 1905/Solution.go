func countSubIslands(grid1 [][]int, grid2 [][]int) int {
    res := 0
    for i, row := range grid2{
        for j, col := range row{
            if col == 1 {
                b := true
                dfs(grid1, grid2, i, j, &b)
                if b { res++ }
            }
        }
    }
    return res
}

func dfs(grid1, grid2 [][] int, i, j int, b *bool) {
    if i < 0 || j < 0 || i >= len(grid1) || j >= len(grid1[0]) || grid2[i][j] == 0 {
        return
    }
    grid2[i][j] = 0
    if grid1[i][j] == 0 { *b = false }
    dfs(grid1, grid2, i + 1, j, b)
    dfs(grid1, grid2, i - 1, j, b)
    dfs(grid1, grid2, i, j + 1, b)
    dfs(grid1, grid2, i, j - 1, b)
}
