func slidingPuzzle(board [][]int) int {
    hm := make(map[string]bool)
    q := make([]string, 0)
    s , target := "", "123450"
    for _, r := range board {
        for _, val := range r {
            s += strconv.Itoa(val)
        }
    }

    hm[s] = true
    q = append(q, s)

    step := 0
    dir := [6][]int{{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}}

    for len(q) > 0 {
        size := len(q)
        for size > 0 {
            cur := q[0]
            q = q[1:]
            if cur == target {
                return step
            }
            zeroInd := strings.IndexRune(cur, '0')
            for _, i:= range dir[zeroInd] {
                ss:= []byte(cur)
                ss[zeroInd], ss[i] = ss[i], ss[zeroInd]
                next := string(ss)
                if !hm[next] {
                    hm[next] = true
                    q = append(q, next)
                }
            }
            size--
        }
        step++
    }
    return -1
}
