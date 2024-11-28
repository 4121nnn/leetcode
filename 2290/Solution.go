func minimumObstacles(grid [][]int) int {
    R, C := len(grid), len(grid[0])
    dir := [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}
    visited := make([][]bool, R)
    for i := 0; i < R; i++ {
        visited[i] = make([]bool, C)
    }

    q := list.New()
    q.PushBack([]int{0, 0, 0})

    for q.Len() > 0 {
        cur := q.Front().Value.([]int)
        q.Remove(q.Front())

        for _, d := range dir {
            rr := cur[0] + d[0]
            cc := cur[1] + d[1]
            if rr == R - 1 && cc == C - 1 {
                return cur[2]
            } 
            if rr >= 0 && cc >= 0 && rr < R && cc < C && !visited[rr][cc] {
                visited[rr][cc] = true
                if grid[rr][cc] == 1 {
                    q.PushBack([]int{rr, cc, cur[2] + 1})
                } else {
                    q.PushFront([]int{rr, cc, cur[2]})
                }
            }
        }
    }
    return -1
}
