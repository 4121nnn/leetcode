func canChange(s string, t string) bool {
    l, r := 0, 0
    for i := 0; i < len(s); i++ {
        if s[i] == 'R' {
            r++
            if l > 0 {
                return false
            }
        }
        if t[i] == 'L' {
            if r > 0 {
                return false
            }
            l++
        }

        if t[i] == 'R' {
            if r == 0 {
                return false
            }
            r--
        }

        if s[i] == 'L' {
            if l == 0 {
                return false
            }
            l--
        }

    }
    return l == 0 && r == 0
}
