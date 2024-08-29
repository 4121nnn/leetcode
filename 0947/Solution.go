func removeStones(stones [][]int) int {
    n := len(stones)
    uf := NewUnionFind(n)

    rows := make([]int, 10001)
    cols := make([]int, 10001)

    for i := 0; i< len(rows); i++{
        rows[i] = -1
        cols[i] = -1
    }

    for i := 0; i < n; i++ {
        r, c := stones[i][0], stones[i][1]

        if rows[r] != -1 {
            uf.union(rows[r], i)
        }else {
            rows[r] = i
        }
        
        if cols[c] != -1 {
            uf.union(cols[c], i)
        }else {
            cols[c] = i
        }
    }

    res := 0
    for i := 0; i < n ; i++{
        if uf.find(i) == i {
            res += uf.getSize(i) - 1
        }
    }
    return res
}
type UnionFind struct{
    parent  []int
    rank    []int
    size    []int
}
func NewUnionFind(n int) *UnionFind {
    uf := &UnionFind{
        parent: make([]int, n),
        rank:   make([]int, n),
        size:   make([]int, n),
    }
    for i := 0; i < n; i++ {
        uf.parent[i] = i
        uf.rank[i] = 1
        uf.size[i] = 1
    }
    return uf

}
func (uf *UnionFind) find(x int) int {
    if uf.parent[x] != x{
        uf.parent[x] = uf.find(uf.parent[x])
    }
    return uf.parent[x]
}

func (uf *UnionFind) union(x, y int){
    rootX, rootY := uf.find(x), uf.find(y)

    if rootX == rootY {
        return
    }

    if uf.rank[rootX] < uf.rank[rootY] {
        uf.parent[rootX] = rootY
        uf.size[rootY] += uf.size[rootX]
    }else if uf.rank[rootX] > uf.rank[rootY] {
        uf.parent[rootY] = rootX
        uf.size[rootX] += uf.size[rootY]
    }else {
        uf.parent[rootY] = rootX
        uf.rank[rootX]++
        uf.size[rootX] += uf.size[rootY]
    }
}

func (uf * UnionFind) getSize(x int) int {
    return uf.size[uf.find(x)]
}
