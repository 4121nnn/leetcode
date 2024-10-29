func maxMoves(grid [][]int) int {
    n, m := len(grid), len(grid[0])
    for j := 1; j < m; j++ {
        moved := false
        for i := 0; i < n; i++ {
            if grid[i][j-1] < grid[i][j] ||
                (i > 0 && grid[i-1][j-1] < grid[i][j]) || 
                (i < n-1 && grid[i+1][j-1] < grid[i][j]) {
                    moved = true
            } else {
                grid[i][j] = math.MaxInt32
            }
        }
        if !moved {
            return j - 1
        }
    }
    return m - 1
}
