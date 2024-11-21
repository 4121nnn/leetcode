func countUnguarded(m int, n int, guards [][]int, walls [][]int) int {
    a := make([][]int, m)
    for i := 0; i < m; i++ {
        a[i] = make([]int, n)
    }

    for _, r := range guards {
        x, y := r[0], r[1]
        a[x][y] = 1
    }

    for _, r := range walls {
        a[r[0]][r[1]] = 1
    }
    dir := [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}

    res := m * n - len(guards) - len(walls)
    for _, g := range guards {
        for _, d := range dir {
            x := g[0] + d[0]
            y := g[1] + d[1]
            for (x >= 0 && x < m) && (y >= 0 && y < n) {
                if a[x][y] == 1 {
                    break
                }
                if a[x][y] != 2 {
                    res--
                    a[x][y] = 2
                }
                x += d[0]
                y += d[1]
            }
        }
    }

    return res
}
