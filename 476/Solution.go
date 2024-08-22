func findComplement(num int) int {
    mask, temp := 0, num
    for temp != 0 {
        mask = (mask << 1) | 1
        temp >>= 1
    }
    return num ^ mask
}
