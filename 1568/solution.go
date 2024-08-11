package main

func minDays(grid [][]int) int {
	if count(grid) != 1 {
		return 0
	}
	for i, row := range grid {
		for j, cell := range row {
			if cell == 1 {
				grid[i][j] = 0
				if count(grid) != 1 {
					return 1
				}
				grid[i][j] = 1
			}
		}
	}
	return 2
}
func count(grid [][]int) int {
	count := 0
	seen := make([][]bool, len(grid))
	for i := range seen {
		seen[i] = make([]bool, len(grid[0]))
	}

	for i, row := range grid {
		for j, cell := range row {
			if cell == 1 && !seen[i][j] {
				dfs(grid, i, j, seen)
				count++
			}
		}
	}
	return count
}
func dfs(grid [][]int, i int, j int, seen [][]bool) {
	if i < 0 || j < 0 || i >= len(grid) || j >= len(grid[0]) ||
		grid[i][j] == 0 || seen[i][j] {
		return
	}
	seen[i][j] = true
	dfs(grid, i+1, j, seen)
	dfs(grid, i-1, j, seen)
	dfs(grid, i, j-1, seen)
	dfs(grid, i, j+1, seen)
}
