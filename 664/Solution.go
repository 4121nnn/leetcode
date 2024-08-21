func strangePrinter(s string) int {
    nextInd := nextOccurrence(s)
    n := len(nextInd)
    memo := make([][]int, n)
    for i := range memo{
        memo[i] = make([]int, n)
        for j := range memo { memo[i][j] = -1 }
    }
    var compute func(start, end int) int;
    compute = func(start, end int) int{
        if start > end { return 0 }
        if memo[start][end] != -1 { return memo[start][end] }

        min := 1 + compute(start + 1, end)

        nextOccurInd := nextInd[start]

        for nextOccurInd != -1 && nextOccurInd <= end{
            cur := compute(start, nextOccurInd -1) + compute(nextOccurInd + 1, end)
            if min > cur { min = cur }
            nextOccurInd = nextInd[nextOccurInd]
        }
        memo[start][end] = min
        return min
    }
    
    return compute(0, n-1)
}

func nextOccurrence(s string) []int{
    var noDup []rune
    for i := range s {
        noDup = append(noDup, rune(s[i]))
        j := i
        for i < len(s) && s[i] == s[j]{
            i++
        }
    }

    res := make([]int, len(noDup))
    mapInd := make([]int, 26);
    for i := range mapInd { mapInd[i] = -1 }

    for i := len(res) - 1; i >= 0; i--{
        res[i] = mapInd[noDup[i]- 'a']
        mapInd[noDup[i] - 'a'] = i
    }
    return res
}

