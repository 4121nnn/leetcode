func takeCharacters(s string, k int) int {
    a := make([]int, 3)
    res, n := math.MaxInt, len(s)
    for _, c := range s {
        a[c - 'a']++
    }

    if a[0] < k || a[1] < k || a[2] < k {
        return -1
    }
    
    for l, r := 0, 0; r < n; r++ {
        a[s[r] - 'a']--

        for l < n && a[0] < k || a[1] < k || a[2] < k {
            a[s[l] - 'a']++
            l++
        }

        res = min(res, n - (r - l + 1))
    }

    return res
}
