func countKConstraintSubstrings(s string, k int) int {
    res, a, b := 0, 0, 0
    for i, _ := range s{
        a = 0; b = 0
        for j := i; j < len(s); j++ {
            if s[j] == '0' { a++ } else { b++ }

            if a > k && b > k { break }
            res++
        }
    }
    return res
}
