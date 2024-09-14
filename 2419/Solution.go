func longestSubarray(nums []int) int {
    max, cur, res := 0, 0, 0
    for _, i := range nums {
        if max < i {
            max = i
        }
    }
    for _, i := range nums {
        if i == max {
            cur++
            if cur > res {
                res = cur
            }
        }else{
            cur = 0
        }
    }
    return res
}
