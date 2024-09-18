func largestNumber(nums []int) string {
    sort.Slice(nums, func(i, j int) bool {
        a := strconv.Itoa(nums[i])
        b := strconv.Itoa(nums[j])
        return a + b > b + a
    })

    var res strings.Builder

    for _, num := range nums {
        res.WriteString(strconv.Itoa(num))
    }

    if res.String()[0] == '0' {
        return "0"
    }
    return res.String()
}
