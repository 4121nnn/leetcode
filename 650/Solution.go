func minSteps(n int) int {
    return count(n, 0)
}

func count(n , res int) int{
    if n == 1 { return res }
    x := n / 2
    for n % x != 0 { x-- }
    res += n / x
    return count(x , res)
}
