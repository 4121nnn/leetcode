func isArraySpecial(nums []int, queries [][]int) []bool {
    a := make([]int, len(nums))
    for i := 1; i < len(nums); i++ {
        a[i] = a[i-1]
        if nums[i] & 1 == nums[i-1] & 1 {
            a[i]++
        }
    }
    res := make([]bool, len(queries))
    for i, q := range queries {
        if a[q[0]] == a[q[1]] {
            res[i] = true
        }
    }
    return res
}
