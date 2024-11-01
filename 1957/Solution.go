func makeFancyString(s string) string {
    var prev rune
    var res strings.Builder
    freq := 0

    for _, c := range s {
        if c == prev {
            freq++
        } else {
            freq = 1
            prev = c
        }
        if freq < 3 {
            res.WriteRune(c)
        }
    }

    return res.String()
}
