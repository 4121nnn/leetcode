func findChampion(n int, edges [][]int) int {
    a := make([]int, n)
    for _, r := range edges {
        a[r[1]]++
    }
    res := -1
    for i, n := range a {
        if n == 0 {
            if res != -1 {
                return -1
            }
            res = i
        }
    }
    return res
}
