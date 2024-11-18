func decrypt(code []int, k int) []int {
    n := len(code)
    res := make([]int, n)

    for i := 0; i < n; i++ {
        if k > 0 {
            for j := i + 1; j <= i + k; j++ {
                res[i] += code[j % n]
            }
        } else if k < 0 {
            for j := i - 1; j >= i + k; j-- {
                res[i] += code[((j % n) + n) % n]
            }
        }
    }
    return res
}
