func minIncrementForUnique(nums []int) int {
    max, res  := 0, 0
    for _, i := range nums { if i > max { max = i } }
    m := make([]int, max + 1 + len(nums))
    for _, i := range nums { m[i]++ }
    for i := range m {
        if m[i] > 1 {
            res += m[i] - 1
            m[i + 1] += m[i] - 1
        }
    }
    return res
}
