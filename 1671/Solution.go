func minimumMountainRemovals(nums []int) int {
    n := len(nums)
    l := make([]int, n)
    r := make([]int, n)

    for i := 0; i < n; i++ {
        l[i] = 1
        for j := 0; j < i; j++ {
            if nums[i] > nums[j] {
                l[i] = max(l[i], l[j] + 1)
            }
        }
    }

    for i := n-1; i >= 0; i-- {
        r[i] = 1
        for j := n-1; j > i; j-- {
            if nums[i] > nums[j] {
                r[i] = max(r[i], r[j] + 1)
            }
        }
    }

    maxMountain := 0
    for i := 1; i < n-1; i++ {
        if l[i] > 1 && r[i] > 1 {
            maxMountain = max(maxMountain, l[i] + r[i])
        }
    }
    return n - maxMountain + 1
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
