func maximumLength(s string) int {
    i, n := 0, len(s)
    arr := make([][]int, 26)
    for j := range arr {
        arr[j] = make([]int, 3)
    }
    for i < n {
        cur := s[i]
        start := i
        i++ 
        for i < n && cur == s[i] { i++ }
        sort.Ints(arr[cur - 'a'])
        arr[cur - 'a'][0] = max(arr[cur - 'a'][0], i - start)
    }
    res := 0
    for _, r := range arr {
        sort.Ints(r)
        a, b, c := r[0], r[1], r[2]
        if a == b && a == c { res = max(res, a) }

        if c == b + 1 || c == b { 
            res = max(res, c - 1)
        } else { res = max(res, c - 2) }
    }
    if res == 0 {
        return  -1
    }
    return res
}
