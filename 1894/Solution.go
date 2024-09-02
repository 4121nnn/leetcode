func chalkReplacer(chalk []int, k int) int {
    sum := 0
    for _, val := range chalk {
        sum += val
    }
    sum = k % sum
    for i, val := range chalk {
        sum -= val
        if sum < 0 {
            return i
        }
    }
    return -1
}
