func maxTwoEvents(events [][]int) int {
    bs := func(t int) int {
        l, r := 0, len(events) -1
        for l <= r {
            m := l + (r - l) / 2
            if events[m][0] > t {
                r = m - 1
            } else {
                l = m + 1
            }
        }
        return l
    }
    sort.Slice(events, func(i, j int) bool {
        return events[i][0] < events[j][0]
    })
    n := len(events)
    a := make([]int, n + 1)
    for i := n - 1; i >= 0; i-- {
        a[i] = max(a[i + 1], events[i][2])
    }
    res := 0
    for _, row := range events {
        j := bs(row[1])
        res = max(res, a[j] + row[2])
    }

    return res
}
