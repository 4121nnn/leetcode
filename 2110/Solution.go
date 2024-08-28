func getDescentPeriods(prices []int) int64 {
    var res int64 = 1
    var cur int64 = 1
    for i := 1; i < len(prices); i++ {
        if prices[i] == prices[i-1] - 1{
            cur++
        }else{
            cur = 1
        }
        res += cur
    }
    return res
}
