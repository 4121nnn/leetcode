func minimumTime(grid [][]int) int {
    if grid[0][1] > 1 && grid[1][0] > 1 {
        return -1
    }

    R, C := len(grid), len(grid[0])
    q := &Pq{}
    heap.Init(q)
    heap.Push(q, Cell{0, 0, 0})
    dirs := [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}

    seen := make([][]bool, R)
    for i := range seen {
        seen[i] = make([]bool, C)
    }
    seen[0][0] = true

    for q.Len() > 0 {
        cur := heap.Pop(q).(Cell)
        if cur.x == R - 1 && cur.y == C - 1 {
            return cur.t
        }
        for _, d := range dirs {
            x := cur.x + d[0]
            y := cur.y + d[1]

            if x >= 0 && y >= 0 && x < R && y < C && !seen[x][y] {
                seen[x][y] = true
                if cur.t + 1 < grid[x][y] {
                    z := grid[x][y] - cur.t - 1
                    if z % 2 != 0 {
                        z++
                    }
                    heap.Push(q, Cell{x, y, cur.t + z + 1})
                } else{
                    heap.Push(q, Cell{x, y, cur.t + 1})
                }
            }
        }
    }
    return -2
}

type Cell struct {
    x, y, t int
}

type Pq []Cell

func (q Pq) Len() int { return len(q) }
func (q Pq) Less(i, j int) bool { return q[i].t < q[j].t }
func (q Pq) Swap(i, j int) { q[i], q[j] = q[j], q[i] }
func (q *Pq) Push(x interface{}) { *q = append(*q, x.(Cell)) }
func (q *Pq) Pop() interface{} { 
    old := *q
    n := len(old)
    item := old[n-1]
    *q = old[0 : n-1]
    return item
}
