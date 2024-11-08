func getMaximumXor(nums []int, maximumBit int) []int {
    x, n, max := 0, len(nums), (1 << maximumBit) - 1

    for _, i := range nums {
        x ^= i
    }

    a := make([]int, n)
    for i, _ := range nums {
        a[i] = x ^ max
        x ^= nums[n - i - 1]
    }

    return a
}
