func clumsy(n int) int {
    res := n
    n--
    if n > 0 {
        res *= n
        n--
    }
    if n > 0 { 
        res /= n
        n--
    }
    if n > 0 {
        res += n
        n--
    }
    for n > 0 {
        
        cur := n
        n--
        if n > 0 {
            cur *= n
            n--
        }
        if n > 0 {
            cur /= n
            n--
        }
        res -= cur
        if n > 0 {
            res += n
            n--
        }
    }
    return res
}
