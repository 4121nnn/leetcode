func minBitFlips(start int, goal int) int {
    count, dif := 0, start ^ goal
    for dif > 0 {
        count += dif & 1
        dif >>= 1
    }
    return count
}
