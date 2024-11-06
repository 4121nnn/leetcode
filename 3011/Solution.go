func canSortArray(nums []int) bool {
    minN, maxN, prevMax, bits := nums[0], nums[0], 0, countBits(nums[0])
    for _, num := range nums {
        if countBits(num) == bits {
            minN, maxN = min(minN, num), max(maxN, num)
        } else {
            if prevMax > minN {
                return false
            }
            prevMax = maxN
            minN, maxN = num, num
            bits = countBits(num)
        }
    }
    return prevMax < minN
}

func countBits(num int) int {
    count := 0
    for num > 0 {
        count += num & 1
        num >>= 1
    }
    return count
}
